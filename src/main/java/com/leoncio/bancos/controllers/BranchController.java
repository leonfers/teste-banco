package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.dto.ResponseDTO;
import com.leoncio.bancos.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("branches")
public class BranchController {

    @GetMapping(produces = "application/json")
    public ResponseDTO list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO edit(@PathVariable int id, @RequestBody BranchDTO branchDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public ResponseDTO create(@RequestBody BranchDTO branchDTO) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
