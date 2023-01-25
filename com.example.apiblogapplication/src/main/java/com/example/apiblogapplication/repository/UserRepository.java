package com.example.apiblogapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiblogapplication.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
