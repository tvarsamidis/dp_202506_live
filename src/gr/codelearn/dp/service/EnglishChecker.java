package gr.codelearn.dp.service;

import java.util.List;

public class EnglishChecker {
    public static boolean isEnglish(List<String> lines) {
        String lowerCase = lines.get(0).toLowerCase();
        return lowerCase.contains("e") ||
               lowerCase.contains("t") ||
               lowerCase.contains("a") ||
               lowerCase.contains("o");
    }
}
