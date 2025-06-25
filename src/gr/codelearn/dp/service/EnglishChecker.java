package gr.codelearn.dp.service;

import gr.codelearn.dp.interfaces.DataChecker;

import java.util.List;

public class EnglishChecker implements DataChecker {

    private boolean checkEnglish(List<String> lines) {
        String firstLine = lines.get(0);
        String firstLineLower = firstLine.toLowerCase();
        return firstLineLower.contains("e") ||
                firstLineLower.contains("t") ||
                firstLineLower.contains("a") ||
                firstLineLower.contains("o");
    }

    @Override
    public boolean checkData(List<String> lines) {
        // preconditions
        boolean ok = checkEnglish(lines);
        // postconditions
        return ok;
    }
}
