package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.compartilhado.DominioResultante;

public class Reserva {

    private Sala sala;
    private Periodo periodo;
    private String email;

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

    public static DominioResultante<Reserva> criar(DominioResultante<Reserva> dominioResultante, Sala sala, Periodo objeto, String email) {
        return   dominioResultante
                .construir(() -> sala.reservar(objeto, email));
    }
}
