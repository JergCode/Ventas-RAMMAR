package com.rammar;

import java.text.DecimalFormat;

public class ProductoInventario extends Producto {
    private Integer stock;
    private static int uid = 1;

    public ProductoInventario(String description, Double cost, Integer profitPercentage, Integer stock) {
        super(uid++, description, cost, profitPercentage);
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

    public Integer getStock() {
        return stock;
    }
}
