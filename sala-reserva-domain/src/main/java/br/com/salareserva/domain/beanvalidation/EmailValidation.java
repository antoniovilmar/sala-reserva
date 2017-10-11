package br.com.salareserva.domain.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = EmailBeanValidationImpl.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidation {

  String message() default "{javax.validation.constraints.Email.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
