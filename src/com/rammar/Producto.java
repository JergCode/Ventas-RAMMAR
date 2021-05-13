package com.rammar;

import java.text.DecimalFormat;
import java.util.UUID;

public abstract class Producto {
    private static final DecimalFormat df = new DecimalFormat("#.00");
    private int id;
    private String description;
    private Double cost;
    private Integer profitPercentage;

    public Producto(int id, String description, Double cost, Integer profitPercentage) {
        this.id = id;
        this.description = description;
        this.cost = cost;
        this.profitPercentage = profitPercentage;
    }

    public Double getPrice() {
        return cost * ((double) profitPercentage / 100 + 1);
    }

    public Integer getProfitPercentage() {
        return profitPercentage;
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

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
