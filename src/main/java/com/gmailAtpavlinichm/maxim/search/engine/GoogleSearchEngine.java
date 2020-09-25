package com.gmailAtpavlinichm.maxim.search.engine;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;


public class GoogleSearchEngine implements SearchEngine {
    private WebClient webClient;
    private final String pageForSearch = "https://www.google.com.ua/search?q=";
 /*   private final String nameSearchInput = "q";
    private final String formName = "f";*/
    private final String operator = "site:";

    public GoogleSearchEngine() {
        webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setJavaScriptEnabled(false);
    }

    @Override
    public boolean search(String key, String targetSite) {

        try {

            String request = operator + targetSite + " " + key;
            HtmlPage searchPage = webClient.getPage(pageForSearch + request);

            List<?> listClassG =  searchPage.getByXPath("//h3");

            //are there some links?
            if (listClassG.size() == 0) {
                return false;
            }

        } catch (IOException ex) {
            System.out.println(this.getClass());
            ex.printStackTrace();
        }

        return true;
    }

    @Override
    public void finalize() {
        webClient.close();
    }
}
