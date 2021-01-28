package com.sample.reactive.web.controller.product;

import com.abinarystar.boot.command.reactive.executor.CommandExecutor;
import com.abinarystar.boot.common.helper.ResponseHelper;
import com.abinarystar.boot.common.model.web.response.Response;
import com.abinarystar.boot.web.controller.reactive.BaseController;
import com.sample.reactive.command.model.request.product.CreateProductCommandRequest;
import com.sample.reactive.command.model.request.product.GetDetailProductCommandRequest;
import com.sample.reactive.command.model.request.product.GetProductsCommandRequest;
import com.sample.reactive.command.product.CreateProductCommand;
import com.sample.reactive.command.product.GetDetailProductCommand;
import com.sample.reactive.command.product.GetProductsCommand;
import com.sample.reactive.web.model.request.product.CreateProductWebRequest;
import com.sample.reactive.web.model.response.product.CreateProductWebResponse;
import com.sample.reactive.web.model.response.product.GetDetailProductWebResponse;
import com.sample.reactive.web.model.response.product.GetProductsWebResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(value = "/backend/sample-reactive/product", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController extends BaseController {
    public ProductController(CommandExecutor executor) {
        super(executor);
    }

    @PostMapping
    public Mono<Response<CreateProductWebResponse>> create(@RequestBody CreateProductWebRequest createProductWebRequest) {
        CreateProductCommandRequest commandRequest = CreateProductCommandRequest.builder()
                .name(createProductWebRequest.getName())
                .basePrice(createProductWebRequest.getBasePrice())
                .productType(createProductWebRequest.getProductType())
                .build();

        return executor.execute(CreateProductCommand.class, commandRequest)
                .map(ResponseHelper::ok);
    }

    @GetMapping(value = "/{id}")
    public Mono<Response<GetDetailProductWebResponse>> get(@PathVariable String id) {
        GetDetailProductCommandRequest commandRequest = GetDetailProductCommandRequest.builder()
                .id(id)
                .build();

        return executor.execute(GetDetailProductCommand.class, commandRequest)
                .map(ResponseHelper::ok);
    }

    @GetMapping
    public Mono<Response<List<GetProductsWebResponse>>> getList(@RequestParam(required = false) String name,
                                                                @RequestParam(required = false) Long maxPrice,
                                                                @RequestParam(required = false) Long minPrice,
                                                                @RequestParam int page,
                                                                @RequestParam int size,
                                                                @RequestParam(defaultValue = "createdDate") String sortBy,
                                                                @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection){
        GetProductsCommandRequest commandRequest = GetProductsCommandRequest.builder()
                .name(name)
                .maxPrice(maxPrice)
                .minPrice(minPrice)
                .pageable(PageRequest.of(page, size, sortDirection, sortBy))
                .build();

        return executor.execute(GetProductsCommand.class, commandRequest)
                .map(ResponseHelper::ok);

    }
}
