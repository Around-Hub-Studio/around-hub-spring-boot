package studio.thinkground.aroundhub.mvc.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import studio.thinkground.aroundhub.mvc.common.valid.ParameterValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ParameterValidator.class)
public @interface ValidationAnnotation {
  String message() default "Invalid Value. It should be 'hello'";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
