package com.educandoweb.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springjpa.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
