package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.base.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Sala extends ValueObject implements Serializable {

    private static final long serialVersionUID = -784124177576079153L;

    @Column(name = "sala")
    private String id;

    public Sala(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /** @deprecated  Construtor vazio existe por causa do hibernate - Não usar */
    protected Sala(){}

    public Reserva reservar(Periodo periodo, String email) {
        return new Reserva(this, periodo, email);
    }

    @Override
    public boolean equalsBase(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sala sala = (Sala) o;
        return Objects.equals(id, sala.id);
    }

    @Override
    public int hashCodeBase() {
        return Objects.hash(super.hashCode(), id);
    }

}
