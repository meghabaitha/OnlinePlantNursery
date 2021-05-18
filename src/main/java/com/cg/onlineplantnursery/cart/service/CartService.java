package com.cg.onlineplantnursery.cart.service;

import java.util.List;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.admin.Service.AdminServiceImpl;
import com.cg.onlineplantnursery.cart.entity.CartEntity;
import com.cg.onlineplantnursery.cart.repository.CartRepository;
import com.cg.onlineplantnursery.exception.SeedNotFoundException;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.exception.PlantNotFoundException;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.exception.PlanterNotFoundException;
import com.cg.onlineplantnursery.seed.entity.Seed;

@Service
@Transactional
public class CartService implements CartServiceInterface {

	@Autowired
	private CartRepository repo;
	private Logger logger =LoggerFactory.getLogger(CartService.class);
	
	@Override
	public List<CartEntity> viewCartByCustomerId(int customerId) {
		
		logger.info("*******************Cart Info for a particular Customer************************");
		List<CartEntity> reviewList=repo.viewCartByCustomerId(customerId);
		return reviewList;
	}
	
	@Override
	public String addToCart(int seedId,int plantId,int planterId,int customerId,int seedQuantity ,
			 int planterQuantity, int plantQuantity,String status)
	{
		logger.info("*******************Add product to the cart************************");
		Seed seed = repo.getSeed(seedId);
		Plant plant = repo.getPlant(plantId);
		Planter planter = repo.getPlanter(planterId);
		
		if(seed == null)
		{
			throw new SeedNotFoundException("Seed with "+seedId+" not found");
		}
		else if(plant ==null)
		{
			throw new PlantNotFoundException("Plant with "+plantId+" not found");
		}
		else if(planter == null)
		{
			throw new PlanterNotFoundException("Planter with "+planterId+" not found");
		}
		else
		{
			CartEntity ex = new CartEntity(); 
			
			ex.setCustomerId(customerId);
			ex.setSeed(seed);
			ex.setPlanter(planter);
			ex.setPlant(plant);
			ex.setStatus(status);
			ex.setSeedQuantity(seedQuantity);
			ex.setPlanterQuantity(planterQuantity);
			ex.setPlantQuantity(plantQuantity);
			ex.setSubtotal(550.5);
			return repo.addProductToCart(ex);
		}
		
	}
	
	@Override
	public boolean removeCartItem(int cartId) {
		
		logger.info("*******************Remove Item From The Cart************************");
		CartEntity cart=repo.viewCartByCartId(cartId);
		return repo.removeCartItem(cart);
	}
	
	@Override
	public boolean clearCartByCustomerId(int customerId)
	{
		
		logger.info("*******************Clear Cart Information of a particular customer************************");
		List<CartEntity> carts=repo.viewCartByCustomerId(customerId);
		int i=0;
		while(i<carts.size()) {
			repo.removeCartItem(carts.get(i));
			i++;
		}
		return true;
	}
	
	@Override
	public String updateCart( int seedQuantity, int planterQuantity, int plantQuantity, int cartId)
	throws InvalidQuantityException
	{
		logger.info("*******************Update Cart Information************************");
		CartEntity cart = repo.viewCartByCartId(cartId);
		if(seedQuantity<0 && planterQuantity<0 && plantQuantity<0)
		{
			throw new InvalidQuantityException();
		}
		else
		{
			double updatedSubtotal = (seedQuantity * cart.getSeed().getSeedsCost())+(plantQuantity * cart.getPlant().getPlantCost())
					+(planterQuantity * cart.getPlanter().getPlanterCost()); 
			
			cart.setSeedQuantity(seedQuantity);
			cart.setPlantQuantity(plantQuantity);
			cart.setPlanterQuantity(planterQuantity);
			cart.setSubtotal(updatedSubtotal);
			repo.updateCartQuantity(cart);
		}
		return "Updated"; 
	}
}
