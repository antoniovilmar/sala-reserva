package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.compartilhado.DominioResultante;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;


@Service
public class FabricaReserva {

    private ReservaRepository repository;

    @Inject
    FabricaReserva(ReservaRepository reservaRepository){
        repository = reservaRepository;
    }
    public Reserva criar(Sala sala, LocalDateTime dataInicio, LocalDateTime dataFim, String email) throws Exception {

        DominioResultante<Periodo> dominioPeriodo = Periodo.criar(dataInicio, dataFim);

        DominioResultante<Reserva> dominioResultante =  new DominioResultante<Reserva>()
                .GarantirQue(()-> repository.existeReservaPorPeriodo(sala, dominioPeriodo.getObjeto()), "");

        Reserva.criar(dominioResultante, sala, dominioPeriodo.getObjeto(), email);



    }
}
