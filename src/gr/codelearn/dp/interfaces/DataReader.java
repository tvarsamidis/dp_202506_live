package gr.codelearn.dp.interfaces;

import gr.codelearn.dp.exception.BusinessException;

import java.util.List;

public interface DataReader {
    List<String> readData(String pathname) throws BusinessException;
}
