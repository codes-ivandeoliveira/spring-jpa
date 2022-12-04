package com.educandoweb.springjpa.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.loader.plan.exec.process.internal.AbstractRowReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.springjpa.entities.User;
import com.educandoweb.springjpa.repositories.UserRepository;
import com.educandoweb.springjpa.services.exceptions.DatabaseException;
import com.educandoweb.springjpa.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {

		return repository.findAll();
	}

	public User findbyId(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return repository.save(obj);

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(Integer id, User obj) {
		try {
		User ententy = repository.getReferenceById(id);
		updateData(ententy, obj);
		return repository.save(ententy);
		}
		catch(EntityNotFoundException e) {
			
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User ententy, User obj) {
		ententy.setName(obj.getName());
		ententy.setEmail(obj.getEmail());
		ententy.setPhone(obj.getPhone());

	}
}
