package br.com.salareserva.domain.base;

public abstract class ValueObject {

    protected abstract boolean equalsBase(Object o);
    protected abstract int hashCodeBase();

    @Override
    public int hashCode() {
        return hashCodeBase();
    }

    @Override
    public boolean equals(Object o) {
        return equalsBase(o);
    }
}
