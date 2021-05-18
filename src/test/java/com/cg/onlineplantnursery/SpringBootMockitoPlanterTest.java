package com.cg.onlineplantnursery;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;
import com.cg.onlineplantnursery.planter.service.IPlanterService;
import com.cg.onlineplantnursery.seed.entity.Seed;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoPlanterTest {

	@Autowired
	private IPlanterService service;
	
	@MockBean
	private IPlanterRepository repository;
	/*It is used to check whether the object returned by method is similar type of not
	 * Here we take dummy value to check */
	@Test
	public void addPlanterTest()
	{ Planter planter= new Planter(1,(float) 5.5, 30, 2, 4,"round",10,80);
		when(repository.save(planter)).thenReturn(planter);
		assertEquals(planter, service.addPlanter(planter));}
	
	
	/*this method is used to test whether return result(length of the list) is same as expected*/
	@Test
	public void viewAllPlantersTest() 
	{ when(repository.findAll()).thenReturn(Stream
				.of(new Planter(1,(float) 5.5, 30, 2, 4,"round",10,80), new Planter(2,(float) 7.5, 35, 1, 5,"square",20,90)).collect(Collectors.toList()));
		assertEquals(2, service.viewAllPlanters().size());}
	
	

	/*this method is used to test whether return result(boolean value) is same as expected
	 * it is tested using type or shape  of planter*/
	  @Test
	  public void viewPlanterByShapeTest() 
	  {
		  String planterShape = "round";
		  Planter planter = new Planter(1, (float) 5.5, 30, 2, 4,"round",10,80);
		  
	  when(repository.findByShape(planterShape)).thenReturn(planter);
	  assertEquals(true,service.viewPlanter(planterShape).equals(planter));
	  }
	 
	
	
	
	}
	
	
