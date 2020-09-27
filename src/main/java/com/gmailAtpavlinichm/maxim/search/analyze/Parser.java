package com.gmailAtpavlinichm.maxim.search.analyze;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class Parser {
    public List<Entry<String, String>> parseListSeoTexts(List<Entry<String, String>> listTextsWithDomains) {

        List<Entry<String, String>> parsedTextsWithDomains = new ArrayList<>();

        for(Entry<String, String> entryTextWithDomain : listTextsWithDomains) {
            Entry<String, String> copyOfEntry = parse(entryTextWithDomain);
            parsedTextsWithDomains.add(copyOfEntry);
        }

        return parsedTextsWithDomains;
    }

    private Entry<String, String> parse(Entry<String, String> entrySeoTextWithDomain) {
        //Вот тут продаются #a#маски для лица#/a# на американском сайте.
        // Твоему мужу понравится этот #a#набор галстук запонки и платок#/a#.
        String keyText = entrySeoTextWithDomain.getKey();
        keyText = keyText.replace("#a#", "");
        keyText = keyText.replace("#/a#", "");
        keyText = "\"" + keyText + "\"";

        Entry<String, String> newEntry = new SimpleEntry<>(keyText, entrySeoTextWithDomain.getValue());
        return newEntry;
    }
}
