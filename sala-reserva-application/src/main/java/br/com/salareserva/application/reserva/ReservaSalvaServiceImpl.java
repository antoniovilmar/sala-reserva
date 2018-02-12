package br.com.salareserva.application.reserva;

import br.com.salareserva.application.reserva.dto.ReservaDto;
import br.com.salareserva.domain.repository.IReservaRepository;
import br.com.salareserva.domain.reserva.FabricaReserva;
import br.com.salareserva.domain.reserva.Reserva;
import br.com.salareserva.domain.reserva.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ReservaSalvaServiceImpl implements IReservaSalvaService {

    private IReservaRepository reservaRepositorio;
    private FabricaReserva fabricaReserva;
    private Function<Reserva, ReservaDto> reservaEntityConvertReservaDto;

    @Autowired
    public ReservaSalvaServiceImpl(IReservaRepository reservaRepositorio, FabricaReserva fabricaReserva, Function<Reserva, ReservaDto> reservaEntityConvertReservaDto) {
        this.reservaRepositorio = reservaRepositorio;
        this.fabricaReserva = fabricaReserva;
        this.reservaEntityConvertReservaDto = reservaEntityConvertReservaDto;
    }

    @Override
    public ReservaDto reservar(ReservaDto reservaDto) {
        final Sala sala = new Sala(reservaDto.getIdSala());
        final Reserva reserva = fabricaReserva.criar(sala, reservaDto.getDataHoraInicio(), reservaDto.getDataHoraFim(), reservaDto.getEmailResponsavel());
        final ReservaDto reservaSalvaDto = reservaEntityConvertReservaDto.apply(reservaRepositorio.salvar(reserva));

        return reservaSalvaDto;
    }
}
