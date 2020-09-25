package com.gmailAtpavlinichm.maxim.search.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextReader implements Reader{
    public Map<String, String> readTexts(Path pathTxtFile) {

        Map<String, String> resultTexts = new HashMap<>();

        try(BufferedReader bufferedReader = Files.newBufferedReader(pathTxtFile, Charset.forName("UTF-8"))) {

            String newLine = null;

            while((newLine = bufferedReader.readLine()) != null
                    && (!newLine.equals(""))) {

                //if there is garbage that we got by copy past and Excel-effect
                newLine = newLine.replace("\uFEFF", "");
                System.out.println(newLine);
                int indexOfDomain = newLine.indexOf("\t");

                if (indexOfDomain < 0) {
                    throw new RuntimeException("It's not a domain with http(s)");
                }

                // excluding \t
                String seoText = newLine.substring(0, indexOfDomain);
                String domain = newLine.substring(indexOfDomain + 1, newLine.length());
                resultTexts.put(seoText, domain);
            }

        } catch(IOException ex) {
            System.out.println(this.getClass());
            ex.printStackTrace();
        }

        return resultTexts;

    }
}
