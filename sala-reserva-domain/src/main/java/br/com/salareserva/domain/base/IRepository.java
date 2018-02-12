package br.com.salareserva.domain.base;

public interface IRepository<T extends AgregateRoot> {

    T salvar(T t);

}