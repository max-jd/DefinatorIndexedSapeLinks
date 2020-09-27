package com.gmailAtpavlinichm.maxim.search.text;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class TextWriter implements Writer {

    public void writeTexts(Path pathToWrite, List<Map.Entry<String, String>> textsWithDomainsToWrite) {

        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(pathToWrite)) {

            for(Map.Entry<String, String> entryTextWithDomain : textsWithDomainsToWrite) {

                    String text = entryTextWithDomain.getKey();
                    String domain = entryTextWithDomain.getValue();
                    bufferedWriter.write(text + " " + domain);
                    bufferedWriter.newLine();

            }

        } catch(IOException ex) {
            System.out.println(this.getClass());
            ex.printStackTrace();
        }
    }

}
