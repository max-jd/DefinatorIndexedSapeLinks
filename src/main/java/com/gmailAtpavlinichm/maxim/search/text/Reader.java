package com.gmailAtpavlinichm.maxim.search.text;


import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public interface Reader {
    public List<Map.Entry<String, String>> readTexts(Path pathTxtFile);
}
