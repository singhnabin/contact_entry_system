package com.nabinsingh.contactentry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabinsingh.contactentry.entity.Name;

public interface PersonNameRepository extends JpaRepository<Name, Integer> {

}
