package com.example.apiblogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiblogapplication.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
