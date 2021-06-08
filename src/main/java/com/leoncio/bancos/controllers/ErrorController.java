package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("errors")
public class ErrorController {

    @GetMapping(produces = "application/json")
    public Response list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
