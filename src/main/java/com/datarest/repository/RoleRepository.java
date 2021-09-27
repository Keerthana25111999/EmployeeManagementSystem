package com.datarest.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.datarest.entities.Role;
import com.datarest.entities.Roles;


public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(Roles role);
}

