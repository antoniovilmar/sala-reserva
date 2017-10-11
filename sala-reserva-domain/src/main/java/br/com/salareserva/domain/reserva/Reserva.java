package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.arq.BaseEntity;
import br.com.salareserva.domain.beanvalidation.PeriodoInicialMaiorPeriodoFinalValidation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Reserva extends BaseEntity {

    private Sala sala;
    @Valid
    @NotNull
    @PeriodoInicialMaiorPeriodoFinalValidation(message = "{periodoDataInicialMaiorPeriodoFinal.message}")
    private Periodo periodo;

    private String email;

    protected Reserva(Sala sala, Periodo periodo, String email) {
        this.sala = sala;
        this.periodo = periodo;
        this.email = email;
        this.isValid();
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
