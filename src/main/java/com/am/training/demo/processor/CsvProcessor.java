package com.am.training.demo.processor;

import com.am.training.demo.entity.DataItem;
import com.am.training.demo.service.DataItemService;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvProcessor {

    private static final Logger logger = LoggerFactory.getLogger(CsvProcessor.class);
    @Autowired
    private DataItemService service;

    public List<DataItem> loadData() throws IOException {
        logger.debug("Starting to read Data");
        return get();
    }

    public List<DataItem> loadData(String fileName) throws IOException {
        logger.debug("Starting to read Data");
        return getItems(fileName);
    }


    private List<DataItem> get() throws IOException {
        List<DataItem> rows = new ArrayList<>();

        final String fileName = "data.csv";

        File file = new ClassPathResource(fileName).getFile();
        String fileName2 = file.getPath();
        File csvFile = new File(fileName2);
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
        MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvFile);
        while (it.hasNext()) {
            Map<String, String> rowAsMap = it.next();
            String redner = rowAsMap.get("Redner").trim();
            String thema = rowAsMap.get("Thema").trim();
            String datum = rowAsMap.get("Datum").trim();
            String wortern = rowAsMap.get("Wörter").trim();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(datum, formatter);

            Integer worternInt = Integer.parseInt(wortern);
            rows.add(new DataItem(0, redner, thema, localDate, worternInt));

        }

        return rows;
    }


    private List<DataItem> getItems(String fileName) throws IOException {
        List<DataItem> rows = new ArrayList<>();
    logger.info("The filename that arrived at get method: " +fileName);

        File csvFile = new File(fileName);
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
        MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
                .with(schema)
                .readValues(csvFile);
        while (it.hasNext()) {
            Map<String, String> rowAsMap = it.next();
            String redner = rowAsMap.get("Redner").trim();
            String thema = rowAsMap.get("Thema").trim();
            String datum = rowAsMap.get("Datum").trim();
            String wortern = rowAsMap.get("Wörter").trim();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(datum, formatter);

            Integer worternInt = Integer.parseInt(wortern);
            rows.add(new DataItem(0, redner, thema, localDate, worternInt));

        }

        return rows;
    }

}
