package br.com.salareserva.api.handler;

import br.com.salareserva.domain.base.DomainBusinessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ControllerAdvice
public class HttpErrorExceptionHandler {

	@ResponseStatus(UNPROCESSABLE_ENTITY)
	@ExceptionHandler(DomainBusinessException.class)
	@ResponseBody
	public Erro error(DomainBusinessException e) {
		return new Erro(e.getMessage());
	}

	@ResponseStatus(NOT_FOUND)
	@ExceptionHandler({EntityNotFoundException.class, EmptyResultDataAccessException.class})
	@ResponseBody
	public void error(RuntimeException e) {
	}

}
