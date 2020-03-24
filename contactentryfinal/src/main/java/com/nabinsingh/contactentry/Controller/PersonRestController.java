package com.nabinsingh.contactentry.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nabinsingh.contactentry.entity.Person;
import com.nabinsingh.contactentry.service.PersonService;

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping("/")
public class PersonRestController {
 
	private PersonService personService;
	
	@Autowired 
	public PersonRestController(PersonService thePersonService){
		 this.personService= thePersonService;
	}
	
	
	@GetMapping("/contacts")
	public List<Person> getAllContacts(){
		
		return personService.findAll();
		
	}
	
	//get method for single contact
	
	@GetMapping("/contacts/{personId}")
	public Person getContact(@PathVariable int personId) {
		
		Person thePerson= personService.findById(personId);
		if(thePerson == null) {
			throw new RuntimeException ("Person with id - "+personId+" not found in the contact list");
		}
		 return thePerson;
		
	}
	
	
	@PostMapping("/contacts")
	public Person addContact(@RequestBody Person thePerson) {
		
	Person person=personService.findByEmailAddress(thePerson.getEmail());
	
		if(person==null) {
			thePerson.setId(0); 
			personService.save(thePerson);
		} else {
			
			throw new RuntimeException ("Person with email:  "+thePerson.getEmail()+" is already in the contact list. Pleaase check ag");
		}
		
		
		
		return thePerson;
		
	}
	

	@PutMapping("/contacts/{personId}")
	public Person updateContactList(@RequestBody Person thePerson) {
		
		
		personService.save(thePerson);
		return thePerson;
	}
	
	@DeleteMapping("/contacts/{personId}")
	public String deleteContact(@PathVariable int personId) {

		Person tempPerson = personService.findById(personId);
		if(tempPerson==null) {
			throw new RuntimeException ("Person with id:  "+tempPerson.getId()+" is not in the contact list. Pleaase check again");
		}
		personService.deleteById(personId);
		return "Deleted the person with id: "+personId;
		 
		
		
	}
	
	
	
	
	
	
}
