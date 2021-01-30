package com.sample.reactive.web.controller.item;

import com.abinarystar.boot.command.reactive.executor.CommandExecutor;
import com.abinarystar.boot.common.helper.ResponseHelper;
import com.abinarystar.boot.common.model.web.response.Response;
import com.abinarystar.boot.web.controller.reactive.BaseController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/backend/sample-reactive/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController extends BaseController {


    public ItemController(CommandExecutor executor) {
        super(executor);
    }


    @GetMapping
    public Mono<Response<Boolean>> saveItem(){
        return Mono.just(ResponseHelper.ok(Boolean.TRUE));
    }
}
