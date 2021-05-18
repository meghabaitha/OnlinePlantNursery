package com.cg.onlineplantnursery.planter.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.cart.service.CartService;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.exception.PlanterNotFoundException;
import com.cg.onlineplantnursery.planter.repository.IPlanterRepository;




@Service
@Transactional
public class IPlanterServiceImpl implements IPlanterService{
	 @Autowired
	    private IPlanterRepository repository;
	 
	 private Logger logger =LoggerFactory.getLogger(IPlanterServiceImpl.class);
	 
	
	 
	 
	 
	 public Planter addPlanter(Planter planter)
	 {
		 logger.info("**************************Adding Planter**************************");
		 return repository.save(planter);
	 }
	public Planter updatePlanter(Planter planter) throws PlanterNotFoundException
	{
		logger.info("***************************Updating Planter*************************");
		Optional<Planter> planterdb = this.repository.findById(planter.getPlanterId());
		
		if(planterdb.isPresent()) {
			
		  Planter existingPlanter = planterdb.get();
		  existingPlanter.setPlanterId(planter.getPlanterId());
		  existingPlanter.setPlanterheight(planter.getPlanterheight());
		  existingPlanter.setPlanterCapacity(planter.getPlanterCapacity());
		  existingPlanter.setDrinageHoles(planter.getDrinageHoles());
		  existingPlanter.setPlanterColor(planter.getPlanterColor());
		  existingPlanter.setPlanterShape(planter.getPlanterShape());
		  existingPlanter.setPlanterStock(planter.getPlanterStock());
		  existingPlanter.setPlanterCost(planter.getPlanterCost());
	      repository.save(existingPlanter);
	      return existingPlanter;
		}
		
		else
		{
			throw new PlanterNotFoundException("Seed not found with id");
		}
	}

	public void deletePlanter(int planterId) throws PlanterNotFoundException
	{
        logger.info("************************Delete Planter***********************");
		Optional<Planter> plantdb = this.repository.findById(planterId);
		if(plantdb.isPresent())
		{
			this.repository.delete(plantdb.get());
		}
		else
		{
			throw new PlanterNotFoundException("Seed not found with id: "+planterId);
		}
		
	      
	}

	public Planter viewPlanter(int planterId)
	{
		 logger.info("************************View Planter of particular Id***********************");
		Optional<Planter> planterdb = this.repository.findById(planterId);
		if(planterdb.isPresent())
		{
			return planterdb.get();
		}
		else
		{
			throw new PlanterNotFoundException("Seed not found with id: "+planterId);
		}
	}

	public Planter viewPlanter(String planterShape)
	{
		 logger.info("************************View planter of a particular shape***********************"); 
		return repository.findByShape(planterShape);
	}

	public List<Planter> viewAllPlanters()
	{
		 logger.info("************************View all  Planters***********************");
		 return repository.findAll();
	}

	public List<Planter> viewAllPlanters(int minCost, int maxCost)
	{
		 logger.info("************************View List  of Planters in the price range***********************");
		
		 return repository.findAllByCost(minCost,maxCost);
	}
}
