package com.gmailAtpavlinichm.maxim.search.analyze;


import java.util.Map;

public interface Analyzer {
    public Map<String, Boolean> analyze(Map<String, String> keysWithDomains);
}
