package com.leoncio.bancos.controllers;

import com.leoncio.bancos.services.BankService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BankController.class)
class BankControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankService service;

    @Test
    void list() throws Exception {
        this.mockMvc.perform(get("/banks"))
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void show() {
    }

    @Test
    void edit() {
    }

    @Test
    void create() {
    }

    @Test
    void destroy() {
    }
}