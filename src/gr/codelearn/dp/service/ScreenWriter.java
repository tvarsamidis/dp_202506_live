package gr.codelearn.dp.service;

import gr.codelearn.dp.dto.Response;
import gr.codelearn.dp.exception.BusinessException;
import gr.codelearn.dp.interfaces.DataSender;

import java.util.List;

public class ScreenWriter implements DataSender {
    private List<String> lines;
    private String target;
    private Response response = new Response();

    private void showFile() {
        System.out.println("Target = " + target);
        for (String s : lines)
            System.out.println(s);
    }

    @Override
    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public void setTarget(String target) {
        this.target = target;

        // Could be a business exception if there is no concept of "target"
//        BusinessException be = new BusinessException("Cannot set pathname for screen");
//        response.setException(be);
//        response.setError(true);
    }

    @Override
    public void execute() throws BusinessException {
        showFile();
    }

    @Override
    public Response getResponse() {
        return response;
    }
}
