package com.cg.onlineplantnursery.seed.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity(name = "Seed_Tbl")
@Table(name = "Seed_Tbl")
public class Seed {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE5")
		@SequenceGenerator(name="SEQUENCE5", sequenceName = "SEQUENCE5",allocationSize = 1,initialValue = 601)
		private Integer seedId;
		private String commonName;
		private String bloomTime;
		private String watering;
		private String difficultyLevel;
		private String temparature;
		private String typeOfSeeds;
		private String seedsDescription;
		private Integer seedsStock;
		private double seedsCost;
		private Integer seedsPerPacket;
		
		public Seed()
		{
			
		}
		public Seed(Integer seedId, String commonName, String bloomTime, String watering, String difficultyLevel,
				String temparature, String typeOfSeeds, String seedsDescription, Integer seedsStock, double seedsCost,
				Integer seedsPerPacket) {
			super();
			this.seedId = seedId;
			this.commonName = commonName;
			this.bloomTime = bloomTime;
			this.watering = watering;
			this.difficultyLevel = difficultyLevel;
			this.temparature = temparature;
			this.typeOfSeeds = typeOfSeeds;
			this.seedsDescription = seedsDescription;
			this.seedsStock = seedsStock;
			this.seedsCost = seedsCost;
			this.seedsPerPacket = seedsPerPacket;
		}
		public Integer getSeedId() {
			return seedId;
		}
		public void setSeedId(Integer seedId) {
			this.seedId = seedId;
		}
		public String getCommonName() {
			return commonName;
		}
		public void setCommonName(String commonName) {
			this.commonName = commonName;
		}
		public String getBloomTime() {
			return bloomTime;
		}
		public void setBloomTime(String bloomTime) {
			this.bloomTime = bloomTime;
		}
		public String getWatering() {
			return watering;
		}
		public void setWatering(String watering) {
			this.watering = watering;
		}
		public String getDifficultyLevel() {
			return difficultyLevel;
		}
		public void setDifficultyLevel(String difficultyLevel) {
			this.difficultyLevel = difficultyLevel;
		}
		public String getTemparature() {
			return temparature;
		}
		public void setTemparature(String temparature) {
			this.temparature = temparature;
		}
		public String getTypeOfSeeds() {
			return typeOfSeeds;
		}
		public void setTypeOfSeeds(String typeOfSeeds) {
			this.typeOfSeeds = typeOfSeeds;
		}
		public String getSeedsDescription() {
			return seedsDescription;
		}
		public void setSeedsDescription(String seedsDescription) {
			this.seedsDescription = seedsDescription;
		}
		public Integer getSeedsStock() {
			return seedsStock;
		}
		public void setSeedsStock(Integer seedsStock) {
			this.seedsStock = seedsStock;
		}
		public double getSeedsCost() {
			return seedsCost;
		}
		public void setSeedsCost(double seedsCost) {
			this.seedsCost = seedsCost;
		}
		public Integer getSeedsPerPacket() {
			return seedsPerPacket;
		}
		public void setSeedsPerPacket(Integer seedsPerPacket) {
			this.seedsPerPacket = seedsPerPacket;
		}
	}


