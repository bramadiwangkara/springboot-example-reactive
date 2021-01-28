package com.sample.reactive.web.model.response.product;

import com.sample.reactive.common.enumeration.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductWebResponse {
    private String id;
    private String name;
    private Long basePrice;
    private ProductType productType;
    private Date createdDate;
    private Date lastModifiedDate;
}
