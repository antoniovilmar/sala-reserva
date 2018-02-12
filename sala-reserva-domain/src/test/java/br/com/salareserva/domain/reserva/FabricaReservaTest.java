package br.com.salareserva.domain.reserva;

import br.com.salareserva.domain.repository.IReservaRepository;
import br.com.salareserva.domain.reserva.provider.ReservaRepositoryMockProvider;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class FabricaReservaTest {


    @Test
    public void deveCriarReservaDeSala() {

        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.now().plusDays(1).withHour(13).withMinute(0).withSecond(0);
        LocalDateTime periodoFim = LocalDateTime.now().plusDays(1).withHour(18).withMinute(0).withSecond(0);
        String email = "mauro_falcatrua@gmail.com";
        //When
        IReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(false);
        Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodoInicio, periodoFim, email);

        //Then
        Assert.assertEquals(email, reserva.getEmail());
        Assert.assertEquals(sala.getId(), reserva.getSala().getId());
        Assert.assertEquals(periodoInicio, reserva.getPeriodo().getDataHoraInicio());
        Assert.assertEquals(periodoFim, reserva.getPeriodo().getDataHoraFim());
    }

    @Test
    public void naoDeveCriarReservaEmHorarioJaReservado() {

        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.now().plusDays(1).withHour(13).withMinute(0).withSecond(0);
        LocalDateTime periodoFim = LocalDateTime.now().plusDays(1).withHour(18).withMinute(0).withSecond(0);
        String email = "mauro_falcatrua@gmail.com";

        IReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(true);
        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodoInicio, periodoFim, email);
        } catch (Exception e) {
            Assert.assertEquals("A sala está ocupada neste período", e.getMessage());
        }

    }

    @Test
    public void naoDevePermitirAgendamentoEmPeriodoInvalido() {
        //Given
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.now().plusDays(1).withHour(18).withMinute(0).withSecond(0);
        LocalDateTime periodoFim = LocalDateTime.now().plusDays(1).withHour(13).withMinute(0).withSecond(0);
        String email = "mauro_falcatrua@gmail.com";

        IReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(false);

        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodoInicio, periodoFim, email);
            Assert.fail("Deveria ter informado que o período é inválido");
        } catch (Exception e) {
            Assert.assertEquals("Periodo : O periodo inicial é maior que o periodo final.", e.getMessage());
        }
    }

    @Test
    public void naoDevePermitirAgendamentoComMenosDeUmaHoraDeAntecedencia() {
        Sala sala = new Sala("40");
        LocalDateTime periodoInicio = LocalDateTime.now();
        LocalDateTime periodoFim = LocalDateTime.now().plusHours(1);
        String email = "mauro_falcatrua@gmail.com";
        IReservaRepository reservaRepository = ReservaRepositoryMockProvider.existeReservaPorPeriodo(false);

        try {
            Reserva reserva = new FabricaReserva(reservaRepository).criar(sala, periodoInicio, periodoFim, email);
            Assert.fail("Deveria ter disparado exceção");
        } catch (Exception e) {
            Assert.assertEquals("Periodo : O tempo mínimo de antecedência é de uma hora", e.getMessage());
        }
    }
}
