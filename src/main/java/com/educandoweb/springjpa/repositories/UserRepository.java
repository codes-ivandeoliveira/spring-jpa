package com.educandoweb.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springjpa.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
