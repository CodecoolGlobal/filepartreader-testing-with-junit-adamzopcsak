package com.codecool.adam.zopcsak.filepartreader;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private FilePartReader reader = new FilePartReader();
    private String filePath = "/home/adamzopcsak/codecool/oop/si5/filepartreader-testing-with-junit-adamzopcsak/src/files/bacon";

    @Test
    public void testConstructor() {

        Integer fromLine = -1;
        Integer toLine = -1;

        assertEquals("Unknown", reader.getFilePath());
        assertEquals(fromLine, reader.getFromLine());
        assertEquals(toLine, reader.getToLine());

    }

    @Test
    public void testNormalSetup() {
        Integer fromLine = 1;
        Integer toLine = 10;

        reader.setup(filePath, fromLine, toLine);
        assertEquals(filePath, reader.getFilePath());
        assertEquals(fromLine, reader.getFromLine());
        assertEquals(toLine, reader.getToLine());

    }

    @Test
    public void testWrongSetup() {
        assertThrows(IllegalArgumentException.class, () -> {
            reader.setup(filePath, -1, -1);
        });
    }


    @Test
    public void testRead() throws IOException {
        reader.setup(filePath, 1,14);
        String testString = reader.read();
        assertEquals("Bacon is good.ß" +
                "Bacon is right.ß" +
                "racecar madam.ß" +
                "Bacon is delicious.ß" +
                "Bacon is tight.ß" +
                "Bacon is not bad.ß" +
                "Bacon is pig.ß" +
                "Everything with bacon,ß" +
                "Is better than meat.ß" +
                "ß" +
                "Bacon flavoured icecream,ß" +
                "Bacon flavoured cheese,ß" +
                "Eat only bacon,ß" +
                "And you will be pleased.ß", testString);
    }

    @Test
    public void testNormalReadLines() {
        reader.setup(filePath, 1, 1);
        String testString = "Bacon is good.";
        assertEquals(testString, reader.readLines());
    }

    @Test
    public void testFileNotFound() {
        reader.setup("badFilePath", 1, 1);
        assertEquals("", reader.readLines());
    }

}