package com.cg.onlineplantnursery.order.service;

import java.util.List;

import com.cg.onlineplantnursery.order.entity.OrderInfo;
import com.cg.onlineplantnursery.order.exception.RecordAlreadyPresentException;

public interface OrderServiceInterface {
	
	
   public OrderInfo addOrder(OrderInfo order) throws RecordAlreadyPresentException;
	
	public OrderInfo viewOrderById(int id);
	
	public Iterable<OrderInfo> listAllOrder();
	
	public List<OrderInfo> viewOrderByCustomerId(int customerId);
	

}
