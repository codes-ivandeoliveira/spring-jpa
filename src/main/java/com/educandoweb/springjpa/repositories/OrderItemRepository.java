package com.educandoweb.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springjpa.entities.OrdemItem;


public interface OrderItemRepository extends JpaRepository<OrdemItem, Integer> {

}
