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
import com.logesh.accessories_Product_Management_System.service.AccessoriesService;

@Controller
@RequestMapping("Accessories")
public class AccessoriesController {

    @Autowired
    private AccessoriesService service;
    
  
    
    @PostMapping
    public ResponseEntity<Accessories> addAccessory(@RequestBody Accessories accessory, @RequestParam int pid) {
        return service.addAccessory(accessory,pid);
    }
    
    @GetMapping
    public ResponseEntity<List<Accessories>> getAllAccessories() {
        return service.getAllAccessories();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAccessory(@RequestParam int aid, @RequestParam int pid) {
    	
        return service.deleteAccessory(aid,pid); 
    }
    @PutMapping 
    public ResponseEntity<Accessories> updateAccessoryByProduct(@RequestParam int id, @RequestBody Accessories accessoryDetails)
    {
        return service.updateAccessoryByProduct(id, accessoryDetails);
    }
}
