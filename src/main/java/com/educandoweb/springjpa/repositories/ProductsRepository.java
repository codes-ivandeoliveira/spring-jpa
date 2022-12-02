package com.educandoweb.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springjpa.entities.Category;
import com.educandoweb.springjpa.entities.Products;


public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
