package com.gmailAtpavlinichm.maxim.search.analyze;

import java.util.*;

public class Parser {
    public Map<String, String> parseListSeoTexts(Map<String, String> textsWithDomains) {
        Map<String,String> parsedTextsWithDomains = new HashMap<>();
        Set<Map.Entry<String, String>> setTexts = textsWithDomains.entrySet();

        for(Map.Entry<String, String> entry : setTexts) {
           String seoText = entry.getKey();
           String parsedText = parse(seoText);
           parsedTextsWithDomains.put(parsedText, entry.getValue());
        }

        return parsedTextsWithDomains;
    }

    private String parse(String seoText) {
        //Вот тут продаются #a#маски для лица#/a# на американском сайте.
       seoText = seoText.replace("#a#", "");
        seoText = seoText.replace("#/a#", "");
       seoText = "\"" + seoText + "\"";

       return seoText;
    }
}
