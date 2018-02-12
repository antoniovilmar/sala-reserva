package br.com.salareserva.domain.beanvalidation;

import br.com.salareserva.domain.reserva.Periodo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class PeriodoInicialMaiorPeriodoFinalValidationImpl implements ConstraintValidator<PeriodoInicialMaiorPeriodoFinalValidation, Periodo> {

  @Override
  public void initialize(PeriodoInicialMaiorPeriodoFinalValidation value) {
  }

  @Override
  public boolean isValid(Periodo periodo, ConstraintValidatorContext context) {
    if(isNull(periodo) || periodo.naoTemPeriodo()){
      return Boolean.TRUE;
    }
    return periodo.getDataHoraInicio().isBefore(periodo.getDataHoraFim());

  }

}