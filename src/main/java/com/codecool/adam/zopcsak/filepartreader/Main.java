package com.codecool.adam.zopcsak.filepartreader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FilePartReader reader = new FilePartReader();
        reader.setup("/home/adamzopcsak/codecool/oop/si5/filepartreader-testing-with-junit-adamzopcsak/src/files/bacon", 1, 10);
        System.out.println(reader.readLines());

        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        System.out.println(analyzer.getWordsOrderedAlphabetically());
        System.out.println(analyzer.getWordsContainingSubstring("Bac"));
        System.out.println(analyzer.getStringsWhichPalindromes());
    }

}

