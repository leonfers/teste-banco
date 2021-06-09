package com.leoncio.bancos.repositories;

import com.leoncio.bancos.models.Deposit;
import com.leoncio.bancos.models.Transaction;
import com.leoncio.bancos.models.Transfer;
import com.leoncio.bancos.models.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT w FROM Withdrawal w WHERE w.origin.id = :id and w.date between :startDate and :endDate ")
    List<Withdrawal> findAllWithdrawalsByAccountIdAndDateInterval(int id, @Param("startDate") LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);

    @Query("SELECT d FROM Deposit d WHERE d.destiny.id = :id and d.date between :startDate and :endDate")
    List<Deposit> findAllDepositsByAccountIdAndDateInterval(int id, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT t FROM Transfer t WHERE (t.origin.id = :id or t.destiny.id = :id) and t.date between :startDate and :endDate")
    List<Transfer> findAllTransfersByAccountIdAndDateInterval(int id, @Param("startDate") LocalDateTime startDate,@Param("endDate") LocalDateTime endDate);
}
