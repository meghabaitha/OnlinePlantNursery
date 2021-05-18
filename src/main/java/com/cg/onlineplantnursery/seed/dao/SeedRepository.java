package com.cg.onlineplantnursery.seed.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.seed.entity.Seed;

@Repository("SeedRepository")
public interface SeedRepository  extends JpaRepository<Seed, Integer>{

	@Query("SELECT ud FROM Seed_Tbl ud WHERE ud.typeOfSeeds=?1")
	public List<Seed> getSeedByType(String typeOfSeeds);

	@Query("SELECT uname FROM Seed_Tbl uname WHERE uname.commonName=?1")
	public Seed getSeedByName(String commonName);

	
}
