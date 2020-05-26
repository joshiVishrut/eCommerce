package eka.backend.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ordersDB")
public class Order {
    @Id
    private String id;
    private String username;
    private List<Pair> listOfProducts;
    private Double totalAmount;
    private Date orderDate;

    private Order() {
        this.orderDate = new Date();
        this.id = Long.toString(orderDate.getTime());
    }

    public Order(@JsonProperty("id") String id,
            @JsonProperty("username") String username,
            @JsonProperty("listOfProducts") List<Pair> listOfProducts,
            @JsonProperty("totalAmount") Double totalAmount,
            @JsonProperty("orderDate") String orderDate) {
        this();
        
        this.username = username;
        this.listOfProducts = listOfProducts;
        this.totalAmount = totalAmount;

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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Pair> getListOfProducts() {
        return this.listOfProducts;
    }

    public void setListOfProducts(List<Pair> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderDate() {
        return this.orderDate.toString();
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}