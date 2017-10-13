package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class FabricaReserva {

    private ReservaRepository reservaRepository;

    @Autowired
    FabricaReserva(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva criar(Sala sala, LocalDateTime dataInicio, LocalDateTime dataFim, String email) {

        final Periodo periodo = new Periodo(dataInicio, dataFim);
        final Boolean temReservaNoPeridoSala = reservaRepository.temReservaPorSalaPeriodo(sala, periodo);
        return sala.reservar(periodo, email, temReservaNoPeridoSala);
    }

}
