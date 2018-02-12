package br.com.salareserva.domain.reserva.provider;

import br.com.salareserva.domain.repository.IReservaRepository;
import br.com.salareserva.domain.reserva.Periodo;
import br.com.salareserva.domain.reserva.Sala;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class ReservaRepositoryMockProvider {
    public static IReservaRepository existeReservaPorPeriodo(Boolean desiredReturn){
        IReservaRepository reservaRepository = Mockito.mock(IReservaRepository.class);
        when(reservaRepository.temReservaPorSalaPeriodo(any(Sala.class), any(Periodo.class))).thenReturn(desiredReturn);
        return reservaRepository;
    }
}
