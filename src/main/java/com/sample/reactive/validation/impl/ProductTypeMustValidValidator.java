package com.sample.reactive.validation.impl;

import com.sample.reactive.common.enumeration.ProductType;
import com.sample.reactive.validation.annotation.ProductTypeMustValid;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Optional;

public class ProductTypeMustValidValidator implements ConstraintValidator<ProductTypeMustValid, String> {
    @Override
    public void initialize(ProductTypeMustValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {
        return Optional.ofNullable(data)
                .filter(data1 -> StringUtils.isNotBlank(data))
                .map(s -> isProductTypeValid(data))
                .orElse(Boolean.FALSE);
    }

    private boolean isProductTypeValid(String productType) {
        return Arrays.stream(ProductType.values()).anyMatch(e -> e.toString().equals(productType));
    }

}
