package com.cg.onlineplantnursery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.cg.onlineplantnursery.cart.entity.CartEntity;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.order.controller.OrderController;
import com.cg.onlineplantnursery.order.entity.OrderInfo;
import com.cg.onlineplantnursery.order.service.OrderServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cg.onlineplantnursery.order.service.OrderService;

@RunWith(SpringRunner.class)			
@WebMvcTest(value = OrderController.class)
public class OrderControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	OrderService service;
	
	@Test
	public void testAddOrder() throws Exception {
		 OrderInfo mockOrder= new OrderInfo();
		 List<CartEntity> list = new ArrayList<CartEntity>();
		 list.add(new CartEntity());
		 list.add(new CartEntity());
		 Customer custInfo= new Customer();
		 custInfo.setCustomerId(1);
		 mockOrder.setCustomer(custInfo);
		 mockOrder.setPaymentMethod("COD");
		// mockOrder.setCartId(list);
		 mockOrder.setQuantity(2);
		 mockOrder.setTotalPrice(300);
		 mockOrder.setOrderStatus("Shipped");
	     mockOrder.setShippingAddress("M-266");
	     String inputInJson = this.mapToJson(mockOrder);
	     String uri= "/addOrder";
	     
	     Mockito.when(service.addOrder(Mockito.any(OrderInfo.class)))	//return mockOrder when addOrder() is called
	     .thenReturn(mockOrder);
	   
	     RequestBuilder reqBuilder= MockMvcRequestBuilders
	    		 .post(uri)
	    		 .accept(MediaType.APPLICATION_JSON).content(inputInJson)			//accepts JSON
	    		 .contentType(MediaType.APPLICATION_JSON);							//returns JSON
	     
	     MvcResult result = mockMvc.perform(reqBuilder).andReturn();
	     MockHttpServletResponse response = result.getResponse();
	     
	     String outputInJson = response.getContentAsString();
	     assertThat(outputInJson).isEqualTo(inputInJson);
	     assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testSearchOrderById() throws Exception {
		OrderInfo mockOrder= new OrderInfo();
		 int id=1;
		 Customer custInfo= new Customer();
		 custInfo.setCustomerId(id);
		 mockOrder.setCustomer(custInfo);
		 mockOrder.setPaymentMethod("COD");
		 mockOrder.setQuantity(2);
		 mockOrder.setTotalPrice(300);
		 mockOrder.setOrderStatus("Shipped");
	     mockOrder.setShippingAddress("M-266");
		String inputInJson = this.mapToJson(mockOrder);
		String uri= "/searchOrder/"+id;
	     
	     Mockito.when(service.viewOrderById(Mockito.anyInt())).thenReturn(mockOrder);
	     
	     RequestBuilder reqBuilder= MockMvcRequestBuilders
	    		 .get(uri)
	    		 .accept(MediaType.APPLICATION_JSON).content(inputInJson)
	    		 .contentType(MediaType.APPLICATION_JSON);
	     
	     MvcResult result = mockMvc.perform(reqBuilder).andReturn();
	     MockHttpServletResponse response = result.getResponse();
	     
	     String outputInJson = response.getContentAsString();
	     assertThat(outputInJson).isEqualTo(inputInJson);
	     assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	

	@Test
	public void neagtiveTestSearchOrderById() throws Exception {
		String uri= "/searchOrder/1";
	     
	     Mockito.when(service.viewOrderById(Mockito.anyInt())).thenReturn(null);
	     
	     RequestBuilder reqBuilder= MockMvcRequestBuilders
	    		 .get(uri)
	    		 .contentType(MediaType.APPLICATION_JSON);
	     
	     MvcResult result = mockMvc.perform(reqBuilder).andReturn();
	     MockHttpServletResponse response = result.getResponse();
	    
	     assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatus());
	}
	
	private String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	}
	
	
}