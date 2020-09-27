package com.gmailAtpavlinichm.maxim.search.text;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class EmergencyWriter implements Writer {

    private final Path userHome = Paths.get(System.getProperty("user.home") + "//emergencyReport.txt");

    @Override
    public void writeTexts(Path pathToWrite, List<Map.Entry<String, String>> textsWithDomainsToWrite) {
        TextWriter textWriter = new TextWriter();
        textWriter.writeTexts(userHome, textsWithDomainsToWrite);
    }
}
