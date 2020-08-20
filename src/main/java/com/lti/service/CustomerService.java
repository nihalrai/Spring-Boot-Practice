package com.lti.service;

import com.lti.entity.Customer;

public interface CustomerService {

	void register(Customer customer) throws Exception;

	Customer login(String email, String password);

}