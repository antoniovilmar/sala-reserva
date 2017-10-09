package br.com.salareserva.domain.reserva;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class ReservaTest {

    @Test
    public void deveCriarReservaDeSala(){
        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
        Periodo periodo = new Periodo(periodoInicio, periodoFim);
        String email = "mauro_falcatrua@gmail.com";
        //When
        Reserva reserva = new FabricaReserva().criar(sala, periodo, email);

        //Then
        Assert.assertEquals(email, reserva.getEmail());
        Assert.assertEquals(sala.getId(), reserva.getSala().getId());
        Assert.assertEquals(periodoInicio, reserva.getPeriodo().getDataInicio());
        Assert.assertEquals(periodoFim, reserva.getPeriodo().getDataFim());
    }

    @Test
    public void naoDeveCriarReservaEmHorarioJaReservado(){

        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
        Periodo periodo = new Periodo(periodoInicio, periodoFim);
        String email = "mauro_falcatrua@gmail.com";


        Reserva reserva = new FabricaReserva().criar(sala, periodo, email);

    }
}
