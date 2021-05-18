package com.cg.onlineplantnursery.cart.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.cg.onlineplantnursery.cart.entity.CartEntity;
import com.cg.onlineplantnursery.exception.SeedNotFoundException;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.seed.entity.Seed;



@Repository
public class CartRepositoryImpl implements CartRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<CartEntity> viewCartByCustomerId(int customerId) {
		String jpql = "from CartEntity where customerId=:custId and status='cart'";
		TypedQuery<CartEntity> query = em.createQuery(jpql, CartEntity.class);
		query.setParameter("custId",customerId);
		return query.getResultList();
		
	}

	@Override
	public boolean removeCartItem(CartEntity cart) {
		em.remove(cart);
		return true;
	}

	@Override
	public CartEntity viewCartByCartId(int cartId) {
		return em.find(CartEntity.class, cartId);
	}

	@Override
	public boolean updateCartQuantity(CartEntity cart) {
		em.persist(cart);
		return true;
	}

	@Override
	public String addProductToCart(CartEntity cart) {
		em.persist(cart);
		return "Product Added To Cart Successfully";
	}

	@Override
	public Seed getSeed(int seedId) {

		return em.find(Seed.class,seedId);

		
	}

	@Override
	public Plant getPlant(int plantId) {
		// TODO Auto-generated method stub
		return em.find(Plant.class,plantId);
	}

	@Override
	public Planter getPlanter(int planterId) {
		return em.find(Planter.class,planterId);
	}

	
	}