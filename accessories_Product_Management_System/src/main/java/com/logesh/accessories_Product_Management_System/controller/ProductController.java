package com.logesh.accessories_Product_Management_System.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.logesh.accessories_Product_Management_System.dto.Accessories;
import com.logesh.accessories_Product_Management_System.dto.Product;
import com.logesh.accessories_Product_Management_System.service.ProductService;

@Controller
@RequestMapping("Product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return service.addProduct(product); 
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return service.getAllProducts(); 
    }

    @GetMapping
    public ResponseEntity<Product> getProductById(@RequestParam int id) {
        return service.getProductById(id);  
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestParam int id, @RequestBody Product productDetails) {
        return service.updateProduct(id, productDetails);  
    }
 
    @DeleteMapping
    public ResponseEntity<Product> deleteProduct(@RequestParam int id) {
        return service.deleteProduct(id);  
    }
    
    @GetMapping("/allAccessories")
    public ResponseEntity<List<Accessories>> getAllAccessories(@RequestParam int id)
    {
    	return service.getAllAccessories(id);
    }
}
