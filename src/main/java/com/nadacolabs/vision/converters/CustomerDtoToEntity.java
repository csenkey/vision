package com.nadacolabs.vision.converters;

import java.sql.Date;


import org.springframework.core.convert.converter.Converter;

import com.nadacolabs.vision.controller.request.CustomerDTO;
import com.nadacolabs.vision.domain.Address.AddressBuilder;
import com.nadacolabs.vision.domain.Customer;
import com.nadacolabs.vision.domain.Customer.CustomerBuilder;

public class CustomerDtoToEntity implements Converter<CustomerDTO, Customer> {

	public Customer convert(CustomerDTO dto) {
		return (new CustomerBuilder().setBirthday(new Date(dto.getBirthday()))
				.setEmail(dto.getEmail()).setFirstName(dto.getFirstName())
				.setLastName(dto.getLastName())
				.setTelephone(dto.getTelephone())
				.setAddress((new AddressBuilder().setAddress(dto.getAddress())
						.setTown(dto.getTown()).setZip(dto.getZip())).build()))
				.build();
	}

}
