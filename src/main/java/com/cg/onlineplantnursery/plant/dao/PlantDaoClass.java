package com.cg.onlineplantnursery.plant.dao;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.plant.entity.*;
@Repository
public interface PlantDaoClass extends JpaRepository <Plant,Integer> {

	@Query("SELECT ud FROM PlantInfo ud WHERE ud.commonName=?1")
	Plant findByName(String commonName);

	@Query("SELECT ud FROM PlantInfo ud WHERE ud.typeOfPlant=?1")
	List<Plant> findAllByName(String typeOfPlant);

}
