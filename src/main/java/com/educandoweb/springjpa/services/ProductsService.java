package com.educandoweb.springjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.springjpa.entities.Products;
import com.educandoweb.springjpa.repositories.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository repository;
	
	public List <Products> findAll(){
		
		return repository.findAll();
	}
	
	public Products findbyId(Integer id) {
		Optional <Products> obj = repository.findById(id);
		return obj.get();
	}
}
