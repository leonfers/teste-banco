package com.leoncio.bancos.repositories;

import com.leoncio.bancos.models.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
    Branch getByCode(String customerCode);
}
