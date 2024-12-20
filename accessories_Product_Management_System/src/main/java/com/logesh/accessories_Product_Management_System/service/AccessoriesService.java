package com.logesh.accessories_Product_Management_System.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logesh.accessories_Product_Management_System.dto.Accessories;
import com.logesh.accessories_Product_Management_System.dto.Product;
import com.logesh.accessories_Product_Management_System.repository.AccessoriesRepo;
import com.logesh.accessories_Product_Management_System.repository.ProductRepo;

@Service
public class AccessoriesService {

	@Autowired
	private AccessoriesRepo accessoryRepository;

	@Autowired
	private ProductRepo prepo;

	public ResponseEntity<Accessories> addAccessory(Accessories accessory, int productId) {
		Product p = prepo.findById(productId).get();
		if (p != null) {
			accessory.setAccessoryfor(p.getProduct());
			Accessories saved = accessoryRepository.save(accessory);
			p.getAccessories().add(saved);
			prepo.save(p);
			return new ResponseEntity<>(accessory, HttpStatus.CREATED);
		}
		return null; // throw product not found exception

	}

	public ResponseEntity<List<Accessories>> getAllAccessories() {
		List<Accessories> accessories = accessoryRepository.findAll();
		return new ResponseEntity<>(accessories, HttpStatus.OK);
	}

	public ResponseEntity<Accessories> updateAccessoryByProduct(int id, Accessories accessoryDetails) {
		return accessoryRepository.findById(id).map(accessory -> {
			// Update fields
			accessory.setModel(accessoryDetails.getModel());
			accessory.setProduct(accessoryDetails.getProduct());
			accessory.setMake(accessoryDetails.getMake());
			accessory.setCost(accessoryDetails.getCost());
			accessory.setQuantity(accessoryDetails.getQuantity());
			Accessories updatedAccessory = accessoryRepository.save(accessory);
			return new ResponseEntity<>(updatedAccessory, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public ResponseEntity<Void> deleteAccessory(int assecoryid, int productid) {
		// Check if the accessory exists]

		Product exiProduct = prepo.findById(productid).get();
		Accessories access = accessoryRepository.findById(assecoryid).get();

		if (exiProduct != null && access != null) {
			exiProduct.getAccessories().remove(access);
			prepo.save(exiProduct);

			// Delete the accessory
			accessoryRepository.deleteById(assecoryid);
			return new ResponseEntity<>(HttpStatus.OK); // Return success response
		}  
		return null;
	}

}
