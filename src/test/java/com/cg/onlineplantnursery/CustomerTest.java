package com.cg.onlineplantnursery;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.onlineplantnursery.customer.entity.Address;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.repository.CustomerRepository;
import com.cg.onlineplantnursery.customer.service.CustomerServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {
	
	@InjectMocks
	CustomerServiceImpl service;
	
	@Mock
	CustomerRepository repo;
	
	@Before(value = "")
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	/*It is testing whether the values returned by the method is as same as expected
	 * here main objective is to get all customer information and comparing the size of the list*/
	@Test
	public void getAllCustomerTest()
   {
	  List<Customer> cust = new ArrayList<Customer>();
	  Address ad = new Address();
	  ad.setAddressId(11);
	  Customer cust1 = new Customer(1,"Priyanka","pri@gmail.com","h21","1234",ad);
	  Customer cust2 = new Customer(2,"Laboni","Lab@gmail.com","h21","1111",ad);
	  cust.add(cust1);
	  cust.add(cust2);
	  
	  when(repo.findAll()).thenReturn(cust);
	  
	  //test
	  List<Customer> cusList = service.getAllCustomer();
	  
	  assertEquals(2, cusList.size());
	  verify(repo,times(1)).findAll();
	  
	   }
	
	/*By taking this test it proves that values return by this methods is as same same expected
	 * returned result is true and testcase passed*/
	@Test
	public void getCustomerByIdTest()
	{
		
		Address ad = new Address();
		  ad.setAddressId(11);
		  java.util.Optional<Customer> cust= Optional.ofNullable(new Customer(1,"Priyanka","pri@gmail.com","h21","1234",ad));
		 when(repo.findById(1)).thenReturn(cust);
		Customer ex = service.getCustomerById(1);
		assertEquals("Priyanka", ex.getCustomerName());
		assertEquals("pri@gmail.com", ex.getCustomerEmail());
		
		
	}
	
	/*This method is used to test whether the customer with the same id is created or not*/
	@Test
	public void createCustomerTest()
	{
		Address ad = new Address();
		  ad.setAddressId(11);
		  Customer cust =new Customer(1,"Priyanka","pri@gmail.com","h21","1234",ad);
		  service.saveCustomer(cust);
		  verify(repo,times(1)).save(cust);
		  
		
	}

	

}
