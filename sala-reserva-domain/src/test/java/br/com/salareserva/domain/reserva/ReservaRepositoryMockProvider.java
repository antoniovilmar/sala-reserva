package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.repository.ReservaRepository;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ReservaRepositoryMockProvider {
    public static ReservaRepository existeReservaPorPeriodo(Boolean desiredReturn){
        ReservaRepository reservaRepository = Mockito.mock(ReservaRepository.class);
        when(reservaRepository.temReservaPorSalaPeriodo(any(Sala.class), any(Periodo.class))).thenReturn(desiredReturn);
        return reservaRepository;
    }
}
