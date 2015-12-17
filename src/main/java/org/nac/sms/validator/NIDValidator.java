package org.nac.sms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NIDValidator implements ConstraintValidator<NID, String> {

    @Override
    public void initialize(NID param) {
    }

    @Override
    public boolean isValid(String nid, ConstraintValidatorContext context) {
        return nid.matches("\\d{6}");
    }
}
