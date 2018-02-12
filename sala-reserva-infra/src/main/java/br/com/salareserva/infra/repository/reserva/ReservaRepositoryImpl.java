package br.com.salareserva.infra.repository.reserva;

import br.com.salareserva.domain.repository.IReservaRepository;
import br.com.salareserva.domain.reserva.Periodo;
import br.com.salareserva.domain.reserva.Reserva;
import br.com.salareserva.domain.reserva.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservaRepositoryImpl implements IReservaRepository {

    private ReservaRepositorySpringData reservaRepositorySpringData;

    @Autowired
    public ReservaRepositoryImpl(ReservaRepositorySpringData reservaRepositorySpringData) {
        this.reservaRepositorySpringData = reservaRepositorySpringData;
    }

    @Override
    public Reserva salvar(Reserva reserva) {
       return this.reservaRepositorySpringData.save(reserva);
    }

    @Override
    public List<Reserva> listar() {
        return this.reservaRepositorySpringData.findAll();
    }

    @Override
    public void excluir(Long id) {
        this.reservaRepositorySpringData.delete(id);
    }


    @Override
    public Reserva consultarPorId(Long id) {
        return this.reservaRepositorySpringData.getOne(id);
    }

    @Override
    public Boolean temReservaPorSalaPeriodo(Sala sala, Periodo periodo) {
        return this.reservaRepositorySpringData.existsBySalaAndPeriodo(sala, periodo);
    }

    interface ReservaRepositorySpringData extends JpaRepository<Reserva, Long> {
        Boolean existsBySalaAndPeriodo(Sala sala, Periodo periodo);
    }


}
