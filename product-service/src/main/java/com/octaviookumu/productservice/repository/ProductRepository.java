package com.octaviookumu.productservice.repository;

import com.octaviookumu.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
