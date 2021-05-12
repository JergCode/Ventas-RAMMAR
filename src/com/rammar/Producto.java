package com.rammar;

import java.text.DecimalFormat;
import java.util.UUID;

public class Producto {
    private static final DecimalFormat df = new DecimalFormat("#.00");
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
        return cost * ((double) profitPercentage / 100 + 1);
    }
    public String getPriceStr() {
        return df.format(getPrice());
    }

    public Double getCost() {
        return cost;
    }

    public String getCostStr() {
        return df.format(cost);
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
