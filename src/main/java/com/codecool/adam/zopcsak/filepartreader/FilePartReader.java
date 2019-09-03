package com.codecool.adam.zopcsak.filepartreader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "Unknown";
        this.fromLine = -1;
        this.toLine = -1;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine >= fromLine && fromLine >= 1) {
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String read() throws IOException {
        String fileContent = "";
        File file = new File(this.filePath);
        Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine()) {
            fileContent += scanner.nextLine() + "ß";
        }

        return fileContent;
    }

    public String readLines() {
        int fromIndex = getFromLine()-1;
        int toIndex = getToLine()-1;
        String askedLines = "";
        try {
            String fileContent = this.read();
            List<String> readLines = Arrays.asList(fileContent.split("ß"));

            for (int i=0; i < readLines.size(); i++) {
                if (i >= fromIndex && i <= toIndex) {
                    askedLines += readLines.get(i) + " ";
                }
            }
        }
        catch (IOException e) {
            System.out.println("File not found. Please check the filePath.");
        }

        return askedLines.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public Integer getFromLine() {
        return fromLine;
    }

    public Integer getToLine() {
        return toLine;
    }
}
