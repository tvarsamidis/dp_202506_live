package gr.codelearn.dp;

import gr.codelearn.dp.service.EnglishChecker;
import gr.codelearn.dp.service.FileDataReader;
import gr.codelearn.dp.service.FileDataWriter;
import gr.codelearn.dp.service.UpperCaseConverter;

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
        UpperCaseConverter converter = new UpperCaseConverter();
        converter.setInputLines(lines);
        converter.convert();
        return converter.getOutputLines();
    }

    private static void saveToFile(final String fileName, List<String> lines) throws IOException {
        FileDataWriter.saveToFile(fileName, lines);
    }

    private static boolean isEnglish(List<String> lines) {
        boolean ok = EnglishChecker.isEnglish(lines);
        return ok;
    }

    private static List<String> readFile(final String pathname) throws IOException {
        List<String> lines = FileDataReader.readFile(pathname);
        return lines;
    }
}
