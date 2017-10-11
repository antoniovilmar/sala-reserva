package br.com.salareserva.domain.beanvalidation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailBeanValidationImpl implements ConstraintValidator<EmailValidation, String> {

  @Override
  public void initialize(EmailValidation value) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (StringUtils.isBlank(value)) {
      return Boolean.TRUE;
    }
    return validarEmail(value);
  }

  private Boolean validarEmail(String email) {
    Pattern pattern = Pattern.compile("^[^0-9][a-zA-Z0-9_-]+([.][a-zA-Z0-9_]+)*[@][a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,4}$");
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}