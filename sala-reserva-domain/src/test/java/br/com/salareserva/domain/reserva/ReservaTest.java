package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.compartilhado.DominioResultante;
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
        ReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(false);
        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodo, email);

            //Then
            Assert.assertEquals(email, reserva.getEmail());
            Assert.assertEquals(sala.getId(), reserva.getSala().getId());
            Assert.assertEquals(periodoInicio, reserva.getPeriodo().getDataInicio());
            Assert.assertEquals(periodoFim, reserva.getPeriodo().getDataFim());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void naoDeveCriarReservaEmHorarioJaReservado(){

        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
        Periodo periodo = new Periodo(periodoInicio, periodoFim);
        String email = "mauro_falcatrua@gmail.com";

        ReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(true);
        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodo, email);
        } catch (Exception e) {
            Assert.assertEquals("A sala está ocupada neste período", e.getMessage());
        }

    }

    @Test
    public void naoDevePermitirAgendamentoEmPeriodoInvalido(){
        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
        Periodo periodo = new Periodo(periodoInicio, periodoFim);
        String email = "mauro_falcatrua@gmail.com";

        ReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(false);

        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodo, email);
            Assert.fail("Deveria ter informado que o período é inválido");
        } catch (Exception e) {
            Assert.assertEquals("Período inválido", e.getMessage());
        }
    }

    @Test
    public void naoDevePermitirAgendamentoNoPassado(){

        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
        Periodo periodo = new Periodo(periodoInicio, periodoFim);
        String email = "mauro_falcatrua@gmail.com";

        DominioResultante<Reserva> resultante = new DominioResultante<>();
        Reserva reserva = resultante.Mapear(() -> new Reserva(sala, periodo, email));
        Assert.assertEquals(email, reserva.getEmail());

    }
}
