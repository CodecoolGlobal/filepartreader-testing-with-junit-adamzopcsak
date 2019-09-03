package com.codecool.adam.zopcsak.filepartreader;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private String filePath = "/home/adamzopcsak/codecool/oop/si5/filepartreader-testing-with-junit-adamzopcsak/src/files/bacon";
    private FilePartReader reader = new FilePartReader();

    @Test
    public void testGetWordsOrderedAlphabetically() {
        reader.setup(filePath, 1, 1);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        List<String> outputList = analyzer.getWordsOrderedAlphabetically();
        String[] outputArray = new String[outputList.size()];

        for (int i=0; i < outputArray.length; i++) {
            outputArray[i] = outputList.get(i);
        }

        assertArrayEquals(new String[] {"Bacon", "good.", "is"}, outputArray);

    }

}