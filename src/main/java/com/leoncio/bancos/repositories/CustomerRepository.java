package com.leoncio.bancos.repositories;

import com.leoncio.bancos.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer getByCode(String customerCode);
}
