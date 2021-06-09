package com.leoncio.bancos.repositories;

import com.leoncio.bancos.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
