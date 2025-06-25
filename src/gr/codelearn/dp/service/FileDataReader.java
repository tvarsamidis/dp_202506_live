package gr.codelearn.dp.service;

import gr.codelearn.dp.exception.BusinessException;
import gr.codelearn.dp.interfaces.DataReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {
    @Override
    public List<String> readData(String pathname) throws BusinessException {
        return readFile(pathname);
    }

    private List<String> readFile(String pathname) throws BusinessException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            return lines;
        } catch (IOException e) {
            throw new BusinessException("Error reading file: " + e.getMessage(), e);
        }
    }

}
