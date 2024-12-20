package com.logesh.accessories_Product_Management_System.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Accessories {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String model;

	private String product;
	private String make;
	private double cost;
	private int Quantity;
	private String accessoryfor;
		
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getAccessoryfor() {
		return accessoryfor;
	}
	public void setAccessoryfor(String accessoryfor) {
		this.accessoryfor = accessoryfor;
	}
	public Accessories(int id, String model, String product, String make, double cost, int quantity,
			String accessoryfor) {
		super();
		this.id = id;
		this.model = model;
		this.product = product;
		this.make = make;
		this.cost = cost;
		Quantity = quantity;
		this.accessoryfor = accessoryfor;
	}
	public Accessories() {
		super();
	}
		
}
