package studio.thinkground.aroundhub.mvc.common.valid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import studio.thinkground.aroundhub.mvc.common.annotation.ValidationAnnotation;

public class ParameterValidator implements ConstraintValidator<ValidationAnnotation, String> {
  @Override
  public void initialize(ValidationAnnotation constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value != null && value.equals("hello");
  }
}
