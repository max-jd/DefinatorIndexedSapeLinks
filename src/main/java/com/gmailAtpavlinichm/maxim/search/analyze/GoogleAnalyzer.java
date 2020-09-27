package com.gmailAtpavlinichm.maxim.search.analyze;


import com.gmailAtpavlinichm.maxim.search.engine.GoogleSearchEngine;
import com.gmailAtpavlinichm.maxim.search.engine.SearchEngine;
import com.gmailAtpavlinichm.maxim.search.text.EmergencyWriter;
import java.util.Map.Entry;

import java.util.*;

public class GoogleAnalyzer implements Analyzer {
    private final int timeOut = 15_000;
    private SearchEngine searchEngine;

    public GoogleAnalyzer() {
        searchEngine = new GoogleSearchEngine();
    }

    public List<Map.Entry<String, String>> getThatIndexed(List<Map.Entry<String, String>> listTextsWithDomains) {

        List<Map.Entry<String, String>> listResult = new ArrayList<>();

        for(Entry<String, String> entryTextWithDomain : listTextsWithDomains) {

            System.out.println("Entry is scanning: " + entryTextWithDomain.getKey() + " " + entryTextWithDomain.getValue());

            boolean isTextIndexed = searchEngine.search(entryTextWithDomain);
            if(!isTextIndexed) {
                listResult.add(entryTextWithDomain);
            }

            EmergencyWriter emergencyWriter = new EmergencyWriter();
            emergencyWriter.writeTexts(null, listResult);

            try {
                Thread.sleep(timeOut);
            } catch(InterruptedException ex) {
                System.out.println(this.getClass());
                ex.printStackTrace();
            }
        }



/*        Map<String, Boolean> resultOfAnalyze = new HashMap<>();

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
        }*/

        return listResult;
    }

}
