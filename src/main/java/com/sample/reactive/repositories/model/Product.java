package com.sample.reactive.repositories.model;

import com.abinarystar.boot.data.model.BaseEntity;
import com.sample.reactive.common.constants.CollectionName;
import com.sample.reactive.common.enumeration.ProductType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(CollectionName.PRODUCT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    @Id
    private String id;
    private String name;
    private Long basePrice;
    private ProductType productType;
}
