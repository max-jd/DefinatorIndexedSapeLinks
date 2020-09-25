package com.gmailAtpavlinichm.maxim.search.text;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class TextWriter implements Writer {

    public void writeTexts(Path pathToWrite, Map<String, Boolean> textsToWrite) {

        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(pathToWrite)) {

            Set<Map.Entry<String, Boolean>> setEntryTextsToWrite = textsToWrite.entrySet();
            for(Map.Entry<String, Boolean> entry : setEntryTextsToWrite) {
                //if a link is not in index of a search engine we write this text with an anchor
                if(!entry.getValue()) {
                    bufferedWriter.write(entry.getKey());
                    bufferedWriter.newLine();
                }
            }

        } catch(IOException ex) {
            System.out.println(this.getClass());
            ex.printStackTrace();
        }
    }

}
