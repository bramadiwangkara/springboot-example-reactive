package com.sample.reactive.repositories.model;

import com.abinarystar.boot.data.model.BaseEntity;
import com.sample.reactive.common.constants.CollectionName;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(CollectionName.ITEM)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item extends BaseEntity {
    private String id;
    private String productId;
    private Long price;
    private String colour;}
