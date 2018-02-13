package br.com.salareserva.application.reserva.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReservaDto {
    private Long id;
    @NotNull
    @Size(min=1)
    private String idSala;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataHoraInicio;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataHoraFim;
    private String emailResponsavel;

    /** @deprecated Construtor vazio existe por causa do parser do SpringMVC - Não usar */
    protected ReservaDto() {

    }

    public ReservaDto(String idSala, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String emailResponsavel) {
        this.id = id;
        this.idSala = idSala;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.emailResponsavel = emailResponsavel;
    }

    public ReservaDto(Long id, String idSala, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String emailResponsavel) {
        this.id = id;
        this.idSala = idSala;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.emailResponsavel = emailResponsavel;
    }

    public Long getId() {
        return id;
    }

    public String getIdSala() {
        return idSala;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

}
