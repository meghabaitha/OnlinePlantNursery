package com.cg.onlineplantnursery.order.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.order.entity.OrderInfo;

@Repository
public interface OrderRepoInterface  {


	public List<OrderInfo> viewOrderByCustomerId(int customerId);

}
