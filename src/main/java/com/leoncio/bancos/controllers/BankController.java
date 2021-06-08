package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("banks")
public class BankController {
    @GetMapping(produces = "application/json")
    public ResponseDTO list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO edit(@PathVariable int id, @RequestBody BankDTO bankDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public ResponseDTO create(@RequestBody BankDTO bankDTO) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
