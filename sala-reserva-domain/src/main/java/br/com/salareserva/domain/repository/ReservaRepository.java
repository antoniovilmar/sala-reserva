package br.com.salareserva.domain.repository;

import br.com.salareserva.domain.arq.Repository;
import br.com.salareserva.domain.reserva.Periodo;
import br.com.salareserva.domain.reserva.Reserva;
import br.com.salareserva.domain.reserva.Sala;

public interface ReservaRepository extends Repository<Reserva> {

    Boolean temReservaPorSalaPeriodo(Sala sala, Periodo periodo);
}
