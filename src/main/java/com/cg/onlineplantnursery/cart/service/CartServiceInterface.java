package com.cg.onlineplantnursery.cart.service;

import java.util.List;

import com.cg.onlineplantnursery.cart.entity.CartEntity;
import com.cg.onlineplantnursery.exception.SeedNotFoundException;
import com.cg.onlineplantnursery.plant.exception.PlantNotFoundException;
import com.cg.onlineplantnursery.planter.exception.PlanterNotFoundException;


public interface CartServiceInterface {
	
	public List<CartEntity> viewCartByCustomerId(int customerId);
	
	public String addToCart(int seedId,int plantId,int planterId,int customerId,int seedQuantity,
			 int planterQuantity, int plantQuantity,String status) throws SeedNotFoundException,PlantNotFoundException,PlanterNotFoundException;
	
	public boolean removeCartItem(int cartId);
	
	public boolean clearCartByCustomerId(int customerId);
	
	public String updateCart( int seedQuantity, int planterQuantity, int plantQuantity, int cartId)
			throws InvalidQuantityException;
	

}
