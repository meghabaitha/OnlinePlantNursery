package com.cg.onlineplantnursery.planter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.planter.entity.Planter;

@Repository
public interface IPlanterRepository extends JpaRepository<Planter,Integer> {

	
	@Query("SELECT ud FROM Planter_tb ud  WHERE ud.planterShape=?1")
	Planter findByShape(String planterShape);
	
	
	
	@Query("SELECT up FROM Planter_tb up WHERE up.planterCost>?1 AND up.planterCost<?2 ")
	List<Planter> findAllByCost(int minCost, int maxCost);

	
	
}

