package gr.codelearn.dp.service;

import gr.codelearn.dp.interfaces.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class UpperCaseConverter implements DataConverter {

    @Override
    public List<String> convertData(List<String> lines) {
        return convertLines(lines);
    }

    private List<String> convertLines(List<String> lines) {
        List<String> newLines = new ArrayList<>();
        for (String s : lines) newLines.add(s.toUpperCase());
        return newLines;
    }

}
