package org.nac.sms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CGPAValidator implements ConstraintValidator<CGPA, String> {

    @Override
    public void initialize(CGPA param) {
    }

    @Override
    public boolean isValid(String cgpa, ConstraintValidatorContext context) {
        return cgpa.matches("^[0]|[0-3]\\.(\\d?\\d?)|[4].[0][0]$");
    }
}
