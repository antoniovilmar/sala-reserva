package br.com.salareserva.domain.reserva;

public class Reserva {

    private final Sala sala;
    private final Periodo periodo;
    private final String email;

    protected Reserva(Sala sala, Periodo periodo, String email) {
        this.sala = sala;
        this.periodo = periodo;
        this.email = email;
    }

    public Sala getSala() {
        return sala;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public String getEmail() {
        return email;
    }
}
