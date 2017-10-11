package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.ValueObject;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Periodo implements ValueObject {


    @NotNull
    private LocalDateTime dataInicio;
    @NotNull
    private LocalDateTime dataFim;

    public Periodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }



    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
}
