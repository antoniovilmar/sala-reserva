package br.com.salareserva.api.controller;

import br.com.salareserva.application.reserva.IReservaConsultaService;
import br.com.salareserva.application.reserva.IReservaExclusaoService;
import br.com.salareserva.application.reserva.IReservaSalvaService;
import br.com.salareserva.application.reserva.dto.ReservaDto;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservaController {

    private IReservaSalvaService reservaSalvaService;
    private IReservaConsultaService reservaConsultaService;
    private IReservaExclusaoService reservaExclusaoService;

    @Autowired
    public ReservaController(IReservaSalvaService reservaSalvaService, IReservaConsultaService reservaConsultaService, IReservaExclusaoService reservaExclusaoService) {
        this.reservaSalvaService = reservaSalvaService;
        this.reservaConsultaService = reservaConsultaService;
        this.reservaExclusaoService = reservaExclusaoService;
    }

    @RequestMapping(value = "/reserva", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaDto reservar(@RequestBody  @Valid ReservaDto reservaDto) {
        return this.reservaSalvaService.reservar(reservaDto);
    }

    @RequestMapping(value = "/reserva", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ReservaDto> listar() {
        return this.reservaConsultaService.listar();
    }

    @RequestMapping(value = "/reserva/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ReservaDto consultarPorId(@PathVariable Long id) {
        return this.reservaConsultaService.consultarPorId(id);
    }

    @RequestMapping(value = "/reserva/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPorId(@PathVariable Long id) {
        this.reservaExclusaoService.excluir(id);
    }


}
