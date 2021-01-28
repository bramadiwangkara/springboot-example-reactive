package com.sample.reactive.command.product;

import com.abinarystar.boot.command.reactive.Command;
import com.sample.reactive.command.model.request.product.CreateProductCommandRequest;
import com.sample.reactive.web.model.response.product.CreateProductWebResponse;

public interface CreateProductCommand extends Command<CreateProductCommandRequest, CreateProductWebResponse> {
}
