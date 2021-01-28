package com.sample.reactive.validation.annotation;

import com.sample.reactive.validation.impl.ProductTypeMustValidValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ProductTypeMustValidValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ProductTypeMustValid {
    Class<?>[] groups() default {};

    String message() default "ProductTypeMustValid";

    Class<? extends Payload>[] payload() default {};
}