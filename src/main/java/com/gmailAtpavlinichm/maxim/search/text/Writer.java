package com.gmailAtpavlinichm.maxim.search.text;


import java.nio.file.Path;
import java.util.Map;

public interface Writer {
    public void writeTexts(Path pathToWrite, Map<String, Boolean> textsToWrite);
}
