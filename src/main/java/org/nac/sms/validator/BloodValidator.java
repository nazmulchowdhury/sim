package org.nac.sms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BloodValidator implements ConstraintValidator<Blood, String> {

    @Override
    public void initialize(Blood param) {
    }

    @Override
    public boolean isValid(String word, ConstraintValidatorContext context) {
        return word.matches("(A|B|AB|O)[+-]");
    }
}
