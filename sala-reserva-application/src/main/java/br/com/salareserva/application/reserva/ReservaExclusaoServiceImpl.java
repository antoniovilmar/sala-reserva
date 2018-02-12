package br.com.salareserva.application.reserva;

import br.com.salareserva.application.reserva.dto.ReservaDto;
import br.com.salareserva.domain.repository.IReservaRepository;
import br.com.salareserva.domain.reserva.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ReservaExclusaoServiceImpl implements IReservaExclusaoService {

    private IReservaRepository reservaRepositorio;

    @Autowired
    public ReservaExclusaoServiceImpl(IReservaRepository reservaRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
    }

    @Override
    public void excluir(Long id) {
        this.reservaRepositorio.excluir(id);
    }
}
