package br.com.salareserva.domain.reserva;

public interface ReservaRepository {

   Boolean existeReservaPorPeriodo(Sala sala, Periodo periodo);
}
