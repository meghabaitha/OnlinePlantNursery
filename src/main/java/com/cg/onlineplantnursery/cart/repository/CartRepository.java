package com.cg.onlineplantnursery.cart.repository;


import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.cart.entity.CartEntity;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.seed.entity.Seed;
@Repository
public interface CartRepository {

	
	public List<CartEntity> viewCartByCustomerId(int customerId);

	public boolean removeCartItem(CartEntity cart);

	public CartEntity viewCartByCartId(int cartId);

	public boolean updateCartQuantity(CartEntity cart);

	//public List<OrderInformation> viewOrderByCustomerId(int customerId);

	public String addProductToCart(CartEntity cart);

	public Seed getSeed(int seedId);

	public Plant getPlant(int plantId);

	public Planter getPlanter(int planterId);
	
	//public List<BookInformation> viewBooks();
	
	//public BookInformation getBook(int bookId);
	

}
