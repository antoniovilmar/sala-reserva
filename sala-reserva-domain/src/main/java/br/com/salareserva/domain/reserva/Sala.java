package br.com.salareserva.domain.reserva;


public class Sala {

    private String id;

    public Sala(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Reserva reservar(Periodo periodo, String email) {
        return new Reserva(this, periodo, email);
    }
}
