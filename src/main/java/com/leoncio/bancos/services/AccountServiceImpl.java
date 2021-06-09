package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.*;
import com.leoncio.bancos.errorhandling.exceptions.DuplicateFoundException;
import com.leoncio.bancos.models.*;
import com.leoncio.bancos.repositories.AccountRepository;
import com.leoncio.bancos.repositories.BranchRepository;
import com.leoncio.bancos.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final BranchRepository branchRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountServiceImpl(BranchRepository branchRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.branchRepository = branchRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        try {
            Account account;
            if (accountDTO.getId() == null) {
                account = new Account();
                account.setUser((User) SecurityContextHolder.getContext()
                        .getAuthentication()
                        .getPrincipal());
                account.setOpeningDate(LocalDateTime.now());
            } else {
                account = this.accountRepository.getById(accountDTO.getId());
            }
            Branch branch = branchRepository.getByCode(accountDTO.getBranchCode());
            account.setBranch(branch);
            this.accountRepository.save(account);
            accountDTO.setId(account.getId());
            return accountDTO;
        } catch (ConstraintViolationException | DataIntegrityViolationException ex) {
            throw new DuplicateFoundException("Is not possible to create two accounts for the same user at the same branch");
        }

    }

    @Override
    public AccountDTO findById(Integer id) {
        return new AccountDTO(this.accountRepository.getById(id));
    }

    @Override
    public List<AccountDTO> findAll() {
        return this.accountRepository.findAll().stream().map(AccountDTO::new).collect(Collectors.toList());
    }


    @Override
    public BankStatementDTO getBankStatementByAccountId(int id, LocalDate startDate, LocalDate endDate) {
        Account account = accountRepository.getById(id);

        BankStatementDTO bankStatementDTO = new BankStatementDTO();
        bankStatementDTO.setStartDate(startDate);
        bankStatementDTO.setEndDate(endDate);
        bankStatementDTO.setAccountId(account.getId());
        bankStatementDTO.setCurrentBalance(account.getBalance());
        bankStatementDTO.setDate(LocalDateTime.now());
        bankStatementDTO.setBankCode(account.getBranch().getBank().getCode());
        bankStatementDTO.setBankName(account.getBranch().getBank().getName());
        bankStatementDTO.setBranchCode(account.getBranch().getCode());

        List<Withdrawal> withdrawals = transactionRepository.findAllWithdrawalsByAccountIdAndDateInterval(id, startDate.atStartOfDay(), endDate.atTime(23, 59, 59));
        List<Deposit> deposits = transactionRepository.findAllDepositsByAccountIdAndDateInterval(id, startDate.atStartOfDay(), endDate.atTime(23, 59, 59));
        List<Transfer> transfers = transactionRepository.findAllTransfersByAccountIdAndDateInterval(id, startDate.atStartOfDay(), endDate.atTime(23, 59, 59));

        bankStatementDTO.setWithdrawals(withdrawals.stream().map(WithdrawalDTO::new).collect(Collectors.toList()));
        bankStatementDTO.setDeposits(deposits.stream().map(DepositDTO::new).collect(Collectors.toList()));
        bankStatementDTO.setTransfers(transfers.stream().map(TransferDTO::new).collect(Collectors.toList()));

        return bankStatementDTO;
    }

    @Override
    public String destroy(int id) {
        accountRepository.deleteById(id);
        return "Account deleted";
    }
}
