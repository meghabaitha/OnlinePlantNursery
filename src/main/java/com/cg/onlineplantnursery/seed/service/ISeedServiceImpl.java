package com.cg.onlineplantnursery.seed.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.exception.SeedNotFoundException;
import com.cg.onlineplantnursery.planter.service.IPlanterServiceImpl;
import com.cg.onlineplantnursery.seed.dao.SeedRepository;
import com.cg.onlineplantnursery.seed.entity.Seed;

@Service
@Transactional
public class ISeedServiceImpl implements ISeedService {

	@Autowired
	private SeedRepository repo;
	 private Logger logger =LoggerFactory.getLogger(ISeedServiceImpl.class);
	
	@Override
	public Seed addSeed(Seed seed) {
		
		logger.info("***************************Adding Seed*******************************");
		return repo.save(seed);
	}

	@Override
	public Seed updateSeed(Seed seed) {
		
		logger.info("***************************Updating Seed*******************************");
		Optional<Seed> seeddb = this.repo.findById(seed.getSeedId());
		
		if(seeddb.isPresent())
		{
			Seed seedupdate = seeddb.get();
			seedupdate.setSeedId(seed.getSeedId());
			seedupdate.setCommonName(seed.getCommonName());
			seedupdate.setBloomTime(seed.getBloomTime());
			seedupdate.setDifficultyLevel(seed.getDifficultyLevel());
			seedupdate.setSeedsCost(seed.getSeedsCost());
			seedupdate.setSeedsDescription(seed.getSeedsDescription());
			seedupdate.setSeedsPerPacket(seed.getSeedsPerPacket());
			seedupdate.setSeedsStock(seed.getSeedsStock());
			seedupdate.setTemparature(seed.getTemparature());
			seedupdate.setTypeOfSeeds(seed.getTypeOfSeeds());
			seedupdate.setWatering(seed.getWatering());
			
			repo.save(seedupdate);
			return seedupdate;
			
			
		}
		else
		{
			throw new SeedNotFoundException("Seed not found with id: "+seed.getSeedId());
		}
	}

	@Override
	public void deleteSeed(int seedId)  throws SeedNotFoundException{
		
		logger.info("***************************Deleting Seed*******************************");
		
		Optional<Seed> seeddb = this.repo.findById(seedId);
		if(seeddb.isPresent())
		{
			this.repo.delete(seeddb.get());
		}
		else
		{
			throw new SeedNotFoundException("Seed not found with id: "+seedId);
		}
		
	
	}

	@Override
	public Seed viewSeed(int seedId) throws SeedNotFoundException {
		
		logger.info("***************************View Seed*******************************");
		Optional<Seed> seeddb = this.repo.findById(seedId);
		if(seeddb.isPresent())
		{
			return seeddb.get();
		}
		else
		{
			throw new SeedNotFoundException("Seed not found with id: "+seedId);
		}
	}

	@Override
	public Seed viewSeedByName(String commonName) {
		
		logger.info("***************************View Seed by name*******************************");
		return repo.getSeedByName(commonName);
	}

	@Override
	public List<Seed> viewAllSeeds() {
		
		logger.info("**************************View List of  Seeds*******************************");
		return repo.findAll();
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeeds) {
		
		logger.info("***************************View type of Seeds*******************************");
		return repo.getSeedByType(typeOfSeeds);
	}

}
