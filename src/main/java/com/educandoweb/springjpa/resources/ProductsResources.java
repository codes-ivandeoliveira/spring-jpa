package com.educandoweb.springjpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.springjpa.entities.Products;
import com.educandoweb.springjpa.services.ProductsService;

@RestController
@RequestMapping(value = "/products")
public class ProductsResources {
	
	@Autowired
	private ProductsService service;
	
	@GetMapping
	public ResponseEntity<List<Products>> findAll(){
		
		List <Products> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	 
	 
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Products> findById(@PathVariable Integer id){
		Products obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
