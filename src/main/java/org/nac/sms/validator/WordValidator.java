package org.nac.sms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WordValidator implements ConstraintValidator<Word, String> {

    @Override
    public void initialize(Word param) {
    }

    @Override
    public boolean isValid(String word, ConstraintValidatorContext context) {
        return (word.matches("^[A-Za-z ]+$") && word.length() >= 5 && word.length() <= 30);
    }
}
