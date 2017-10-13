package br.com.salareserva.domain.arq;

import java.io.Serializable;

public interface Specification<T> extends Serializable {

  Boolean isSatisfiedBy(T t);

}