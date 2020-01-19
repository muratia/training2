package com.am.training.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);


    /**
     * This reads the content of the broken CVS
     *
     * @param path File path of the CVS
     * @return returns List<Strings>
     * @throws IOException Throws an IOException in case the file does not exist
     */
    private List<String> readFile(String path) throws IOException {
        logger.debug("Trying to read CSV");
        return Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
    }

    /**
     * Returns the lines of the CSV
     *
     * @param fileName File name of the CSV file
     * @return Lines of CSV
     * @throws IOException Throws an IOException in case the file does not exist
     */
    public List<String> getStrings(String fileName) throws IOException {
        return readFile(fileName);
    }
}
