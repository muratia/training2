package com.am.training.demo.processor;

import com.am.training.demo.entity.Person;
import com.am.training.demo.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CvsProcessor {


    private static final Logger logger = LoggerFactory.getLogger (CvsProcessor.class);
    private static final String COMMA_DELIMITER = ",";

    /**
     *  Reades the CVS file by given fileName
     * @param fileName the file name
     * @return List<Person>
     * @throws IOException Throws IOException in case the file does not exist or it is locked
     */
    public static List<Person> read(String fileName) throws IOException {
        List<Person> persons = new ArrayList<> ();
        FileUtils fu = new FileUtils ();
        List<String> linesStr = fu.getStrings (fileName); // loading of the CVS after it is normalized
        logger.info (Arrays.deepToString (linesStr.toArray ()));

        for (String line : linesStr) { // for each line in the string
            String[] values = line.split (COMMA_DELIMITER); // we split the text by predefined delimiter
            Person p = new Person ();
            if (values.length == 4) {
                p.setId (0L); // initialization with default value 0
                p.setName (values[0].trim ()); // sets the first name after the content is trimmed
                p.setLastName (values[1].trim ()); // sets the last name after the content is trimmed
                String zip = values[2].replaceAll ("[^0-9]", ""); // extraction of the zip code for
                // alphanumeric string
                String city = values[2].replaceAll ("[\\d-]", "").trim (); // extraction of the text
                p.setZipCode (zip); // passing the Zip Code
                p.setCity (city); // passing of the City
                p.setColor (Integer.parseInt (values[3])); // sets the color
            }
            persons.add (p);
        }
        return persons;
    }
}
