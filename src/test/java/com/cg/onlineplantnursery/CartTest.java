package com.cg.onlineplantnursery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.onlineplantnursery.cart.entity.CartEntity;
import com.cg.onlineplantnursery.cart.repository.CartRepository;
import com.cg.onlineplantnursery.cart.repository.CartRepositoryImpl;
import com.cg.onlineplantnursery.cart.service.CartService;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.seed.entity.Seed;

@RunWith(MockitoJUnitRunner.class)
public class CartTest {

	@InjectMocks
	CartService service;
	
	@Mock
	CartRepositoryImpl repo;
	
	
	@Before(value = "")
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	/*This testcase use to test whether the value and size of the list is as same as expected
	 * here cart information of a particular customer is shown
	 * we take two dummy value of same customer id 
	 * now there are two cart with same customer ids
	 * so , the size of the list returned is 2 and expected value is 2
	 * it returns true result*/
	@Test
	public void viewCustomerCartByIdTest()
	{
		List<CartEntity> cart = new ArrayList<CartEntity>();
		int cid1 = 101;
		int cid2 = 101;
		Seed seed = new Seed();
		seed.setSeedId(11);
		Plant plant = new Plant();
		plant.setPlantId(12);
		Planter planter = new Planter();
		planter.setPlanterId(14);
		CartEntity cart1 = new CartEntity(1,cid1,2,1,2,"cart",1234.5,seed,plant,planter);
		CartEntity cart2 = new CartEntity(2,cid2,6,1,3,"cart",3455.6,seed,plant,planter);
		cart.add(cart1);
		cart.add(cart2);
		when(repo.viewCartByCustomerId(cid1)).thenReturn(cart);
		//test
		List<CartEntity> cartList = service.viewCartByCustomerId(cid1);
		assertEquals(2, cartList.size());
		verify(repo,times(1)).viewCartByCustomerId(cid1);
	
	}
}
