package br.com.salareserva.api.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test-integration")
@AutoConfigureMockMvc
public abstract class BaseIT {

    @After
    public void tearDown(){
        expectedException = ExpectedException.none();
        flyway.clean();
        flyway.migrate();
    }

    @Autowired
    private MockMvc mvc;

    @Autowired
    private Flyway flyway;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public String toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return mapper.writeValueAsString(object);
    }

    public void waitExceptionCauseNotFoundEntity(){
        expectedException.expectCause(IsInstanceOf.instanceOf(EntityNotFoundException.class));
    }

    protected MockMvc getMvc() {
        return mvc;
    }

}
