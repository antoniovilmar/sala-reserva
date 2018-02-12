package br.com.salareserva.domain.base;

public class DomainBusinessException extends RuntimeException {

	public DomainBusinessException(String mensagem) {
		super(mensagem);
	}

}
