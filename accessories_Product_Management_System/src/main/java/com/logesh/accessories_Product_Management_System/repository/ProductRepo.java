package com.logesh.accessories_Product_Management_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logesh.accessories_Product_Management_System.dto.Product;

public interface ProductRepo	extends JpaRepository<Product, Integer> {

	public List<Product> findAllByproduct(String product);
	public Product findBymake(String make);
}
