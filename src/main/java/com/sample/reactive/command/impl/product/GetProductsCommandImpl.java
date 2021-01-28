package com.sample.reactive.command.impl.product;

import com.sample.reactive.command.model.request.product.GetProductsCommandRequest;
import com.sample.reactive.command.product.GetProductsCommand;
import com.sample.reactive.repositories.ProductRepository;
import com.sample.reactive.repositories.model.Product;
import com.sample.reactive.web.model.response.product.GetProductsWebResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GetProductsCommandImpl implements GetProductsCommand {

    private final ProductRepository productRepository;

    public GetProductsCommandImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<List<GetProductsWebResponse>> execute(GetProductsCommandRequest request) {
        return Flux.defer(() -> findProducts(request))
                .map(this::toGetProductsWebResponse)
                .collectList();
    }

    private GetProductsWebResponse toGetProductsWebResponse(Product product) {
        return GetProductsWebResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .basePrice(product.getBasePrice())
                .build();
    }

    private Flux<Product> findProducts(GetProductsCommandRequest request) {
        return productRepository.findAllByNameLikeAndBasePriceBetweenAndDeletedIsFalse(request.getName(),
                request.getMinPrice(),
                request.getMaxPrice(),
                request.getPageable());
    }
}
