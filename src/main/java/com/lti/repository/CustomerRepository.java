package com.lti.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.lti.entity.Customer;

public interface CustomerRepository {

	void save(Customer customer);

	Customer findById(int id);

	List<Customer> findAll();

	int findByUsernamePassword(String email, String password);

}