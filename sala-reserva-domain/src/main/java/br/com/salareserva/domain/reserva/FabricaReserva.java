package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.arq.DomainBusinessException;
import br.com.salareserva.domain.arq.Specification;
import br.com.salareserva.domain.specification.ReservaSalaOcupadaNoPeriodoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class FabricaReserva extends FabricaBase {

    private ReservaSalaOcupadaNoPeriodoSpecification reservaSalaOcupadaNoPeriodoSpecification;

    @Autowired
    FabricaReserva(ReservaSalaOcupadaNoPeriodoSpecification reservaSalaOcupadaNoPeriodoSpecification) {
        this.reservaSalaOcupadaNoPeriodoSpecification = reservaSalaOcupadaNoPeriodoSpecification;
    }

    public Reserva criar(Sala sala, LocalDateTime dataInicio, LocalDateTime dataFim, String email) {

        final Periodo periodo = new Periodo(dataInicio, dataFim);
        final Reserva reserva = sala.reservar(periodo, email);
        final Boolean temReservaNoPeridoSala = reservaSalaOcupadaNoPeriodoSpecification.isSatisfiedBy(reserva);
        testarRegra
        testarRegra
        testarRegra

        if(temReservaNoPeridoSala){
            throw new DomainBusinessException(reservaSalaOcupadaNoPeriodoSpecification.getBrokenRules());
        }

        return reserva;

    }

    private void testarRegra(Specification reservaSalaOcupadaNoPeriodoSpecification){

    }

}
