package com.sample.reactive.command.product;

import com.abinarystar.boot.command.reactive.Command;
import com.sample.reactive.command.model.request.product.GetProductsCommandRequest;
import com.sample.reactive.web.model.response.product.GetProductsWebResponse;

import java.util.List;

public interface GetProductsCommand extends Command<GetProductsCommandRequest, List<GetProductsWebResponse>> {
}
