package br.com.leadsmanagement.problemdetails;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ExceptionSerializer.class)
public class ApplicationException extends ResponseStatusException  {

    private Integer httpCode;
    private String errorCode;

    public ApplicationException(Integer httpCode, String errorCode, String description) {
        super(HttpStatus.valueOf(httpCode), description);

        this.httpCode = httpCode;
        this.errorCode = errorCode;
    }

    public ApplicationException(Integer httpCode, String errorCode, String description, Throwable cause) {
        super(httpCode, description, cause);

        this.httpCode = httpCode;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Integer getHttpCode() {
        return httpCode;
    }
}