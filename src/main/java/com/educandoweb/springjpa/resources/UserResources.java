package com.educandoweb.springjpa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.springjpa.entities.User;
import com.educandoweb.springjpa.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List <User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	 
	 
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id){
		User obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
