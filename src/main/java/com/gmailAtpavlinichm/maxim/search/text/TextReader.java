package com.gmailAtpavlinichm.maxim.search.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TextReader implements Reader{
    public List<Map.Entry<String, String>> readTexts(Path pathTxtFile) {

        List<Map.Entry<String, String>> resultListTexts = new ArrayList<>();

        try(BufferedReader bufferedReader = Files.newBufferedReader(pathTxtFile, Charset.forName("UTF-8"))) {

            String newLine = null;

            while((newLine = bufferedReader.readLine()) != null
                    && (!newLine.equals(""))) {

                //if there is garbage that we got by copy past and Excel-effect
                newLine = newLine.replace("\uFEFF", "");
                int indexOfDomain = newLine.indexOf("\t");

                if (indexOfDomain < 0) {
                    throw new RuntimeException("Copied was not from an Excel-table.");
                }

                // excluding \t
                String seoText = newLine.substring(0, indexOfDomain);
                String domain = newLine.substring(indexOfDomain + 1, newLine.length());
                Entry<String, String> newEntry = new SimpleEntry<>(seoText, domain);
                resultListTexts.add(newEntry);
            }

        } catch(IOException ex) {
            System.out.println(this.getClass());
            ex.printStackTrace();
        }

        return resultListTexts;

    }
}
