package gr.codelearn.dp.dto;

import gr.codelearn.dp.exception.BusinessException;

public class Response {

    private String message = "";
    private boolean error = false;
    private BusinessException exception = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public BusinessException getException() {
        return exception;
    }

    public void setException(BusinessException exception) {
        this.exception = exception;
    }
}
