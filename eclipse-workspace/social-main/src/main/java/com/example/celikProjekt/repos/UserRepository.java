package com.example.celikProjekt.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.celikProjekt.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
