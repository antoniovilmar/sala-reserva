package br.com.salareserva.infra.repository;

import br.com.salareserva.domain.repository.ReservaRepository;
import br.com.salareserva.domain.reserva.Periodo;
import br.com.salareserva.domain.reserva.Reserva;
import br.com.salareserva.domain.reserva.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class ReservaRepositoryImpl implements ReservaRepository {

    private ReservaRepositorySpringData reservaRepositorySpringData;

    @Autowired
    public ReservaRepositoryImpl(ReservaRepositorySpringData reservaRepositorySpringData) {
        this.reservaRepositorySpringData = reservaRepositorySpringData;
    }

    @Override
    public void add(Reserva reserva) {
        this.reservaRepositorySpringData.save(reserva);
    }

    @Override
    public void remove(Long id) {
        this.reservaRepositorySpringData.delete(id);
    }

    @Override
    public Boolean temReservaPorSalaPeriodo(Sala sala, Periodo periodo) {
        return this.reservaRepositorySpringData.existsBySalaAndPeriodo(sala, periodo);
    }

    interface ReservaRepositorySpringData extends JpaRepository<Reserva, Long> {

        Boolean existsBySalaAndPeriodo(Sala sala, Periodo periodo);

    }
}