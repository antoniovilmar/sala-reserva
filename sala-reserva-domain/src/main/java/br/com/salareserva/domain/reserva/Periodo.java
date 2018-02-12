package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.base.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Embeddable
public class Periodo extends ValueObject implements Serializable {

    private static final long serialVersionUID = -6785480139504271031L;

    @NotNull
    @Column(name = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;
    @NotNull
    @Column(name = "data_hora_fim")
    private LocalDateTime dataHoraFim;

    /** @deprecated  Construtor vazio existe por causa do hibernate - Não usar */
    protected Periodo(){}

    public Periodo(LocalDateTime dataHoraInicio, LocalDateTime dataFim) {
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataFim;
    }

    @Override
    public boolean equalsBase(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo = (Periodo) o;
        return Objects.equals(dataHoraInicio, periodo.dataHoraInicio) &&
                Objects.equals(dataHoraFim, periodo.dataHoraFim);
    }

    @Override
    public int hashCodeBase() {
        return Objects.hash(dataHoraInicio, dataHoraFim);
    }

    public boolean temPeriodo(){
        return nonNull(this.dataHoraInicio) && nonNull(this.dataHoraFim);
    }

    public boolean naoTemPeriodo(){
        return !this.temPeriodo();
    }


    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }
}
