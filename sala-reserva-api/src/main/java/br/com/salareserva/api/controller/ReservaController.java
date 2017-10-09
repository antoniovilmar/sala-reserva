package br.com.salareserva.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {

    @RequestMapping(value = "/reserva", method = RequestMethod.GET)
    public String buscar() {
        return "Teste";
    }

}
