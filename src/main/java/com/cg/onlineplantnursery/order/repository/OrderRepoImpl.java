package com.cg.onlineplantnursery.order.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.order.entity.OrderInfo;

@Repository
public class OrderRepoImpl implements OrderRepoInterface {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<OrderInfo> viewOrderByCustomerId(int customerId) {
		
		String jpql = "from OrderInfo oi inner join fetch oi.customer c where c.customerId=:custid";
		TypedQuery<OrderInfo> query = em.createQuery(jpql, OrderInfo.class);
		query.setParameter("custid",customerId);
		return query.getResultList();
	}

	

}
