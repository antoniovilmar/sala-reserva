package br.com.salareserva.domain.beanvalidation;

import br.com.salareserva.domain.reserva.Periodo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeriodoInicialMaiorPeriodoFinalValidationImpl implements ConstraintValidator<PeriodoInicialMaiorPeriodoFinalValidation, Periodo> {

  @Override
  public void initialize(PeriodoInicialMaiorPeriodoFinalValidation value) {
  }

  @Override
  public boolean isValid(Periodo periodo, ConstraintValidatorContext context) {
    return periodo.getDataInicio().isBefore(periodo.getDataFim());

  }

}