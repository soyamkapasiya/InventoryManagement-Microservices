package com.kapasiya.product_service.repository;

import com.kapasiya.product_service.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    boolean existsByName(String name);
}
