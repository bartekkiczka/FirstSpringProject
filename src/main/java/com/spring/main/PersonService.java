package com.spring.main;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository repo;
	
	public List<Person> listAll(){
		return repo.findAll();
	}
	
	public void save(Person person) {
		repo.save(person);
	}
	
	public Person get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
