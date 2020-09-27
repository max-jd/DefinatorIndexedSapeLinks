package com.gmailAtpavlinichm.maxim.search.text;


import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface Writer {
    public void writeTexts(Path pathToWrite, List<Map.Entry<String, String>> textsWithDomainsToWrite);
}
