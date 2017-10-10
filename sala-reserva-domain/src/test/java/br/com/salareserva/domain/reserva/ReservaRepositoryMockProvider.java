package br.com.salareserva.domain.reserva;

import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ReservaRepositoryMockProvider {
    public static ReservaRepository existeReservaPorPeriodo(Boolean desiredReturn){
        ReservaRepository reservaRepository = Mockito.mock(ReservaRepository.class);
        when(reservaRepository.existeReservaPorPeriodo(any(Sala.class), any(Periodo.class))).thenReturn(true);
        return reservaRepository;
    }
}