package br.com.salareserva.application.reserva.converter;

import br.com.salareserva.application.reserva.dto.ReservaDto;
import br.com.salareserva.domain.reserva.Reserva;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.function.Function;

@Component
@RequestScope
public class ReservaEntityConvertReservaDto implements Function<Reserva, ReservaDto> {
    @Override
    public ReservaDto apply(Reserva reserva) {
        return new ReservaDto(reserva.getId(), reserva.getSala().getId(), reserva.getPeriodo().getDataHoraInicio(), reserva.getPeriodo().getDataHoraFim(), reserva.getEmail());
    }
}
