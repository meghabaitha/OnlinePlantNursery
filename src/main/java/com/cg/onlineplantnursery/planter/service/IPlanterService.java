package com.cg.onlineplantnursery.planter.service;

import java.util.List;

import com.cg.onlineplantnursery.planter.entity.Planter;

public interface IPlanterService {
	
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter);

	void deletePlanter(int planterid);

	Planter viewPlanter(int planterId);

	Planter viewPlanter(String planterShape);

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(int minCost, int maxCost);
}
