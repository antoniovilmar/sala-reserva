package br.com.salareserva.application.reserva;

import br.com.salareserva.application.reserva.dto.ReservaDto;

public interface IReservaSalvaService {
    ReservaDto reservar(ReservaDto reservaDto);
}
