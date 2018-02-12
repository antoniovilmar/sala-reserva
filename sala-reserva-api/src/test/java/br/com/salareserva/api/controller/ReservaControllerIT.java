package br.com.salareserva.api.controller;

import br.com.salareserva.application.reserva.dto.ReservaDto;
import br.com.salareserva.domain.repository.IReservaRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.apache.commons.lang3.CharEncoding.UTF_8;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReservaControllerIT extends BaseIT {

    private final String RESERVA_CONTROLLER_IT_SQL = "ReservaControllerIT.sql";
    private final String PRIMEIRA_RESERVA_EMAIL_RESPONSAVEL = "teste@teste.com.br";

    private final String PRIMEIRA_RESERVA_SALA = "ABC123";
    private final Integer PRIMEIRA_RESERVA_ID = 1;
    private final Integer PRIMEIRA_RESERVA_ANO_INICIO = 2017;
    private final Integer PRIMEIRA_RESERVA_MES_INICIO = 8;
    private final Integer PRIMEIRA_RESERVA_DIA_INICIO = 10;
    private final Integer PRIMEIRA_RESERVA_HORA_INICIO = 8;
    private final Integer PRIMEIRA_RESERVA_MINUTO_INICIO = 0;
    private final Integer PRIMEIRA_RESERVA_HORA_FIM = 11;
    private final Integer PRIMEIRA_RESERVA_MINUTO_FIM = 30;
    private final Integer PRIMEIRA_RESERVA_SEGUNDO_FIM = 50;
    private final Integer SEGUNDA_RESERVA_ID = 2;

    private final String SEGUNDA_RESERVA_EMAIL_RESPONSAVEL = "felipe@gmail.com";
    private final String SEGUNDA_RESERVA_SALA = "ALA323";
    private final Integer SEGUNDA_RESERVA_ANO_INICIO = 2017;
    private final Integer SEGUNDA_RESERVA_MES_INICIO = 8;
    private final Integer SEGUNDA_RESERVA_DIA_INICIO = 10;
    private final Integer SEGUNDA_RESERVA_HORA_INICIO = 22;
    private final Integer SEGUNDA_RESERVA_MINUTO_INICIO = 30;
    private final Integer SEGUNDA_RESERVA_HORA_FIM = 23;
    private final Integer SEGUNDA_RESERVA_MINUTO_FIM = 30;
    private final Long RESERVA_ID_INEXISTENTE = 1231231231L;

    @Autowired
    private IReservaRepository reservaRepository;

    @Test
    public void deveCriarUmaReserva() throws Exception {

        String idSala = "1234";
        LocalDateTime dataHoraInicio = LocalDateTime.now().plusHours(2);
        LocalDateTime dataHoraFim = LocalDateTime.now().plusHours(3);
        String emailResponsavel = "Teste@teste.com.br";

        ReservaDto reservaParaSalvar = new ReservaDto(idSala, dataHoraInicio, dataHoraFim, emailResponsavel);

        getMvc().perform(
                post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(reservaParaSalvar)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.idSala", is(idSala)))
                .andExpect(jsonPath("$.emailResponsavel", is(emailResponsavel)))
                .andExpect(jsonPath("$.dataHoraInicio[0]", is(dataHoraInicio.getYear())))
                .andExpect(jsonPath("$.dataHoraInicio[1]", is(dataHoraInicio.getMonthValue())))
                .andExpect(jsonPath("$.dataHoraInicio[2]", is(dataHoraInicio.getDayOfMonth())))
                .andExpect(jsonPath("$.dataHoraInicio[3]", is(dataHoraInicio.getHour())))
                .andExpect(jsonPath("$.dataHoraInicio[4]", is(dataHoraInicio.getMinute())))
                .andExpect(jsonPath("$.dataHoraInicio[5]", is(dataHoraInicio.getSecond())))
                .andExpect(jsonPath("$.dataHoraFim[0]", is(dataHoraFim.getYear())))
                .andExpect(jsonPath("$.dataHoraFim[1]", is(dataHoraFim.getMonthValue())))
                .andExpect(jsonPath("$.dataHoraFim[2]", is(dataHoraFim.getDayOfMonth())))
                .andExpect(jsonPath("$.dataHoraFim[3]", is(dataHoraFim.getHour())))
                .andExpect(jsonPath("$.dataHoraFim[4]", is(dataHoraFim.getMinute())))
                .andExpect(jsonPath("$.dataHoraFim[5]", is(dataHoraFim.getSecond())));

    }

    @Test
    @Sql(value = RESERVA_CONTROLLER_IT_SQL, config = @SqlConfig(encoding = UTF_8), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void deveListarReservasSalvas() throws Exception {

        getMvc().perform(get("/reserva", ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(PRIMEIRA_RESERVA_ID)))
                .andExpect(jsonPath("$[0].idSala", is(PRIMEIRA_RESERVA_SALA)))
                .andExpect(jsonPath("$[0].emailResponsavel", is(PRIMEIRA_RESERVA_EMAIL_RESPONSAVEL)))
                .andExpect(jsonPath("$[0].dataHoraInicio[0]", is(PRIMEIRA_RESERVA_ANO_INICIO)))
                .andExpect(jsonPath("$[0].dataHoraInicio[1]", is(PRIMEIRA_RESERVA_MES_INICIO)))
                .andExpect(jsonPath("$[0].dataHoraInicio[2]", is(PRIMEIRA_RESERVA_DIA_INICIO)))
                .andExpect(jsonPath("$[0].dataHoraInicio[3]", is(PRIMEIRA_RESERVA_HORA_INICIO)))
                .andExpect(jsonPath("$[0].dataHoraInicio[4]", is(PRIMEIRA_RESERVA_MINUTO_INICIO)))
                .andExpect(jsonPath("$[0].dataHoraInicio", hasSize(5)))
                .andExpect(jsonPath("$[0].dataHoraFim[0]", is(PRIMEIRA_RESERVA_ANO_INICIO)))
                .andExpect(jsonPath("$[0].dataHoraFim[1]", is(PRIMEIRA_RESERVA_MES_INICIO)))
                .andExpect(jsonPath("$[0].dataHoraFim[2]", is(PRIMEIRA_RESERVA_DIA_INICIO)))
                .andExpect(jsonPath("$[0].dataHoraFim[3]", is(PRIMEIRA_RESERVA_HORA_FIM)))
                .andExpect(jsonPath("$[0].dataHoraFim[4]", is(PRIMEIRA_RESERVA_MINUTO_FIM)))
                .andExpect(jsonPath("$[0].dataHoraFim[5]", is(PRIMEIRA_RESERVA_SEGUNDO_FIM)))
                .andExpect(jsonPath("$[0].dataHoraFim", hasSize(6)))
                .andExpect(jsonPath("$[1].id", is(SEGUNDA_RESERVA_ID)))
                .andExpect(jsonPath("$[1].idSala", is(SEGUNDA_RESERVA_SALA)))
                .andExpect(jsonPath("$[1].emailResponsavel", is(SEGUNDA_RESERVA_EMAIL_RESPONSAVEL)))
                .andExpect(jsonPath("$[1].dataHoraInicio[0]", is(SEGUNDA_RESERVA_ANO_INICIO)))
                .andExpect(jsonPath("$[1].dataHoraInicio[1]", is(SEGUNDA_RESERVA_MES_INICIO)))
                .andExpect(jsonPath("$[1].dataHoraInicio[2]", is(SEGUNDA_RESERVA_DIA_INICIO)))
                .andExpect(jsonPath("$[1].dataHoraInicio[3]", is(SEGUNDA_RESERVA_HORA_INICIO)))
                .andExpect(jsonPath("$[1].dataHoraInicio[4]", is(SEGUNDA_RESERVA_MINUTO_INICIO)))
                .andExpect(jsonPath("$[1].dataHoraInicio", hasSize(5)))
                .andExpect(jsonPath("$[1].dataHoraFim[0]", is(SEGUNDA_RESERVA_ANO_INICIO)))
                .andExpect(jsonPath("$[1].dataHoraFim[1]", is(SEGUNDA_RESERVA_MES_INICIO)))
                .andExpect(jsonPath("$[1].dataHoraFim[2]", is(SEGUNDA_RESERVA_DIA_INICIO)))
                .andExpect(jsonPath("$[1].dataHoraFim[3]", is(SEGUNDA_RESERVA_HORA_FIM)))
                .andExpect(jsonPath("$[1].dataHoraFim[4]", is(SEGUNDA_RESERVA_MINUTO_FIM)))
                .andExpect(jsonPath("$[1].dataHoraFim", hasSize(5)));

    }

    @Test
    public void deveRetornarUmaListaVaziaQuandoNaoExisteReservas() throws Exception {

        getMvc().perform(get("/reserva", ""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

    }


    @Test
    @Sql(value = RESERVA_CONTROLLER_IT_SQL, config = @SqlConfig(encoding = UTF_8), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void deveRetornarUmaReservaExistente() throws Exception {

        getMvc().perform(
                get("/reserva/{id}", PRIMEIRA_RESERVA_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(PRIMEIRA_RESERVA_ID)))
                .andExpect(jsonPath("$.idSala", is(PRIMEIRA_RESERVA_SALA)))
                .andExpect(jsonPath("$.emailResponsavel", is(PRIMEIRA_RESERVA_EMAIL_RESPONSAVEL)))
                .andExpect(jsonPath("$.dataHoraInicio[0]", is(PRIMEIRA_RESERVA_ANO_INICIO)))
                .andExpect(jsonPath("$.dataHoraInicio[1]", is(PRIMEIRA_RESERVA_MES_INICIO)))
                .andExpect(jsonPath("$.dataHoraInicio[2]", is(PRIMEIRA_RESERVA_DIA_INICIO)))
                .andExpect(jsonPath("$.dataHoraInicio[3]", is(PRIMEIRA_RESERVA_HORA_INICIO)))
                .andExpect(jsonPath("$.dataHoraInicio[4]", is(PRIMEIRA_RESERVA_MINUTO_INICIO)))
                .andExpect(jsonPath("$.dataHoraInicio", hasSize(5)))
                .andExpect(jsonPath("$.dataHoraFim[0]", is(PRIMEIRA_RESERVA_ANO_INICIO)))
                .andExpect(jsonPath("$.dataHoraFim[1]", is(PRIMEIRA_RESERVA_MES_INICIO)))
                .andExpect(jsonPath("$.dataHoraFim[2]", is(PRIMEIRA_RESERVA_DIA_INICIO)))
                .andExpect(jsonPath("$.dataHoraFim[3]", is(PRIMEIRA_RESERVA_HORA_FIM)))
                .andExpect(jsonPath("$.dataHoraFim[4]", is(PRIMEIRA_RESERVA_MINUTO_FIM)))
                .andExpect(jsonPath("$.dataHoraFim[5]", is(PRIMEIRA_RESERVA_SEGUNDO_FIM)))
                .andExpect(jsonPath("$.dataHoraFim", hasSize(6)));

    }

    @Test
    @Sql(value = RESERVA_CONTROLLER_IT_SQL, config = @SqlConfig(encoding = UTF_8, transactionMode = SqlConfig.TransactionMode.ISOLATED), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Transactional
    public void deveExcluirUmaReservaExistente() throws Exception {

        getMvc().perform(
                delete("/reserva/{id}", PRIMEIRA_RESERVA_ID))
                .andExpect(status().isNoContent());
        waitExceptionCauseNotFoundEntity();
        reservaRepository.consultarPorId(PRIMEIRA_RESERVA_ID.longValue());

    }

    @Test
    public void deveRetornarErroAoTentarExcluirUmaReservaInexistente() throws Exception {

        getMvc().perform(
                delete("/reserva/{id}", RESERVA_ID_INEXISTENTE))
                .andExpect(status().isNotFound());


    }

    @Test
    public void deveRetornarErroAoTentarBuscarUmaReservaInexistente() throws Exception {
        getMvc().perform(
                get("/reserva/{id}", RESERVA_ID_INEXISTENTE))
                .andExpect(status().isNotFound());
    }

    @Test
    public void naoDeveCriarUmaReservaComCamposObrigatoriosEmBranco() throws Exception {


        ReservaDto reservaParaSalvar = new ReservaDto(null, null, null, null);

        getMvc().perform(
                post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(reservaParaSalvar)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.mensagem", is("Email : Campo Obrigatório. \n Periodo.dataHoraInicio : Campo Obrigatório. \n Periodo.dataHoraFim : Campo Obrigatório.")));

    }

    @Test
    public void naoDeveCriarUmaReservaComMenosDe1hDeAntecedencia() throws Exception {

        LocalDateTime periodoInicio = LocalDateTime.now();
        LocalDateTime periodoFim = LocalDateTime.now().plusHours(1);
        String email = "mauro_falcatrua@gmail.com";
        String sala = "40";


        ReservaDto reservaParaSalvar = new ReservaDto(sala, periodoInicio, periodoFim, email);

        getMvc().perform(
                post("/reserva")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(reservaParaSalvar)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.mensagem", is("Periodo : O tempo mínimo de antecedência é de uma hora")));

    }


}
