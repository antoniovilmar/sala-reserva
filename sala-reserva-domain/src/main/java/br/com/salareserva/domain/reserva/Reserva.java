package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.arq.BaseEntity;
import br.com.salareserva.domain.arq.Specification;
import br.com.salareserva.domain.beanvalidation.PeriodoInicialMaiorPeriodoFinalValidation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Reserva extends BaseEntity<Reserva> {

    private Sala sala;
    @Valid
    @NotNull
    @PeriodoInicialMaiorPeriodoFinalValidation(message = "{periodoDataInicialMaiorPeriodoFinal.message}")
    private Periodo periodo;

    private String email;

    protected Reserva(Sala sala, Periodo periodo, String email, List<Specification<Reserva>> specifications) {
        super(specifications);
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
