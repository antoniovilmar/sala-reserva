package br.com.salareserva.domain.base;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@MappedSuperclass
public abstract class Entity<T extends Entity> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	protected Long id;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		T t = (T) o;
		return Objects.equals(id, t.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Long getId() {
		return id;
	}

	public final void isValid() {
		Configuration<?> config = Validation.byDefaultProvider().configure();
		ValidatorFactory factory = config.buildValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Entity>> violations = validator.validate(this);

		Set<String> violationMessages = new HashSet<String>();

		for (ConstraintViolation<Entity> constraintViolation : violations) {
			String campo = StringUtils.capitalize(constraintViolation.getPropertyPath().toString());
			String msg = constraintViolation.getMessage();
			violationMessages.add(campo.concat(" : ").concat(msg));
		}

		if (!violationMessages.isEmpty()) {
			throw new DomainBusinessException(StringUtils.join(violationMessages, " \n "));
		}
	}

}