package com.cg.onlineplantnursery.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.seed.entity.Seed;

@Entity
@Table(name="cart")
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName = "SEQUENCE1",allocationSize = 1,initialValue = 5001)
	private int cartId;
	private int customerId;
	@NotBlank
	
	private int seedQuantity;
	@NotBlank
	private int plantQuantity;
	@NotBlank
	private int planterQuantity;
	private String status;
	private double subtotal;
	
	@OneToOne
	@JoinColumn(name="seedId")
	private Seed seed = new Seed();
	
	@OneToOne
	@JoinColumn(name="plantId")
	private Plant plant = new Plant();
	
	@OneToOne
	@JoinColumn(name="planterId")
	private Planter planter = new Planter();

	public CartEntity() {
		super();
	}
	

	public CartEntity(int cartId, int customerId, int seedQuantity, int plantQuantity, int planterQuantity,
			String status, double subtotal, Seed seed, Plant plant, Planter planter) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.seedQuantity = seedQuantity;
		this.plantQuantity = plantQuantity;
		this.planterQuantity = planterQuantity;
		this.status = status;
		this.subtotal = subtotal;
		this.seed = seed;
		this.plant = plant;
		this.planter = planter;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSeedQuantity() {
		return seedQuantity;
	}

	public void setSeedQuantity(int seedQuantity) {
		this.seedQuantity = seedQuantity;
	}

	public int getPlantQuantity() {
		return plantQuantity;
	}

	public void setPlantQuantity(int plantQuantity) {
		this.plantQuantity = plantQuantity;
	}

	public int getPlanterQuantity() {
		return planterQuantity;
	}

	public void setPlanterQuantity(int planterQuantity) {
		this.planterQuantity = planterQuantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public Planter getPlanter() {
		return planter;
	}

	public void setPlanter(Planter planter) {
		this.planter = planter;
	}

	@Override
	public String toString() {
		return "CartEntity [cartId=" + cartId + ", customerId=" + customerId + ", seedQuantity=" + seedQuantity
				+ ", plantQuantity=" + plantQuantity + ", planterQuantity=" + planterQuantity + ", status=" + status
				+ ", subtotal=" + subtotal + ", seed=" + seed + ", plant=" + plant + ", planter=" + planter + "]";
	}

	
	
}
