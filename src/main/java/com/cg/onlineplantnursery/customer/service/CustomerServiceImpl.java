package com.cg.onlineplantnursery.customer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.repository.CustomerRepository;
import com.cg.onlineplantnursery.exception.*;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	private Logger logger =LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Customer saveCustomer(Customer customer) {
		
		logger.info("*********************Add Customer***************");
		Customer cust=repository.save(customer);
		return cust;
		
	}

	@Override
	public List<Customer> saveCustomers(List<Customer> customers) {
	
		logger.info("*********************Add a  list of  Customers***************");
		return repository.saveAll(customers);
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		logger.info("*********************Updating Customer**********************");
		
		Customer existingCustomer = repository.findById(customer.getCustomerId()).orElse(null);
		existingCustomer.setCustomerName(customer.getCustomerName());
		existingCustomer.setCustomerEmail(customer.getCustomerEmail());
		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setAddress(customer.getAddress());
		return repository.save(existingCustomer);
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		
		logger.info("*********************Get customer By Id*********************");
		Customer customer = null;
		Optional<Customer>op = repository.findById(customerId);
		if(op.isPresent())
		{
			customer= op.get();
		}
			
		else
		{
			throw new CustomerNotFoundException("Customer not Found with given Id");
		}
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		
		logger.info("*********************Delete Customer By Id********************");
		Optional<Customer>op = repository.findById(customerId);
		Customer customer=null;
		if(op.isPresent())
		{
			repository.deleteById(customerId);
		}
			
		else
		{
			throw new CustomerNotFoundException("Customer not Found with given Id");
		}
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		
		logger.info("*********************Finding a list of Customers**********************");
		return repository.findAll();
	}

	@Override
	public Customer loginByCustomer(String username, String password) throws CustomerNotFoundException {
		
		logger.info("*********************Login to the  Customer**********************");
		
		Customer customer = null;
		
		Optional<Customer>op = repository.findByUsernameAndPassword(username,password);
		if(op.isPresent())
		{
			customer= op.get();
		}
			
		else
		{
			throw new CustomerNotFoundException("Customer not Found with given Id");
		}
		return customer;
	
		

	}
	

}
