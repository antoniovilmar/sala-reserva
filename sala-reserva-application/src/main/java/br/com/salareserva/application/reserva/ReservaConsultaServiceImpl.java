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
public class ReservaConsultaServiceImpl implements IReservaConsultaService {

    private IReservaRepository reservaRepositorio;
    private Function<Reserva, ReservaDto> reservaEntityConvertReservaDto;

    @Autowired
    public ReservaConsultaServiceImpl(IReservaRepository reservaRepositorio, Function<Reserva, ReservaDto> reservaEntityConvertReservaDto) {
        this.reservaRepositorio = reservaRepositorio;
        this.reservaEntityConvertReservaDto = reservaEntityConvertReservaDto;
    }

    @Override
    public List<ReservaDto> listar() {
       return this.reservaRepositorio.listar().stream().map(reservaEntityConvertReservaDto).collect(Collectors.toList());
    }

    @Override
    public ReservaDto consultarPorId(Long id) {
        return reservaEntityConvertReservaDto.apply(this.reservaRepositorio.consultarPorId(id));
    }
}
