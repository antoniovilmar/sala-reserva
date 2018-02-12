package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.base.DomainBusinessException;
import br.com.salareserva.domain.beanvalidation.MensagemBeanValidationPropertiesProxy;
import br.com.salareserva.domain.repository.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static br.com.salareserva.domain.beanvalidation.MensagemBeanValidationPropertiesEnum.SALA_OCUPADA_NO_PERIODO;


@Service
public class FabricaReserva {

    private IReservaRepository reservaRepository;

    @Autowired
    FabricaReserva(IReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva criar(Sala sala, LocalDateTime dataInicio, LocalDateTime dataFim, String email) {

        final Periodo periodo = new Periodo(dataInicio, dataFim);
        final Reserva reserva = sala.reservar(periodo, email);
        validarReservaSalaOcupadaNoPeriodo(sala, periodo);

        return reserva;

    }

    private void validarReservaSalaOcupadaNoPeriodo(Sala sala, Periodo periodo){
        if(reservaRepository.temReservaPorSalaPeriodo(sala, periodo)){
            final String mensagemErro = MensagemBeanValidationPropertiesProxy.getMensagem(SALA_OCUPADA_NO_PERIODO);
            throw new DomainBusinessException(mensagemErro);
        }
    }

}
