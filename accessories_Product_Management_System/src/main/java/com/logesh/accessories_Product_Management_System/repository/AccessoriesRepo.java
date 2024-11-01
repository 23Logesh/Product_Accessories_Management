package com.logesh.accessories_Product_Management_System.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.logesh.accessories_Product_Management_System.dto.Accessories;

public interface AccessoriesRepo extends JpaRepository<Accessories, Integer> {

    // Method to find a single accessory by product name
    Optional<Accessories> findByproduct(String product);
 
    List<Accessories> findAllByaccessoryfor(String product);
}
