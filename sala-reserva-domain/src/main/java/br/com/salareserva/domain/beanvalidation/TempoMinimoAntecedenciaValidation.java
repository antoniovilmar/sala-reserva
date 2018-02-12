package br.com.salareserva.domain.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = TempoMinimoAntecedenciaValidationImpl.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TempoMinimoAntecedenciaValidation {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
