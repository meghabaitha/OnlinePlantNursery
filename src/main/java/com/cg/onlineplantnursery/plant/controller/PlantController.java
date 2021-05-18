package com.cg.onlineplantnursery.plant.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.IPlantServiceImpl;

@RestController
@RequestMapping("/Plantinfo")
public class PlantController 
{
	@Autowired
	IPlantServiceImpl ipl;
	
	// Add plant
	@PostMapping("/PlantAddition")
	public Plant addPlant(@RequestBody Plant plant)
	{
		return ipl.addPlant(plant);
		
	}
	
	// Update Plant
	@PutMapping("/UpdatePlant/{plantId}")
	public Plant updatePlant(@PathVariable int plantId,@RequestBody Plant plant)
	{
		plant.setPlantId(plantId);
		return ipl.updatePlant(plant);
		
	}
	//Delete Plant
	@DeleteMapping("/DeletePlant/{plantId}")
	public String deletePlant(@PathVariable int plantId)
	{
		 ipl.deletePlant(plantId);
		 return " Plant deleted sucessfully";
		
	}
	
	/*To retrieve plant information using a particular plant id */
	@GetMapping("/PlantViewbyid/{plantId}")
	public Plant viewPlant(@PathVariable("plantId") int plantId)
	{
		return ipl.viewPlant(plantId);
		
	}
	
	/*Retrieve a particular plant using common name of plant*/
	@GetMapping("/PlantViewbyname/{commonName}")
	public Plant viewPlant(@PathVariable("commonName") String commonName)
	{
		return ipl.viewPlant(commonName);
	}
	
	/*view all plant details present in database*/
	@GetMapping("/PlantViewAll")
	public List<Plant> viewAllPlants() 
	{
		return ipl.viewAllPlants();
	}
	
	/*view all plants using types of plants*/
	@GetMapping("/PlantViewAllbytype/{typeOfPlant}")
	public List<Plant> viewAllPlants(@PathVariable("typeOfPlant") String typeOfPlant)
	{
		return ipl.viewAllPlants(typeOfPlant);
	}
	

}
