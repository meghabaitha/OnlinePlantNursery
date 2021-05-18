package com.cg.onlineplantnursery.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineplantnursery.order.entity.OrderInfo;
import com.cg.onlineplantnursery.order.exception.NullArgumentException;
import com.cg.onlineplantnursery.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService service;
	
	// To add order of a particular customer from cart
	@PostMapping("/addOrder")
	public ResponseEntity<OrderInfo> addOrder(@RequestBody OrderInfo order) {
		if(order==null) {
			throw new NullArgumentException();
		}
		else {
			service.addOrder(order);
			return new ResponseEntity<OrderInfo>(order, HttpStatus.OK);
		}
	}	
	
	
	// To search for an order details by using order id
	@GetMapping("/searchOrder/{orderId}")
	public ResponseEntity<OrderInfo> viewOrderById(@PathVariable("orderId") Integer id){
		OrderInfo order= service.viewOrderById(id);
		if(order!=null) {
			return new ResponseEntity<OrderInfo>(order, HttpStatus.OK);
		}
		else
			throw new NullArgumentException();
	}
	
	// view all order present
	
	@GetMapping("/viewAllOrder")
	public Iterable<OrderInfo> viewAllOrder(){
		Iterable<OrderInfo> orderList= service.listAllOrder();
		return orderList;
	}
	
	// View all orders by customer id
	
	@GetMapping("/viewOrderByCustomerId/{customerId}")
	public List<OrderInfo> viewOrderByCustomerId(@PathVariable("customerId") int customerId) {
		return service.viewOrderByCustomerId(customerId);
	}

	

}
