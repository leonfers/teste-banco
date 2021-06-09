package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.form.BankForm;
import com.leoncio.bancos.models.Bank;
import com.leoncio.bancos.repositories.BankRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@ActiveProfiles("dev")
class BankServiceImplTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankServiceImpl bankService;

    @Test
    public void when_save_bank_it_should_return_bank_dto(){
        BankDTO bankDTO = new BankDTO(new BankForm("0001", "Nubank"));
        Bank bank = new Bank();
        bank.setId(1);
        bank.setCode("0001");
        bank.setName("Nubank");
        when(bankRepository.save(ArgumentMatchers.any(Bank.class))).thenReturn(new Bank());
        BankDTO created = bankService.save(bankDTO);
        assertThat(created.getName()).isSameAs(bankDTO.getName());
    }

    @Test
    public void when_find_by_id_bank_it_should_return_bank_dto(){
        Bank bank = new Bank();
        bank.setId(1);
        bank.setCode("0001");
        bank.setName("Nubank");
        when(bankRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.of(bank));
        BankDTO created = bankService.findById(1);
        assertThat(created.getName()).isSameAs(bank.getName());
    }

    @Test
    public void when_find_all_it_should_return_list_of_bank_dto(){
        Bank bank = new Bank();
        bank.setId(1);
        bank.setCode("0001");
        bank.setName("Nubank");
        when(bankRepository.findAll()).thenReturn(Collections.singletonList(bank));
        List<BankDTO> created = bankService.findAll();
        assertThat(created.get(0).getName()).isSameAs(bank.getName());
    }

    @Test
    public void when_destroy_it_should_return_bank_deleted(){
        Bank bank = new Bank();
        bank.setId(1);
        bank.setCode("0001");
        bank.setName("Nubank");
        String result = bankService.destroy(1);
        assertThat(result).isSameAs("Bank deleted");
    }


}