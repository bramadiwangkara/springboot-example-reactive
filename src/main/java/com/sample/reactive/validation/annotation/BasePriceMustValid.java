package com.sample.reactive.validation.annotation;

import com.sample.reactive.validation.impl.BasePriceMustValidValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = BasePriceMustValidValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BasePriceMustValid {
    Class<?>[] groups() default {};

    String message() default "BasePriceMustValid";

    Class<? extends Payload>[] payload() default {};
}
