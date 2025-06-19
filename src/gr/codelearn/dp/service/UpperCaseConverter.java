package gr.codelearn.dp.service;

import java.util.ArrayList;
import java.util.List;

public class UpperCaseConverter {
    public static List<String> convertToUpper(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for (String line : lines) {
            newLines.add(line.toUpperCase());
        }
        return newLines;
    }
}
