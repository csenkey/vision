package com.nadacolabs.vision.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadacolabs.vision.dao.CustomerDao;
import com.nadacolabs.vision.domain.Customer;

@Service
@Transactional(readOnly= true)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	public List<Customer> getCustomersByBirthDay(Calendar date,
			boolean exactDate) {
		return customerDao.getCustomersByBirthDay(date, exactDate);
	}

	public List<Customer> getCustomersByFirstName(String firstName) {
		return customerDao.getCustomersByFirstName(firstName);
	}

	public List<Customer> getCustomersById(List<Long> ids) {
		return customerDao.getCustomersById(ids);
	}

	public Customer getCustomerById(Long id) {
		return customerDao.getCustomerById(id);
	}

	@Transactional(readOnly = false)
	public Long saveCustomer(Customer customer) {
		customerDao.save(customer);
		return customer.getId();
	}

}
