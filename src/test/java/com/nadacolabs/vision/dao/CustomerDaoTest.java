package com.nadacolabs.vision.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.nadacolabs.vision.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoTest {
	private final CustomerDaoImpl dao = new CustomerDaoImpl();
	
	@Mock
	private SessionFactory sessionFactory;
	
	@Before
    public void initDao() {
        dao.setSessionFactory(sessionFactory);
    }

	@Test
	public void createUser() {
		Session session = stubSession();
		Customer customer = new Customer();
		dao.save(customer);
		verify(session).saveOrUpdate(customer);
	}
	
	@Test
	public void queryByBirthday(){
		Session session = stubSession();
		
	}
	
	private Session stubSession() {
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        return session;
    }

}
