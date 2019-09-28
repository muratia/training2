package com.am.training.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"ALL", "DuplicateExpressions"})
public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger (FileUtils.class);


    /**
     * This reads the content of the broken CVS
     *
     * @param path File path of the CVS
     * @return returns List<Strings>
     * @throws IOException Throws an IOException in case the file does not exist
     */
    private List<String> readFile(String path) throws IOException {
        return Files.readAllLines (Paths.get (path), StandardCharsets.UTF_8);
    }

    /**
     * Returns the lines of the normalized CSV
     *
     * @param fileName File name of the CSV file
     * @return Lines of normalized CSV
     * @throws IOException Throws an IOException in case the file does not exist
     */
    public List<String> getStrings(String fileName) throws IOException {

        List<String> items = readFile (fileName);
        String text = String.join ("", items);

        return normalizeCsv (text + " ");
    }

    /**
     * Normalizes a broken CSV based on the technical requirement
     *
     * @param text - the broken CSV content
     * @return List<String> normalized lines of CSV
     */
    private List<String> normalizeCsv(String text) {
        logger.info ("Text = " + text);
        List<String> rr = new ArrayList<> ();

        StringBuilder line = new StringBuilder ();
        for (int i = 0; i < text.length (); i++) {

            String curr = "" + text.charAt (i);
            line.append (curr);
            try {

                if (text.charAt (i - 1) == ',' && (curr + " ").equals ("1 ") && (text.charAt (i + 1) == ' ' || Character.isAlphabetic (text.charAt (i + 1)))) {
                    rr.add (line.toString ());
                    line = new StringBuilder ();
                } else if (text.charAt (i - 1) == ',' && (curr + " ").equals ("2 ") && (text.charAt (i + 1) == ' ' || Character.isAlphabetic (text.charAt (i + 1)))) {
                    rr.add (line.toString ());
                    line = new StringBuilder ();
                } else if (text.charAt (i - 1) == ',' && (curr + " ").equals ("3 ") && (text.charAt (i + 1) == ' ' || Character.isAlphabetic (text.charAt (i + 1)))) {
                    rr.add (line.toString ());
                    line = new StringBuilder ();
                } else if (text.charAt (i - 1) == ',' && (curr + " ").equals ("4 ") && (text.charAt (i + 1) == ' ' || Character.isAlphabetic (text.charAt (i + 1)))) {
                    rr.add (line.toString ());
                    line = new StringBuilder ();
                } else if (text.charAt (i - 1) == ',' && (curr + " ").equals ("5 ") && (text.charAt (i + 1) == ' ' || Character.isAlphabetic (text.charAt (i + 1)))) {
                    rr.add (line.toString ());
                    line = new StringBuilder ();
                } else if (text.charAt (i - 1) == ',' && (curr + " ").equals ("6 ") && (text.charAt (i + 1) == ' ' || Character.isAlphabetic (text.charAt (i + 1)))) {
                    rr.add (line.toString ());
                    line = new StringBuilder ();
                } else if (text.charAt (i - 1) == ',' && (curr + " ").equals ("7 ") && (text.charAt (i + 1) == ' ' || Character.isAlphabetic (text.charAt (i + 1)))) {
                    rr.add (line.toString ());
                    line = new StringBuilder ();
                }

            } catch (Exception ex) {
                //System.out.println(ex.getMessage());
            }

        }
        return rr;
    }


}
