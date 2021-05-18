package com.cg.onlineplantnursery.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.cart.service.CartServiceInterface;
import com.cg.onlineplantnursery.cart.service.InvalidQuantityException;
@RestController
public class UpdateCartController {
	
	@Autowired
	private CartServiceInterface service;
	
	
	/*Can update quantity of products add to the cart*/
	
	@PutMapping("/update/{cartId}/{seedQuantity}/{planterQuantity}/{plantQuantity}")
	public boolean updateCart(@PathVariable("cartId") int cartId, @PathVariable("seedQuantity") int seedQuantity,@PathVariable("planterQuantity") int planterQuantity,@PathVariable("plantQuantity") int plantQuantity) throws InvalidQuantityException {
		service.updateCart(seedQuantity,planterQuantity,plantQuantity,cartId);
		return true;	
	}

}
