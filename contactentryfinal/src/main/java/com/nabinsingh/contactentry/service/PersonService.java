package com.nabinsingh.contactentry.service;

import java.util.List;

import com.nabinsingh.contactentry.entity.Person;

public interface PersonService {
	public List<Person> findAll();
	
    public Person findById(int personId);
    public Person findByEmailAddress(String personEmail);
	public void save(Person thePerson);
	
	public void deleteById(int personId);
	
	
	


}
