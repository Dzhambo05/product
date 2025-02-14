package com.example.demo.repo;

import com.example.demo.entites.Product;
import com.example.demo.entites.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("select p from Product p where p.type = ?1")
    public Product findProductByType(Type type);
}
