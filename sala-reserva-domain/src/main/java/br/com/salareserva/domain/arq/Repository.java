package br.com.salareserva.domain.arq;

import java.io.Serializable;

public interface Repository<T extends BaseEntity> extends Serializable {

    public void add(T t);

    public void remove(Long id);


}