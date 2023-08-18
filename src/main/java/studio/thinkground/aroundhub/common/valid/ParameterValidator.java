package studio.thinkground.aroundhub.common.valid;

import studio.thinkground.aroundhub.common.annotation.ValidationAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
