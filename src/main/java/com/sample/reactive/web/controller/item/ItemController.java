package com.sample.reactive.web.controller.item;

import com.abinarystar.boot.command.reactive.executor.CommandExecutor;
import com.abinarystar.boot.web.controller.reactive.BaseController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/backend/sample-reactive/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController extends BaseController {


    public ItemController(CommandExecutor executor) {
        super(executor);
    }
}
