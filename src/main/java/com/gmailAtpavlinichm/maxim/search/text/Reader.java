package com.gmailAtpavlinichm.maxim.search.text;


import java.nio.file.Path;
import java.util.Map;

public interface Reader {
    public Map<String, String> readTexts(Path pathTxtFile);
}
