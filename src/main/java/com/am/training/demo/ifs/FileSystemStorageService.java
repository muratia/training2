package com.am.training.demo.ifs;

import com.am.training.demo.entity.DataItem;
import com.am.training.demo.exception.EmptyListException;
import com.am.training.demo.processor.CsvProcessor;
import com.am.training.demo.service.DataItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


@Service
public class FileSystemStorageService implements StorageService {

    private static final Logger logger = LoggerFactory.getLogger(FileSystemStorageService.class);
    private final Path rootLocation;

    @Autowired
    private DataItemService dataItemService;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) throws IOException {

       File fileHome=  FileSystemView.getFileSystemView().getHomeDirectory();

       String homePathWithUploads = fileHome.getAbsolutePath()+properties.getLocation();
        this.rootLocation = Paths.get(homePathWithUploads);
        if(!Files.exists(this.rootLocation)){


            Files.createDirectory(rootLocation);
            logger.info("Upload folder created "+ rootLocation.toAbsolutePath());
        }
    }

    @Override
    public void store(MultipartFile file) {
        logger.info("Trying to store file");
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
                String path = this.rootLocation.resolve(filename).toAbsolutePath().toString();
                logger.info("File Path: " + path);


                logger.info("Starting to store in database");
                CsvProcessor csvProcessor = new CsvProcessor();

                List<DataItem> items = csvProcessor.loadData(path);
                this.dataItemService.save(items);
                logger.info("Data are saved");
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
