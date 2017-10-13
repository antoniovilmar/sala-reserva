package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.repository.ReservaRepository;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

public class ReservaTest {


    @Test
    public void deveCriarReservaDeSala() {

        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
        String email = "mauro_falcatrua@gmail.com";
        //When
        ReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(false);
        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodoInicio, periodoFim, email);

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
    public void naoDeveCriarReservaEmHorarioJaReservado() {

        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
        String email = "mauro_falcatrua@gmail.com";

        ReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(true);
        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodoInicio, periodoFim, email);
        } catch (Exception e) {
            Assert.assertEquals("TemReservaNaSalaPeriodo : A sala está ocupada neste período", e.getMessage());
        }

    }

    @Test
    public void naoDevePermitirAgendamentoEmPeriodoInvalido() {
        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
        //Periodo periodo = new Periodo(periodoInicio, periodoFim);
        String email = "mauro_falcatrua@gmail.com";

        ReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(false);

        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodoInicio, periodoFim, email);
            Assert.fail("Deveria ter informado que o período é inválido");
        } catch (Exception e){
            Assert.assertEquals("Periodo : O periodo inicial é maior que o periodo final.", e.getMessage());
        }
    }

    @Test
    public void naoDevePermitirAgendamentoNoPassado() {

//        Assert.fail("implementar asserts");
//        Sala sala = new Sala("40");
//        LocalDateTime periodoInicio = LocalDateTime.of(2017, Month.JUNE, 13, 00, 0);
//        LocalDateTime periodoFim = LocalDateTime.of(2017, Month.JUNE, 18, 00, 0);
//        String email = "mauro_falcatrua@gmail.com";
//        ReservaSpecificationImpl reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(false);
//
//        Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodoInicio, periodoFim, email);
//        Assert.assertEquals(email, reserva.getEmail());

    }
}
