package com.nabinsingh.contactentry.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nabinsingh.contactentry.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("SELECT u FROM Person u where u.email = :email") 
	public Person findByEmailAddress(@Param("email") String email);
}
