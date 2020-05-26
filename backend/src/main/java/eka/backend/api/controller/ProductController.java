package eka.backend.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eka.backend.model.Product;
import eka.backend.api.viewmodel.Response;
import eka.backend.service.ProductDAO;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductDAO productDAO;

    @GetMapping("/get/all")
    public Response<Product> getAllProducts() {
        Response<Product> response; 
        List<Product> products = this.productDAO.getAllProducts();
        if (products.isEmpty()) {
            response = new Response<>("error", "get: empty db");
        }
        else {
            response = new Response<>(products, "array", "get: success");
        }
        return response;
    }

    @GetMapping("/get/{id}")
    public Response<Product> getProductById(@PathVariable("id") String id) {
        Response<Product> response;
        try {
            List<Product> product = new ArrayList<>(Arrays.asList(this.productDAO.getProductById(id)));
            response = new Response<>(product, "success", "get: product found");
        }
        catch(Exception e) {
            response = new Response<>("error", "get: product not found");
        }
        return response;
    }

    @PutMapping("/put")
    public Response<Product> createProduct(@RequestBody Product product) {
        Response<Product> response;
        try {
            this.productDAO.createProduct(product);
            response = new Response<>(new ArrayList<>(Arrays.asList(product)), "success", "put: product created");
        }
        catch(Exception e) {
            response = new Response<>("error", "put: product not created");
        }
        return response;
    }

    @PostMapping("post")
    public Response<Product> updateProduct(@RequestBody Product product) {
        Response<Product> response;
        try {
            this.productDAO.updateProduct(product);
            response = new Response<>("success", "post: product updated");
        }
        catch(Exception e) {
            response = new Response<>("error", "post: product not updated");
        }
        return response;
    }

    @DeleteMapping("delete/{id}")
    public Response<Product> deleteProduct(@PathVariable("id") String id) {
        Response<Product> response;
        try {
            this.productDAO.deleteProduct(id);
            response = new Response<>("success", "delete: product deleted");
        }
        catch(Exception e) {
            response = new Response<>("error", "delete: product not found");
        }
        return response;
    }
}