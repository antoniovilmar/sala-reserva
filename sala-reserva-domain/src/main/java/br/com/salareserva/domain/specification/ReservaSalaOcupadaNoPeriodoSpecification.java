package br.com.salareserva.domain.specification;

import br.com.salareserva.domain.arq.Specification;
import br.com.salareserva.domain.repository.ReservaRepository;
import br.com.salareserva.domain.reserva.Reserva;
import org.springframework.stereotype.Service;

@Service
public class ReservaSalaOcupadaNoPeriodoSpecification implements Specification<Reserva> {

    private ReservaRepository repository;

    public ReservaSalaOcupadaNoPeriodoSpecification(ReservaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean isSatisfiedBy(Reserva reserva) {
        return !this.repository.temReservaPorSalaPeriodo(reserva.getSala(), reserva.getPeriodo());
    }

    @Override
    public String getBrokenRules() {
        return "{salaOcupadaNoPeriodo.message}";
    }
}
