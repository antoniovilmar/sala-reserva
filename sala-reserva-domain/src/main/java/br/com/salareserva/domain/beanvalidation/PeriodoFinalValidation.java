package br.com.salareserva.domain.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = EmailBeanValidationImpl.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PeriodoFinalValidation {

  String message() default "{javax.validation.constraints.PeriodoDataFinalNaoPreenchido.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
