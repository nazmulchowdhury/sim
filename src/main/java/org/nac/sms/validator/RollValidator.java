package org.nac.sms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RollValidator implements ConstraintValidator<Roll, String> {

    @Override
    public void initialize(Roll param) {
    }

    @Override
    public boolean isValid(String roll, ConstraintValidatorContext context) {
        return roll.matches(("\\d{6}"));
    }
}
