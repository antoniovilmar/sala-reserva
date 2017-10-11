package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.arq.DomainBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class FabricaReserva {

    private ReservaRepository repository;

    @Autowired
    FabricaReserva(ReservaRepository reservaRepository) {
        repository = reservaRepository;
    }

    public Reserva criar(Sala sala, LocalDateTime dataInicio, LocalDateTime dataFim, String email) {

        final Periodo periodo = new Periodo(dataInicio, dataFim);
        if(this.repository.existeReservaPorPeriodo(sala,periodo)){
            throw new DomainBusinessException("A sala está ocupada neste período");
        }
        return new Reserva(sala, periodo, email);
    }

}
