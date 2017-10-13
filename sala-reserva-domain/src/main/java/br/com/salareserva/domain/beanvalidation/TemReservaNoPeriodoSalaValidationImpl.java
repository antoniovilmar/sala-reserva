package br.com.salareserva.domain.beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TemReservaNoPeriodoSalaValidationImpl implements ConstraintValidator<TemReservaNoPeriodoSalaValidation, Boolean> {

  @Override
  public void initialize(TemReservaNoPeriodoSalaValidation value) {
  }

  @Override
  public boolean isValid(Boolean temReservaNoPeridoSala, ConstraintValidatorContext context) {

    return !temReservaNoPeridoSala;

  }

}