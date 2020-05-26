package eka.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eka.backend.model.Product;
import eka.backend.repository.ProductRepository;

@Service
public class ProductDAO {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product getProductById(String id) throws Exception {
        return this.productRepository.findById(id).get();
	}

    public void createProduct(Product product) throws Exception {
        this.productRepository.insert(product);
    } 

    public void updateProduct(Product product) throws Exception {
        this.productRepository.save(product);
    }

	public void deleteProduct(String id) throws Exception {
        if (this.productRepository.existsById(id)) {
            this.productRepository.deleteById(id);
            return;
        }
        throw new Exception();
	}
}