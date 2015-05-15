package com.nadacolabs.vision.service;

import java.util.Calendar;
import java.util.List;

import com.nadacolabs.vision.domain.Customer;

public interface CustomerService {
	List<Customer> getCustomersByBirthDay(Calendar date, boolean exactDate);
	List<Customer> getCustomersByFirstName(String firstName);
	List<Customer> getCustomersById(List<Long> ids);
	Customer getCustomerById(Long id);
	Long saveCustomer(Customer customer);
}
