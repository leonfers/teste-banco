package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.ResponseDTO;
import com.leoncio.bancos.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(produces = "application/json")
    public ResponseDTO list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO edit(@PathVariable int id, @RequestBody UserDTO userDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public ResponseDTO create(@RequestBody UserDTO userDTO) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
