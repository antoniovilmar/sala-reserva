package br.com.salareserva.application.reserva;

import br.com.salareserva.application.reserva.dto.ReservaDto;

import java.util.List;

public interface IReservaConsultaService {
    List<ReservaDto> listar();
    ReservaDto consultarPorId(Long id);
}
