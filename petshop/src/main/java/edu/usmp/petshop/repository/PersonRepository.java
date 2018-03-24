package edu.usmp.petshop.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import edu.usmp.petshop.model.Person;

public interface PersonRepository extends Repository<Person, Integer> {

	void save(Person person);
	
	List<Person> findAll();
	
}
