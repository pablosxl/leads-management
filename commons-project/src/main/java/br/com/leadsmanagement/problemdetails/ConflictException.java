package br.com.leadsmanagement.problemdetails;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApplicationException {
	
	public ConflictException(String description) {
        super(HttpStatus.CONFLICT.value(), "recurso_nao_encontrado", description);
    }

    public ConflictException(String description, Throwable cause) {
        super(HttpStatus.CONFLICT.value(), "recurso_nao_encontrado", description, cause);
    }
	
}
