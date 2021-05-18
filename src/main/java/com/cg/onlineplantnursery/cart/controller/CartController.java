package com.cg.onlineplantnursery.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.cart.entity.CartEntity;
import com.cg.onlineplantnursery.cart.service.CartServiceInterface;
import com.cg.onlineplantnursery.exception.SeedNotFoundException;
import com.cg.onlineplantnursery.plant.exception.PlantNotFoundException;
import com.cg.onlineplantnursery.planter.exception.PlanterNotFoundException;


@RestController

public class CartController {
	
	@Autowired
	public  CartServiceInterface service;
	
	/*In order to retrieve cart information of a particular customer using customer id */
	@GetMapping("/viewcartbycustomerid/{customerid}")
	public List<CartEntity> viewCartByCustomerId(@PathVariable("customerid") int customerId) {
		
		return service.viewCartByCustomerId(customerId);
	}
	
	
	/*To add items to the cart using items id , customer id and customer can add quantity*/
	
	@PostMapping("/addbooktocart/{seedId}/{plantId}/{planterId}/{customerId}/{seedQuantity}/{planterQuantity}/{plantQuantity}/{status}")
	public String addToCart(@PathVariable("seedId") int seedId,@PathVariable("plantId") int plantId,@PathVariable("planterId") int planterId,@PathVariable("customerId")int customerId,
		@PathVariable("seedQuantity") int seedQuantity,@PathVariable("planterQuantity") int planterQuantity,@PathVariable("plantQuantity") int plantQuantity,@PathVariable("status")String status) throws SeedNotFoundException,PlantNotFoundException,PlanterNotFoundException {
		
		return service.addToCart(seedId,plantId,planterId,customerId,seedQuantity, 
				  planterQuantity,plantQuantity,status);
	}
	/*Remove cart item which has particular cart id */
	
	@DeleteMapping("/removecartitem/{cartid}")
	public boolean removeCartItem(@PathVariable("cartid") int cartId, HttpServletRequest request) {
		return service.removeCartItem(cartId);
	}
	
	/*Clear cart information using customer id */
	
	@DeleteMapping("/clearcartbycustomerid/{customerId}")
	public boolean clearCartByCustomerId(@PathVariable("customerId") int customerId, HttpServletRequest request) {
		return service.clearCartByCustomerId(customerId);
	}
	
	
	

}
