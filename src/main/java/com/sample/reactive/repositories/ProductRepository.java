package com.sample.reactive.repositories;

import com.sample.reactive.repositories.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    Flux<Product> findAllByNameLikeAndBasePriceBetweenAndDeletedIsFalse(String name, Long min, Long max, Pageable pageable);
}
