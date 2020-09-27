package com.gmailAtpavlinichm.maxim;

import com.gmailAtpavlinichm.maxim.search.analyze.Analyzer;
import com.gmailAtpavlinichm.maxim.search.analyze.GoogleAnalyzer;
import com.gmailAtpavlinichm.maxim.search.analyze.Parser;
import com.gmailAtpavlinichm.maxim.search.text.TextReader;
import com.gmailAtpavlinichm.maxim.search.text.TextWriter;
import com.gmailAtpavlinichm.maxim.search.text.Writer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map.Entry;

public class Starter {
    public static void main(String args[]) {

        Path pathFrom = Paths.get("E:\\SeoTexts.txt");

        String absolutePath = pathFrom.toAbsolutePath().toString();
        int indexOfDot = absolutePath.indexOf(".");
        Path resultPathTo = Paths.get(absolutePath.substring(0, indexOfDot) + "Result" + absolutePath.substring(indexOfDot, absolutePath.length()));

        new Starter().run(pathFrom, resultPathTo);
    }

    public void run(Path pathFrom, Path resultPathTo) {

        TextReader textReader = new TextReader();
        List<Entry<String, String>> listSeoTexts = textReader.readTexts(pathFrom);

        Parser parser = new Parser();
        List<Entry<String, String>> ordinaryTextsWithDomains = parser.parseListSeoTexts(listSeoTexts);

        Analyzer analyzer = new GoogleAnalyzer();
        List<Entry<String, String>> analyzedTexts = analyzer.getThatIndexed(ordinaryTextsWithDomains);

        Writer textWriter = new TextWriter();
        textWriter.writeTexts(resultPathTo, analyzedTexts);

    }
}
