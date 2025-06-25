package gr.codelearn.dp.interfaces;

import gr.codelearn.dp.dto.Response;
import gr.codelearn.dp.exception.BusinessException;

import java.util.List;

public interface DataSender {
    void setLines(List<String> lines);
    void setTarget(String target);
    void execute() throws BusinessException;
    Response getResponse();
}
