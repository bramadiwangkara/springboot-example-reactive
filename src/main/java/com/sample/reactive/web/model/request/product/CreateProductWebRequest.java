package com.sample.reactive.web.model.request.product;

import com.sample.reactive.common.enumeration.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProductWebRequest {
    private String name;
    private Long basePrice;
    private String productType;
}
