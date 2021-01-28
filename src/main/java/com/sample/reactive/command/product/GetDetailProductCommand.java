package com.sample.reactive.command.product;

import com.abinarystar.boot.command.reactive.Command;
import com.sample.reactive.command.model.request.product.GetDetailProductCommandRequest;
import com.sample.reactive.web.model.response.product.GetDetailProductWebResponse;

public interface GetDetailProductCommand extends Command<GetDetailProductCommandRequest, GetDetailProductWebResponse> {
}
