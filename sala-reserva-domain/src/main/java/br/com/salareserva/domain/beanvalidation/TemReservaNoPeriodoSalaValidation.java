package br.com.salareserva.domain.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = TemReservaNoPeriodoSalaValidationImpl.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TemReservaNoPeriodoSalaValidation {

  String message() default "{salaOcupadaNoPeriodo.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
