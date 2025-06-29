package gr.codelearn.dp.service;

import gr.codelearn.dp.dto.Response;
import gr.codelearn.dp.exception.BusinessException;
import gr.codelearn.dp.interfaces.DataSender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileDataWriter implements DataSender {
    private List<String> lines;
    private String target;
    private Response response = new Response();

    private void writeFile() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(new File(target)));
        for (String s : lines)
            writer.write(s + "\n");
        writer.close();
    }

    @Override
    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public void execute() throws BusinessException {
        try {
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
            BusinessException be = new BusinessException("Cannot send data to file", e);
            response.setException(be);
            response.setError(true);
            throw be;
        }
    }

    @Override
    public Response getResponse() {
        return response;
    }
}
