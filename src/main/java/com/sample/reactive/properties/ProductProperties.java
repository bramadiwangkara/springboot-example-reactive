package com.sample.reactive.properties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("product.properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductProperties {
    private Long minBasePrice;
    private Long maxBasePrice;
}
