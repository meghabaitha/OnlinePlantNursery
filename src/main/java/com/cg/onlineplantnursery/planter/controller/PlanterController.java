package com.cg.onlineplantnursery.planter.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.service.IPlanterService;
import com.cg.onlineplantnursery.planter.service.IPlanterServiceImpl;
//import com.cg.onlineplantnursery.seed.entity.Seed;
//import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.planter.exception.PlanterNotFoundException;


@RestController
@RequestMapping("/Planter_tb")
public class PlanterController {
	
	@Autowired
	IPlanterService iplanter;

	//Add Planter
	@PostMapping("/PlanterAddition")
	public Planter addPlanter(@RequestBody Planter planter)
	{
		return iplanter.addPlanter(planter);
	}
	
	//Update Planter
	@PutMapping(path = "/update/{planterId}")
	public Planter updatePlanterbyid(@RequestBody Planter planter,@PathVariable("planterId") int planterId) 
	{
		planter.setPlanterId(planterId);
		return (iplanter.updatePlanter(planter));
	}
	
	//Delete Planter
	@DeleteMapping("/DeletePlanter/{planterId}") 
	public String deletePlanter(@PathVariable int planterId) throws PlanterNotFoundException
	{
		this.iplanter.deletePlanter(planterId);
		
		return "Planter deleted sucessfully";
	}

     // Get a particular planter by planter id
	 @GetMapping("/PlanterViewbyid/{planterId}")
	  public Optional<Planter> viewPlanter(@PathVariable int planterId) 
	  
	  { 
		 return Optional.of(iplanter.viewPlanter(planterId)); 
		 }
	
	// Get a planter information by using planter name
	@GetMapping("/PlanterViewbyshape/{planterShape}")
	public ResponseEntity<Planter> viewPlanter(@PathVariable("planterShape") String planterShape)
	{
		return ResponseEntity.ok().body(iplanter.viewPlanter(planterShape));
	}
	
	// View all planter present
	@GetMapping("/planterViewAllvalue")
	public ResponseEntity <List<Planter>> viewAllPlanters() 
	{
		return ResponseEntity.ok().body(iplanter.viewAllPlanters());
	}
	
	// Get all planter which cost ranges from mincost to maxcost
	@GetMapping("/PlanterViewAll/{minCost}/{maxCost}")
	public List<Planter> viewAllPlanters(@PathVariable("minCost") int minCost, @PathVariable("maxCost") int maxCost)
	{
		return iplanter.viewAllPlanters(minCost, maxCost);
	}
	
}

