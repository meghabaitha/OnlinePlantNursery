package com.cg.onlineplantnursery.seed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.exception.SeedNotFoundException;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.service.ISeedService;

@RestController
public class SeedController {

	@Autowired
	private ISeedService seedService;
	
	/*In order to add seed information in database*/
	@PostMapping("/addseed")
	public ResponseEntity<Seed> addSeed( @RequestBody Seed seed)
	{
		
		return 	ResponseEntity.ok().body(this.seedService.addSeed(seed));
	}
	
	/*View all seed informations that are currently present*/
	@GetMapping("/viewseed")
	public ResponseEntity<List<Seed>> viewAllSeeds() throws SeedNotFoundException
	{
		return ResponseEntity.ok().body(seedService.viewAllSeeds());
	}
	
	/*To retrieve seed information by using a particular seed id*/
	@GetMapping(path = "/viewseedbyid/{seedId}")
	public Seed viewSeed(@PathVariable("seedId") int seedId)
	{
		
		return seedService.viewSeed(seedId);
	}
	
	/*View a particular seed by using seed name*/
	
	@GetMapping(path = "/viewseedbyname/{commonName}")
	public ResponseEntity<Seed> viewSeedByName(@PathVariable("commonName") String commonName)
	{
		return ResponseEntity.ok().body(seedService.viewSeedByName(commonName));
	}
	
	/*view a particular seed using type of seed*/
	@GetMapping(path = "/viewseedbytype/{typeOfSeeds}")
	public ResponseEntity<List<Seed>> viewAllSeeds(@PathVariable("typeOfSeeds") String typeOfSeeds)
	{
		return ResponseEntity.ok().body(seedService.viewAllSeeds(typeOfSeeds));
	}
	
	
	/*update a particular seed information using seed id*/
	@PutMapping(path = "/updateseed/{seedId}")
	public ResponseEntity<Seed> updateSeedById(@PathVariable("seedId") int seedId,@RequestBody Seed seed)
	{
		seed.setSeedId(seedId);
		return ResponseEntity.ok().body(this.seedService.updateSeed(seed));
	}
	
	/*delete a particular seed information using seed id*/
	@DeleteMapping(path = "/deleteseed/{seedId}")
	public String deleteSeed(@PathVariable("seedId") int seedId) throws SeedNotFoundException
	{
		this.seedService.deleteSeed(seedId);
		return("Delete is done successfully ");
	}
	
	
}
