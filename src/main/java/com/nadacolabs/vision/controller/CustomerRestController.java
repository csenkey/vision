package com.nadacolabs.vision.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nadacolabs.vision.controller.request.CustomerDTO;
import com.nadacolabs.vision.controller.response.CustomerNameAndId;
import com.nadacolabs.vision.converters.CustomerDtoToEntity;
import com.nadacolabs.vision.converters.CustomerEntityToDTO;
import com.nadacolabs.vision.converters.CustomerToNameAndId;
import com.nadacolabs.vision.domain.Customer;
import com.nadacolabs.vision.service.CustomerService;


@RestController
@RequestMapping("customer")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public Long createCustomer(@RequestBody CustomerDTO request){
		CustomerDtoToEntity converter = new CustomerDtoToEntity();
		return customerService.saveCustomer(converter.convert(request));	
	}
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public List<CustomerNameAndId> getCustomersByBirthday(@RequestParam(value = "birthday", required = true) long date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		List<Customer> customers = customerService.getCustomersByBirthDay(calendar, true);
		List<CustomerNameAndId> retVals = new ArrayList<CustomerNameAndId>();
		CustomerToNameAndId converter = new CustomerToNameAndId();
		for (Customer customer : customers){
			retVals.add(converter.convert(customer));
		}
		return retVals;
	}
	
	@RequestMapping(value = "get/byid", method = RequestMethod.GET)
	public CustomerDTO getCustomerById(@RequestParam(value = "id", required = true) long id){
		CustomerEntityToDTO converter = new CustomerEntityToDTO();
		return converter.convert(customerService.getCustomerById(id));
	}
	

}

	
