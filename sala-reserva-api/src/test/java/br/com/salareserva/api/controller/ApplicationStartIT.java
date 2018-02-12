package br.com.salareserva.api.controller;

import br.com.salareserva.api.ApplicationStart;
import org.junit.Test;

public class ApplicationStartIT extends BaseIT {

    @Test
    public void deveCriarContextoWeb() throws Exception {

        ApplicationStart.main(new String[]{
        });

    }


}
