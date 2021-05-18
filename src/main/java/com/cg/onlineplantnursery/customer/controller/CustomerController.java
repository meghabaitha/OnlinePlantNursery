package com.cg.onlineplantnursery.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


//import com.capg.springboot.entity.Product;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	
	/*Add customer 
	 * This process is similar to the registration of customer */
	@PostMapping(path = "/addCustomer" )
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		Customer cust = customerservice.saveCustomer(customer);
		if(cust==null){
			return new ResponseEntity("Customer Not Found!!",HttpStatus.NOT_FOUND);
			}
			
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		
	}
	
	
	/*Add more than one customer by admin*/
	
	@PostMapping( path = "/addallcustomers" )
	public  List<Customer>  createAllCustomer(@RequestBody List<Customer> customers)
	{
		return (customerservice.saveCustomers(customers));
		
	}
	
	/* To retrieve customer details of a particular customer using customer id */
	@GetMapping(path = "/getcustomer/{customerId}" )
	public Customer findCustomer(@PathVariable int customerId)
	{
		return (customerservice.getCustomerById(customerId));
		
	}
	
	
	
	/*To retrieve customer informations currently present or registered*/
	@GetMapping(path = "/getallcustomers")
	public List<Customer> getAllCustomers( )
	{
		return customerservice.getAllCustomer();
		
	}
	
	
	/*To update information of a particular customer by using customer id */
	@PutMapping( path = "/updatecustomer/{customerId}")
	public  Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer)
	{
		customer.setCustomerId(customerId);
		return (customerservice.updateCustomer(customer)); 
		
	}
	
	/*To delete a particular customer information by using customer id*/
	@DeleteMapping(path = "/customer/{customerId}" )
	public String deleteCustomer(@PathVariable int customerId)
	{
		customerservice.deleteCustomer(customerId);
		return ("Customer with customerId ; "+customerId +"deleted successfully");
		
	}
	
	@GetMapping(path="/login/{username}/{password}")
	public Customer loginByCustomer(@PathVariable String username, @PathVariable String password)
	{
		
		return (customerservice.loginByCustomer(username, password));
	}
	
	

}
