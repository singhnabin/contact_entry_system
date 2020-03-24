package com.nabinsingh.contactentry.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="contact_info")
public class Person {
	
	//define the fields 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	
	@Column(name="email",unique=true)
	private String email;
	
	@JsonManagedReference
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="person",orphanRemoval = true)
	private Name name;

	@JsonManagedReference
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="person",orphanRemoval = true)
	private Address address;
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="person",orphanRemoval = true)
	private List<Phone> phone;





	public Person() {
		
	}



	public Person(String email) {

		this.email = email;

	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	
	public Name getName() {
		return name;
	}



	public void setName(Name name) {
		this.name = name;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Phone> getPhone() {
		return phone;
	}



	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	
	
	

}
