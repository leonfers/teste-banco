package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.CustomerDTO;
import com.leoncio.bancos.dto.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cusstomers")
public class CustomerController {

    @GetMapping(produces = "application/json")
    public Response list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable int id, @RequestBody CustomerDTO customerDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public Response create(@RequestBody CustomerDTO customerDTO) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
