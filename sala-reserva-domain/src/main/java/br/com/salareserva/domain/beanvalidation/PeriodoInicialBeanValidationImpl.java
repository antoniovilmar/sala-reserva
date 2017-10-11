package br.com.salareserva.domain.beanvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

import static java.util.Objects.nonNull;

public class PeriodoInicialBeanValidationImpl implements ConstraintValidator<PeriodoInicialValidation, LocalDateTime> {

  @Override
  public void initialize(PeriodoInicialValidation value) {
  }

  @Override
  public boolean isValid(LocalDateTime data, ConstraintValidatorContext context) {
    return nonNull(data);
  }

}