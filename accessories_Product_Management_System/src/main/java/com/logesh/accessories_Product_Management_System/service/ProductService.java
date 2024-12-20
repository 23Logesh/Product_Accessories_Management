package com.logesh.accessories_Product_Management_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logesh.accessories_Product_Management_System.dto.Accessories;
import com.logesh.accessories_Product_Management_System.dto.Product;
import com.logesh.accessories_Product_Management_System.repository.AccessoriesRepo;
import com.logesh.accessories_Product_Management_System.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepository;
    
    @Autowired
    private AccessoriesRepo accessoryRepository;

    public ResponseEntity<Product> addProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<Product> getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Product> updateProduct(int id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setModel(productDetails.getModel());
            product.setProduct(productDetails.getProduct());
            product.setMake(productDetails.getMake());
            product.setCost(productDetails.getCost());
            product.setQuantity(productDetails.getQuantity());
            Product updatedProduct = productRepository.save(product);
            return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Product> deleteProduct(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Accessories>> getAllAccessories(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            String productName = productOptional.get().getProduct(); 
            List<Accessories> accessories = accessoryRepository.findAllByaccessoryfor(productName);
            return new ResponseEntity<>(accessories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
