package com.rammar;

import java.util.UUID;

public class Producto {
    private int uid;
    private String description;
    private Double cost;
    private Integer profitPercentage;
    private Integer stock;

    public Producto(int uid, String description, Double cost, Integer profitPercentage, Integer stock) {
        this.uid = uid;
        this.description = description;
        this.cost = cost;
        this.profitPercentage = profitPercentage;
        this.stock = stock;
    }

    public int addStock(int quantity) {
        this.stock += quantity;
        return this.stock;
    }

    public int subtractStock(int quantity) {
        this.stock -= quantity;
        return this.stock;
    }

    public Double getPrice() {
        return this.cost * (this.profitPercentage / 100 + 1);
    }

    public int getUid() {
        return uid;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStock() {
        return stock;
    }

}
