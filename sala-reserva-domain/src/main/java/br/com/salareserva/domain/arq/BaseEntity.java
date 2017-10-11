package br.com.salareserva.domain.arq;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.MappedSuperclass;
import javax.validation.*;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
public abstract class BaseEntity implements Entity {

	private static final long serialVersionUID = -7653894205644354419L;

	protected BaseEntity() {

	}


	public final void isValid() {
		Configuration<?> config = Validation.byDefaultProvider().configure();
		ValidatorFactory factory = config.buildValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BaseEntity>> violations = validator.validate(this);

		Set<String> violationMessages = new HashSet<String>();

		for (ConstraintViolation<BaseEntity> constraintViolation : violations) {
			String campo = StringUtils.capitalize(constraintViolation.getPropertyPath().toString());
			String msg = constraintViolation.getMessage();
			violationMessages.add(campo.concat(" : ").concat(msg));
		}
		
		if (!violationMessages.isEmpty()) {
			throw new DomainBusinessException(StringUtils.join(violationMessages, " \n "));
		}
	}

}