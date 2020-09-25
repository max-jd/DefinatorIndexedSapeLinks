package com.gmailAtpavlinichm.maxim.search.analyze;


import com.gmailAtpavlinichm.maxim.search.engine.GoogleSearchEngine;
import com.gmailAtpavlinichm.maxim.search.engine.SearchEngine;
import com.gmailAtpavlinichm.maxim.search.text.EmergencyWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GoogleAnalyzer implements Analyzer {
    private final int timeOut = 15_000;
    private SearchEngine searchEngine;

    public GoogleAnalyzer() {
        searchEngine = new GoogleSearchEngine();
    }

    public Map<String, Boolean> analyze(Map<String, String> keysWithDomains) {

        Map<String, Boolean> resultOfAnalyze = new HashMap<>();

        Set<Map.Entry<String, String>> entrySetKeysDomains = keysWithDomains.entrySet();
        for(Map.Entry<String, String> entry : entrySetKeysDomains) {
            String key = entry.getKey();
            String domain = entry.getValue();
            boolean isLinksIndexed = searchEngine.search(key, domain);
            resultOfAnalyze.put(key, (isLinksIndexed ? true : false));

            EmergencyWriter emergencyWriter = new EmergencyWriter();
            emergencyWriter.writeTexts(null, resultOfAnalyze);

            System.out.println("Was written entry: " + entry.getKey() + " " + entry.getValue());

            try {
               Thread.sleep(timeOut);
            } catch(InterruptedException ex) {
                System.out.println(this.getClass());
                ex.printStackTrace();
            }
        }

        return resultOfAnalyze;
    }

}
