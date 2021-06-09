package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.dto.CustomerDTO;
import com.leoncio.bancos.errorhandling.exceptions.DuplicateFoundException;
import com.leoncio.bancos.models.Account;
import com.leoncio.bancos.models.Branch;
import com.leoncio.bancos.models.Customer;
import com.leoncio.bancos.repositories.AccountRepository;
import com.leoncio.bancos.repositories.BranchRepository;
import com.leoncio.bancos.repositories.CustomerRepository;
import com.leoncio.bancos.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final BranchRepository branchRepository;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountServiceImpl(BranchRepository branchRepository, AccountRepository accountRepository, CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.branchRepository = branchRepository;
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        try {
            Account account = new Account();
            account.setCode(accountDTO.getCode());
            Branch branch = branchRepository.getByCode(accountDTO.getBranchCode());
            account.setBranch(branch);
            Customer customer = customerRepository.getByCode(accountDTO.getCustomerCode());
            account.setCustomer(customer);
            account.setOpeningDate(LocalDateTime.now());
            this.accountRepository.save(account);
            accountDTO.setId(account.getId());
            return accountDTO;
        } catch (ConstraintViolationException| DataIntegrityViolationException ex) {
            throw new DuplicateFoundException("Is not possible to create two accounts for the same customer at the same branch");
        }

    }

    @Override
    public AccountDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<AccountDTO> findAll() {
        return this.accountRepository.findAll().stream().map(AccountDTO::new).collect(Collectors.toList());
    }

    @Override
    public void destroy() {

    }
}
