package com.educandoweb.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springjpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
