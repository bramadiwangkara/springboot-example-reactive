package com.sample.reactive.web.model.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductsWebResponse {
    private String id;
    private String name;
    private Long basePrice;
}
