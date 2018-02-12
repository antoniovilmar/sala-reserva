package br.com.salareserva.domain.beanvalidation;

import br.com.salareserva.domain.reserva.Periodo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class TempoMinimoAntecedenciaValidationImpl implements ConstraintValidator<TempoMinimoAntecedenciaValidation, Periodo> {

    @Override
    public void initialize(TempoMinimoAntecedenciaValidation value) {
    }

    @Override
    public boolean isValid(Periodo periodo, ConstraintValidatorContext context) {
        if(isNull(periodo) || periodo.naoTemPeriodo()){
            return Boolean.TRUE;
        }
        //posso reservar apenas com uma hora de antecedencia.
        LocalDateTime umaHoraDepois = LocalDateTime.now().plusHours(1);
        return periodo.getDataHoraInicio().isAfter(umaHoraDepois);
    }

}
