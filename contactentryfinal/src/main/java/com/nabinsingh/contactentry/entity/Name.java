package com.nabinsingh.contactentry.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="name_info")
public class Name{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String first;
	
	@Column(name="middle_name")
	private String middle;
	
	@Column(name="last_name")
	private String last;
	
	@JsonBackReference
	@OneToOne(cascade=CascadeType.ALL,optional=false) 
	@JoinColumn(name="contact_id", nullable=false,unique=true)
	private Person person;
	
	
	public Name() {
		
		
	}
	public Name(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;

	}



	public void setId(int id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
