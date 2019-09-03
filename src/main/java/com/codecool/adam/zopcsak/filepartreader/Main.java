package com.codecool.adam.zopcsak.filepartreader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FilePartReader reader = new FilePartReader();
        reader.setup("teve", 1, 10);
        System.out.println(reader.readLines());

        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        System.out.println(analyzer.getWordsOrderedAlphabetically());
        System.out.println(analyzer.getWordsContainingSubstring("Bac"));
        System.out.println(analyzer.getStringsWhichPalindromes());
    }

}

