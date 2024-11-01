package com.logesh.accessories_Product_Management_System.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String model;
	private String product;
	private String make;
	private double cost;
	private int quantity;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Accessories> accessories;

	
	
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
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Accessories> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<Accessories> accessories) {
		this.accessories = accessories;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", model=" + model + ", product=" + product + ", make=" + make + ", cost=" + cost
				+ ", quantity=" + quantity + ", accessories=" + accessories + ", getId()=" + getId() + ", getModel()="
				+ getModel() + ", getProduct()=" + getProduct() + ", getMake()=" + getMake() + ", getCost()="
				+ getCost() + ", getQuantity()=" + getQuantity() + ", getAccessories()=" + getAccessories() + "]";
	}

	 
	
}
