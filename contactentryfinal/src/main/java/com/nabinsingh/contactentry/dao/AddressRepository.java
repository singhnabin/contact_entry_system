package com.nabinsingh.contactentry.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabinsingh.contactentry.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
