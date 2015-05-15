package com.nadacolabs.vision.dao;

import java.util.Calendar;
import java.util.List;

import com.nadacolabs.vision.domain.Customer;

public interface CustomerDao extends BaseDao<Customer> {
	List<Customer> getCustomersByBirthDay(Calendar date, boolean exactDate);
	List<Customer> getCustomersByFirstName(String firstName);
	List<Customer> getCustomersById(List<Long> ids);
	Customer getCustomerById(Long id);
}
