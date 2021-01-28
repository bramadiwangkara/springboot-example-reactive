package com.sample.reactive.command.model.request.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductsCommandRequest {
    private String name;
    private Long maxPrice;
    private Long minPrice;

    @NotNull
    private Pageable pageable;
}
