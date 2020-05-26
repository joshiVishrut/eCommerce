package eka.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eka.backend.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}