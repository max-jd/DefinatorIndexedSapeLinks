package com.gmailAtpavlinichm.maxim.search.analyze;


import java.util.List;
import java.util.Map;

public interface Analyzer {
    public List<Map.Entry<String, String>> getThatIndexed(List<Map.Entry<String, String>> listTextsWithDomains);
}
