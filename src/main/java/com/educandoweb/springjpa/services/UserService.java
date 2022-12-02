package com.educandoweb.springjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.springjpa.entities.User;
import com.educandoweb.springjpa.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List <User> findAll(){
		
		return repository.findAll();
	}
	
	public User findbyId(Integer id) {
		Optional <User> obj = repository.findById(id);
		return obj.get();
	}
}
