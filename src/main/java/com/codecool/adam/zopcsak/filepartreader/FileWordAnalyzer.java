package com.codecool.adam.zopcsak.filepartreader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader reader;


    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.reader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        String readLines = reader.readLines();

        List<String> splitReadLines = new ArrayList<>(Arrays.asList(readLines.split(" ")));
        Collections.sort(splitReadLines);

        return splitReadLines;
    }

    public List getWordsContainingSubstring(String subString) {
        String readLines = reader.readLines();
        List<String> splitReadLines = new ArrayList<>(Arrays.asList(readLines.split(" ")));
        List<String> wordsContainingSubString = new ArrayList<>();

        for (String word : splitReadLines) {
            if (word.contains(subString)) {
                wordsContainingSubString.add(word);
            }
        }

        return wordsContainingSubString;
    }

    public List<String> getStringsWhichPalindromes() {
        String readLines = reader.readLines();
        List<String> splitReadLines = new ArrayList<>(Arrays.asList(readLines.split(" ")));
        List<String> palindromes = new ArrayList<>();
        String wordBackwards = "";

        for (String word : splitReadLines) {
            for (int i= word.length()-1; i >= 0; i--) {
                wordBackwards += word.charAt(i);
            }

            if (word.equals(wordBackwards)) {
                palindromes.add(word);
            }
            wordBackwards = "";
        }
        return palindromes;
    }


}
