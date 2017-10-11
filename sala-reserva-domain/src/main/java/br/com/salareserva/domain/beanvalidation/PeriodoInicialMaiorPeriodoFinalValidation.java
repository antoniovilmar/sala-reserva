package br.com.salareserva.domain.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PeriodoInicialMaiorPeriodoFinalValidationImpl.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PeriodoInicialMaiorPeriodoFinalValidation {

  String message() default "{javax.validation.constraints.NotEmpty.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
