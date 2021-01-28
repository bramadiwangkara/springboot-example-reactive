package com.sample.reactive.command.impl.product;

import com.abinarystar.boot.kafka.producer.reactive.KafkaProducer;
import com.sample.reactive.command.model.request.product.CreateProductCommandRequest;
import com.sample.reactive.command.product.CreateProductCommand;
import com.sample.reactive.common.enumeration.ProductType;
import com.sample.reactive.repositories.ProductRepository;
import com.sample.reactive.repositories.model.Product;
import com.sample.reactive.web.model.response.product.CreateProductWebResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProductCommandImpl implements CreateProductCommand {

    private final ProductRepository productRepository;
    private final KafkaProducer kafkaProducer;

    public CreateProductCommandImpl(ProductRepository productRepository, KafkaProducer kafkaProducer) {
        this.productRepository = productRepository;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public Mono<CreateProductWebResponse> execute(CreateProductCommandRequest request) {
        return Mono.defer(() -> saveProduct(request))
                .doOnSuccess(this::sendProductEvent)
                .map(this::toCreateProductWebResponse);
    }

    private void sendProductEvent(Product product) {
        //for publishing to kafka
    }

    private CreateProductWebResponse toCreateProductWebResponse(Product product) {
        return CreateProductWebResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .basePrice(product.getBasePrice())
                .productType(product.getProductType())
                .createdDate(product.getCreatedDate())
                .lastModifiedDate(product.getLastModifiedDate())
                .build();
    }

    private Mono<Product> saveProduct(CreateProductCommandRequest request) {

        return productRepository.save(Product.builder()
                .name(request.getName())
                .basePrice(request.getBasePrice())
                .productType(ProductType.valueOf(request.getProductType()))
                .build());
    }

}
