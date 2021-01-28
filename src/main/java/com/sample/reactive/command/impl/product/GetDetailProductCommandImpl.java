package com.sample.reactive.command.impl.product;

import com.abinarystar.boot.validation.model.exception.ValidationException;
import com.sample.reactive.command.model.request.product.GetDetailProductCommandRequest;
import com.sample.reactive.command.product.GetDetailProductCommand;
import com.sample.reactive.repositories.ProductRepository;
import com.sample.reactive.repositories.model.Product;
import com.sample.reactive.web.model.response.product.GetDetailProductWebResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;


@Service
public class GetDetailProductCommandImpl implements GetDetailProductCommand {

    private final ProductRepository productRepository;

    public GetDetailProductCommandImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<GetDetailProductWebResponse> execute(GetDetailProductCommandRequest request) {
        return Mono.defer(()-> productRepository.findById(request.getId()))
                .map(this::toGetDetailProductWebResponse)
                .switchIfEmpty(Mono.error(new ValidationException("productId", "PRODUCT_NOT_FOUND")));
    }

    private GetDetailProductWebResponse toGetDetailProductWebResponse(Product product) {
        return GetDetailProductWebResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .productType(product.getProductType())
                .basePrice(product.getBasePrice())
                .createdDate(product.getCreatedDate())
                .lastModifiedDate(product.getLastModifiedDate())
                .build();
    }
}
