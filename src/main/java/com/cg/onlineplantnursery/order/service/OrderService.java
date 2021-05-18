package com.cg.onlineplantnursery.order.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.customer.service.CustomerServiceImpl;
import com.cg.onlineplantnursery.order.entity.OrderInfo;
import com.cg.onlineplantnursery.order.exception.*;
import com.cg.onlineplantnursery.order.repository.OrderNormalRepo;
import com.cg.onlineplantnursery.order.repository.OrderRepoInterface;


@Service
@Transactional
public class OrderService implements OrderServiceInterface {

	@Autowired
	OrderNormalRepo orderrepo;
	
	@Autowired
	OrderRepoInterface repo;
	
	private Logger logger =LoggerFactory.getLogger(OrderService.class);
	
	@Override
	public OrderInfo addOrder(OrderInfo order) throws RecordAlreadyPresentException {
		
		logger.info("************************Add order***********************");
		Optional<OrderInfo> newOrder = orderrepo.findById(order.getOrderId());
		if(newOrder.isPresent()) {
			throw new RecordAlreadyPresentException();
		}
		else {
			orderrepo.save(order);
			return order;
		}
		
	}

	@Override
	public OrderInfo viewOrderById(int orderId) {
		
		logger.info("************************View order***********************");
		
		Optional<OrderInfo> order = orderrepo.findById(orderId);
		if(!order.isPresent()) {
			throw new RecordNotFoundException();
		}
		else
			return order.get();
	}
	

	@Override
	public Iterable<OrderInfo> listAllOrder() {
		
		logger.info("************************View list of  orders***********************");
		
		Iterable<OrderInfo> list = orderrepo.findAll();
		if(list==null) {
			throw new RecordNotFoundException();
		}
		else
			return list;
	
	}

	@Override
	public List<OrderInfo> viewOrderByCustomerId(int customerId) {
		
		logger.info("************************view orderof a particular customer***********************");
		
		List<OrderInfo> list = repo.viewOrderByCustomerId(customerId);
		if(list==null) {
			throw new RecordNotFoundException();
		}
		else
			return list;
	}
}


