package com.cg.onlineplantnursery;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlineplantnursery.seed.dao.SeedRepository;
import com.cg.onlineplantnursery.seed.service.ISeedServiceImpl;

import com.cg.onlineplantnursery.seed.entity.Seed;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoSeedTest {

	@Autowired
	private ISeedServiceImpl service;
	
	@MockBean
	private SeedRepository repository;
	
	/*this method is used to test if the plant is added 
	 * and check whether it returns plant object or not*/
	@Test
	public void addSeedTest()
	{Seed seed = new Seed(9, "Tomato", "1-week", "Little","Easy","Hot","small","round",10,20,7);
	when(repository.save(seed)).thenReturn(seed);
	assertEquals(seed, service.addSeed(seed));}
	
	/*this method is used to test whether return result(length of the list) is same as expected*/
	@Test
	public void viewAllSeedsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Seed(9, "Tomato", "1-week", "Little","Easy","Hot","small","round",10,20,7), new Seed(9, "Gourd", "2-weeks", "Little","Easy","Hot","small","round",50,25,15)).collect(Collectors.toList()));
		assertEquals(2, service.viewAllSeeds().size());}
	
	

	/*this method is used to test whether return result(length of the list) is same as expected
	 * it is tested using type of seed*/
	@Test
	public void viewAllSeedsByTypeTest() {
		String typeOfSeed = "small";
		when(repository.getSeedByType(typeOfSeed))
				.thenReturn(Stream.of(new Seed(9, "Tomato", "1-week", "Little","Easy","Hot","small","round",10,20,7)).collect(Collectors.toList()));
		assertEquals(1, service.viewAllSeeds(typeOfSeed).size());
}
	

	/*this method is used to test whether return result(boolean value) is same as expected
	 * it is tested using name of seed*/
	@Test
	public void viewAllSeedsByNameTest() {
		String commonName = "Tomato";
		Seed seed = new Seed(9, "Tomato", "1-week", "Little","Easy","Hot","small","round",10,20,7);
		when(repository.getSeedByName(commonName)).thenReturn(seed);
				assertEquals(true, service.viewSeedByName(commonName).equals(seed));
}
	
	
}


