package com.nadacolabs.vision.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nadacolabs.vision.domain.Customer;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Customer customer) {
		getSession().saveOrUpdate(customer);
	}

	public List<Customer> getCustomersByBirthDay(Calendar date,
			boolean exactDate) {
		Query q = getSession().createQuery("from Customer where birthday = :date");
		q.setCalendarDate("date", date);
		return q.list();
	}

	public List<Customer> getCustomersByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> getCustomersById(List<Long> ids) {
		
		return null;
	}

	public Customer getCustomerById(Long id) {
		return (Customer) getSession().get(Customer.class, id);
	}
}
