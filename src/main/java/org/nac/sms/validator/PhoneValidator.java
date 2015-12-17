package org.nac.sms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone param) {
    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext context) {
        return (phoneNo.matches("\\d{11}") || phoneNo.matches("\\d{5}[\\s]\\d{6}"));
    }
}
