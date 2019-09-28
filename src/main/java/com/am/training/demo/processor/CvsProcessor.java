package com.am.training.demo.processor;

import com.am.training.demo.entity.Person;
import com.am.training.demo.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CvsProcessor {


    private static final Logger logger = LoggerFactory.getLogger (CvsProcessor.class);
    private static final String COMMA_DELIMITER = ",";


    public static List<Person> read(String fileName) throws IOException {
        List<Person> persons = new ArrayList<> ();
        FileUtils fu = new FileUtils ();
        List<String> linesStr = fu.getStrings (fileName);
        logger.info (Arrays.deepToString (linesStr.toArray ()));

        for (String line : linesStr) {
            String[] values = line.split (COMMA_DELIMITER);
            Person p = new Person ();
            if (values.length == 4) {
                p.setId (0L);
                p.setName (values[0].trim ());
                p.setLastName (values[1].trim ());
                String zip = values[2].replaceAll ("[^0-9]", "");
                String city = values[2].replaceAll ("[\\d-]", "").trim ();
                p.setZipCode (zip);
                p.setCity (city);
                p.setColor (Integer.parseInt (values[3]));
            }
            persons.add (p);
        }
        return persons;
    }
}
