package gr.codelearn.dp.service;

import java.util.ArrayList;
import java.util.List;

public class UpperCaseConverter {

    private List<String> inputLines;
    private List<String> outputLines;

    public List<String> getInputLines() {
        return inputLines;
    }

    public void setInputLines(List<String> inputLines) {
        this.inputLines = new ArrayList<>(inputLines);
    }

    public List<String> getOutputLines() {
        return new ArrayList<>(outputLines);
    }

    public void convert() {
        outputLines = new ArrayList<>();
        for (String line : inputLines) {
            outputLines.add(line.toUpperCase());
        }
    }

//    public List<String> convertToUpper(List<String> lines) {
//        return convert(lines);
//    }

}
