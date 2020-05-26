package eka.backend.model;

public class Pair {
    private String productId;
    private Integer quantity;

    public Pair(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return this.productId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }
}