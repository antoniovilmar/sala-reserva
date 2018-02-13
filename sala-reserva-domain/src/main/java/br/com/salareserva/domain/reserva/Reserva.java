package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.base.AgregateRoot;
import br.com.salareserva.domain.beanvalidation.PeriodoInicialMaiorPeriodoFinalValidation;
import br.com.salareserva.domain.beanvalidation.TempoMinimoAntecedenciaValidation;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "reserva")
public class Reserva extends AgregateRoot<Reserva> implements Serializable {


    private static final long serialVersionUID = -5697132317232573714L;

    @NotNull
    @Embedded
    private Sala sala;

    @Valid
    @PeriodoInicialMaiorPeriodoFinalValidation(message = "{periodoDataInicialMaiorPeriodoFinal.message}")
    @TempoMinimoAntecedenciaValidation(message = "{tempoMinimoAntecedencia.message}")
    @Embedded
    private Periodo periodo;

    @NotNull
    @Column(name = "email_responsavel")
    private String email;


    /** @deprecated  Construtor vazio existe por causa do hibernate - Não usar */
    protected Reserva(){}

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
