package com.nadacolabs.vision.converters;

import org.springframework.core.convert.converter.Converter;

import com.nadacolabs.vision.controller.response.CustomerNameAndId;
import com.nadacolabs.vision.domain.Customer;

public class CustomerToNameAndId implements Converter<Customer, CustomerNameAndId> {

	@Override
	public CustomerNameAndId convert(Customer customer) {
		CustomerNameAndId nameAndId = new CustomerNameAndId();
		nameAndId.setId(customer.getId());
		nameAndId.setName(customer.getLastName() + " " + customer.getFirstName());
		return nameAndId;
	}
	

}
