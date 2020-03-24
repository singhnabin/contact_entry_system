package com.nabinsingh.contactentry.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="phone_info")
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="type")
	private String type;

	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL,optional=false) 
	@JoinColumn(name="contact_id",nullable=false,unique=true)
	private Person person;
	
	public Phone() {
		
	}

	public Phone(String number, String type) {
	
		this.number = number;
		this.type = type;
	}
 void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
