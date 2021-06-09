package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.services.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("errors")
public class ErrorController {

    private final ErrorService errorService;

    @Autowired
    public ErrorController(ErrorService errorService) {
        this.errorService = errorService;
    }

    @GetMapping(produces = "application/json")
    public Response list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{code}", produces = "application/json")
    public Response show(@PathVariable int code) {
        throw new UnsupportedOperationException();
    }
}
