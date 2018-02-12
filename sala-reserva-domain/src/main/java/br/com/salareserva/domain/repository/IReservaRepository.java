package br.com.salareserva.domain.repository;

import br.com.salareserva.domain.base.IRepository;
import br.com.salareserva.domain.reserva.Periodo;
import br.com.salareserva.domain.reserva.Reserva;
import br.com.salareserva.domain.reserva.Sala;

import java.util.List;

public interface IReservaRepository extends IRepository<Reserva> {
    Boolean temReservaPorSalaPeriodo(Sala sala, Periodo periodo);
    Reserva consultarPorId(Long id);
    List<Reserva> listar();
    void excluir(Long id);
}
