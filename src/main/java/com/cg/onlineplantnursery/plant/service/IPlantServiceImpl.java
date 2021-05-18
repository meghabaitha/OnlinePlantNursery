package com.cg.onlineplantnursery.plant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineplantnursery.order.service.OrderService;
import com.cg.onlineplantnursery.plant.dao.PlantDaoClass;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.exception.PlantNotFoundException;

@Service
@Transactional
public class IPlantServiceImpl implements IPlantService {
	
	@Autowired
	PlantDaoClass dao;
	private Logger logger =LoggerFactory.getLogger(IPlantServiceImpl.class);

	@Override
	public Plant addPlant(Plant plant)
	{
		logger.info("***************************Adding Plant*********************");
		return dao.save(plant);

	}

    @Override
	public void deletePlant(int plantId) throws  PlantNotFoundException
	{
    	logger.info("***************************Deleting plant of a paricular Id*********************");
    	Optional <Plant>a=dao.findById(plantId);
		if(a.isPresent())
		{
		dao.deleteById(plantId);
		}
		else
		{
			throw new PlantNotFoundException("Plant not found withthe given plantId");
		}
	}

	

	@Override
	public Plant viewPlant(String commonName) 
	{
		logger.info("***************************View Plant of particular Id*********************");
		return dao.findByName(commonName);
	}

	@Override
	public List<Plant> viewAllPlants()
	{
		logger.info("***************************View all Plants*************************");
		return dao.findAll();
	}

	@Override
	public Plant updatePlant(Plant plant) {
		
		logger.info("**************************Updating Plan Informationt*********************");
		
		Optional<Plant> plantdb = this.dao.findById(plant.getPlantId());
		
		if(plantdb.isPresent())
		{Plant existingplant= plantdb.get();
		existingplant.setCommonName(plant.getCommonName());
		existingplant.setBloomTime(plant.getBloomTime());
		existingplant.setDifficultyLevel(plant.getDifficultyLevel());
		existingplant.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
		existingplant.setPlantCost(plant.getPlantCost());
		existingplant.setPlantDescription(plant.getPlantDescription());
		existingplant.setPlantHeight(plant.getPlantHeight());
		existingplant.setPlantsStock(plant.getPlantsStock());
		existingplant.setPlantSpread(plant.getPlantSpread());
		existingplant.setTypeOfPlant(plant.getTypeOfPlant());
		existingplant.setTemparature(plant.getTemparature());
		return dao.save(existingplant);
	}
		else
		{

			throw new PlantNotFoundException("Plant not found withthe given plantId");
			
		}
		
	}

	@Override
	public Plant viewPlant(int plantId) throws PlantNotFoundException {
		
		logger.info("***************************View Plants by id *********************");
		Plant plant = null;
		Optional<Plant>op = dao.findById(plantId);
		if(op.isPresent())
		{
			plant= op.get();
		}
			
		else
		{
			throw new PlantNotFoundException("Plant not found withthe given plantId");
		}
		return plant;
	}

	

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant) {
		
		logger.info("***************************View plants based on its types************************");
		return dao.findAllByName(typeOfPlant);
	}

	

}
