package com.cg.onlineplantnursery.customer.service;

import java.util.List;

import com.cg.onlineplantnursery.customer.entity.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);
	public List<Customer> saveCustomers(List<Customer> customers);
	public Customer updateCustomer(Customer customer);
	public Customer getCustomerById(int customerId);
	public void deleteCustomer(int customerId);
	public List<Customer> getAllCustomer();
	public Customer loginByCustomer(String username,String password);
	

}
