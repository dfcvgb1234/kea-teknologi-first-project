package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public void writeAllText(String path, String text) throws IOException {
        FileWriter writer = new FileWriter(path, false);
        writer.write(text);
        writer.close();
    }

    public void writeAllLines(String path, String[] lines) throws IOException {
        FileWriter writer = new FileWriter(path, false);
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();
    }

    public void appendAllText(String path, String text) throws IOException {
        FileWriter writer = new FileWriter(path, true);
        writer.write(text);
        writer.close();
    }

    public void appendAllLines(String path, String[] lines) throws IOException {
        FileWriter writer = new FileWriter(path, true);
        for (String line : lines) {
            writer.write(line + "\n");
        }
        writer.close();
    }

    public String loadAllText(String path) throws IOException {
        Scanner fileReader = new Scanner(new File(path));
        StringBuilder fileContents = new StringBuilder();
        while(fileReader.hasNext()) {
            fileContents.append(fileReader.next());
        }

        return fileContents.toString();
    }

    public String[] loadAllLines(String path) throws IOException {
        Scanner fileReader = new Scanner(new File(path));
        List<String> fileContents = new ArrayList<String>();

        while (fileReader.hasNextLine()) {
            fileContents.add(fileReader.nextLine());
        }

        return fileContents.toArray(new String[] {});
    }
}
