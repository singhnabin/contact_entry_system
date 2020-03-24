package com.nabinsingh.contactentry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabinsingh.contactentry.dao.PersonRepository;
import com.nabinsingh.contactentry.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {
	private PersonRepository personRepository;
	
	@Autowired
	public PersonServiceImpl(PersonRepository thePersonRepositoryO) {
		this.personRepository= thePersonRepositoryO;
	}

	@Override
	public List<Person> findAll() {
		
		return personRepository.findAll();
	}

	@Override
	public Person findById(int personId) {
		
		Optional<Person> result = personRepository.findById(personId);
		Person thePerson=null;
		if(result.isPresent()) {
			thePerson=result.get();
		} else {
			throw new RuntimeException ("Person with id - "+personId+" not found in the contact list");
		}
		return thePerson;
	}

	@Override
	public void save(Person thePerson) {
		
		personRepository.save(thePerson);
	}

	@Override
	public void deleteById(int personId) {
		personRepository.deleteById(personId);
		
	}

	@Override
	public Person findByEmailAddress(String personEmail) {
		Person result = personRepository.findByEmailAddress(personEmail);
		return result;
	
	}

}
