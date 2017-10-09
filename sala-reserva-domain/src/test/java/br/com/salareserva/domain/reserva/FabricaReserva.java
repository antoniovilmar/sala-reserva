package br.com.salareserva.domain.reserva;

@Compo
public class FabricaReserva {
    public Reserva criar(Sala sala, Periodo periodo, String email) {
        return sala.reservar(periodo, email);
    }
}
