package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.ValueObject;
import br.com.salareserva.domain.compartilhado.DominioResultante;

import java.time.LocalDateTime;

public class Periodo implements ValueObject {

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    private Periodo(LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public static DominioResultante<Periodo> criar(LocalDateTime dataInicio, LocalDateTime dataFim){
        return new DominioResultante<Periodo>()
                .GarantirQue(() -> dataInicio.isBefore(dataFim),"A data de início deve ser menor que a data de fim")
                .construir(() -> new Periodo(dataInicio, dataFim));
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
}
