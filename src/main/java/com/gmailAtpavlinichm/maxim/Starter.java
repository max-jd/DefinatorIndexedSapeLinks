package com.gmailAtpavlinichm.maxim;

import com.gmailAtpavlinichm.maxim.search.analyze.Analyzer;
import com.gmailAtpavlinichm.maxim.search.analyze.GoogleAnalyzer;
import com.gmailAtpavlinichm.maxim.search.analyze.Parser;
import com.gmailAtpavlinichm.maxim.search.text.TextReader;
import com.gmailAtpavlinichm.maxim.search.text.TextWriter;
import com.gmailAtpavlinichm.maxim.search.text.Writer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

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
        Map<String, String> seoTexts = textReader.readTexts(pathFrom);

        Parser parser = new Parser();
        Map<String, String> ordinaryTexts = parser.parseListSeoTexts(seoTexts);

        Analyzer analyzer = new GoogleAnalyzer();
        Map<String, Boolean> analyzedTexts = analyzer.analyze(ordinaryTexts);

        Writer textWriter = new TextWriter();
        textWriter.writeTexts(resultPathTo, analyzedTexts);

    }
}
