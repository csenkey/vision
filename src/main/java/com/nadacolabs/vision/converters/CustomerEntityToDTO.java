package com.nadacolabs.vision.converters;

import org.springframework.core.convert.converter.Converter;

import com.nadacolabs.vision.controller.request.CustomerDTO;
import com.nadacolabs.vision.domain.Customer;

public class CustomerEntityToDTO implements Converter<Customer, CustomerDTO> {

	@Override
	public CustomerDTO convert(Customer entity) {
		CustomerDTO dto = new CustomerDTO();
		dto.setAddress(entity.getAddress().getAddress());
		dto.setBirthday(entity.getBirthday().getTime());
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setTelephone(entity.getTelephone());
		dto.setTown(entity.getAddress().getTown());
		dto.setZip(entity.getAddress().getZip());
		
		return dto;
	}

}
