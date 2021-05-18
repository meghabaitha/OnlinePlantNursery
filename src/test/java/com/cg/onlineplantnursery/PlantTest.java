package com.cg.onlineplantnursery;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlineplantnursery.plant.dao.PlantDaoClass;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.IPlantServiceImpl;
import com.cg.onlineplantnursery.seed.entity.Seed;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlantTest 
{
	@Autowired
	public IPlantServiceImpl service;
	
	@MockBean
	private PlantDaoClass repository;
	
	/*this method is used to test if the plant is added 
	 * and check whether it returns plant object or not*/
	@Test
	public void addPlantTest()
	{
		Plant plant = new Plant(100,10,"high","Hibiscus","All year"," no", "moderate","30"," flower"," rrr",25,100.00);
		when(repository.save(plant)).thenReturn(plant);
		assertEquals(plant, service.addPlant(plant));
	}
	
	
	/*this method is used to test whether return result(length of the list) is same as expected*/
	
	@Test
	public void viewAllPlantsTest()
	{
		when(repository.findAll()).thenReturn(Stream
				.of(new Plant(100,10,"high","Hibiscus","All year"," no", "moderate","30"," flower"," rrr",25,100.00), new Plant(100,10,"high","Hibiscus","All year"," no", "moderate","30"," flower"," rrr",25,100.00)).collect(Collectors.toList()));
		assertEquals(2, service.viewAllPlants().size());
	}
	
	/*this method is used to test whether return result(length of the list) is same as expected
	 * it is tested using type of plant*/
	@Test
	public void viewAllPlantsByTypeTest() {
		String typeOfPlant = "flower";
		when(repository.findAllByName(typeOfPlant))
				.thenReturn(Stream.of(new Plant(100,10,"high","Hibiscus","All year"," no", "moderate","30"," flower"," rrr",25,100.00)).collect(Collectors.toList()));
		assertEquals(1, service.viewAllPlants(typeOfPlant).size());
}
	
	

}
