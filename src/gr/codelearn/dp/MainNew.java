package gr.codelearn.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainNew {
    private static final String ROOT = "data\\";

    public static void main(String[] args) {
        System.out.println("Processing started");
        try {
            List<String> lines = readFile(ROOT + "input.txt");
            if (!isEnglish(lines)) {
                processNonEnglish();
            } else {
                List<String> convertedLines = convertToUpper(lines);
                saveToFile(ROOT + "output.txt", convertedLines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Processing completed");
    }

    private static void processNonEnglish() {
        System.out.println("No english text, no processing done");
        System.exit(1);
    }

    private static List<String> convertToUpper(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            newLines.add(line.toUpperCase());
        }
        return newLines;
    }

    private static void saveToFile(final String fileName, List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (String line : lines)
            writer.write(line + "\n");
        writer.close();
    }

    private static boolean isEnglish(List<String> lines) {
        String lowerCase = lines.get(0).toLowerCase();
        return lowerCase.contains("e") ||
               lowerCase.contains("t") ||
               lowerCase.contains("a") ||
               lowerCase.contains("o");
    }

    private static List<String> readFile(final String pathname) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
