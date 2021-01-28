package com.sample.reactive.validation.impl;

import com.sample.reactive.properties.ProductProperties;
import com.sample.reactive.validation.annotation.BasePriceMustValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class BasePriceMustValidValidator implements ConstraintValidator<BasePriceMustValid, Long> {

    private final ProductProperties productProperties;

    public BasePriceMustValidValidator(ProductProperties productProperties) {
        this.productProperties = productProperties;
    }

    @Override
    public void initialize(BasePriceMustValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long basePrice, ConstraintValidatorContext constraintValidatorContext) {
        return Optional.ofNullable(basePrice)
                .map(this::isValidPriceMaxMin)
                .orElse(Boolean.FALSE);
    }

    private Boolean isValidPriceMaxMin(Long s) {
        return s >= productProperties.getMinBasePrice() && s <= productProperties.getMaxBasePrice();
    }
}
