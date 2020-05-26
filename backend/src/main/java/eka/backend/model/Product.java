package eka.backend.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productsDB")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private Double price;

    private Product() {
        this.id = Long.toString(new Date().getTime());
    }

    public Product(String name, String description, Double price) {
        this();
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(@JsonProperty("id") String id, @JsonProperty("name") String name,
    @JsonProperty("description") String description, @JsonProperty("price") Double price) {
        this(name, description, price);
        if (id != null) {
            this.id = id;
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}