package com.sample.reactive.command.model.request.product;

import com.sample.reactive.validation.annotation.BasePriceMustValid;
import com.sample.reactive.validation.annotation.ProductTypeMustValid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductCommandRequest {
    @NotNull
    private String name;

    @BasePriceMustValid
    private Long basePrice;

    @ProductTypeMustValid
    private String productType;
}
