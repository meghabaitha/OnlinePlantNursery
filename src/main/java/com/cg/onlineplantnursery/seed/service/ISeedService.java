package com.cg.onlineplantnursery.seed.service;
import java.util.List;

import com.cg.onlineplantnursery.seed.entity.Seed;

public interface ISeedService {
	Seed addSeed(Seed seed);

	Seed updateSeed(Seed seed);

	void deleteSeed(int seedId);

	Seed viewSeed(int seedId);

	List<Seed> viewAllSeeds();

	List<Seed> viewAllSeeds(String typeOfSeed);

	Seed viewSeedByName(String commonName);

	
}
