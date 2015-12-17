package org.nac.sms.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CGPAValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CGPA {

    String message() default "Invalid CGPA Scale";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
