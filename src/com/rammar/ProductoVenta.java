package com.rammar;

import java.text.DecimalFormat;

public class ProductoVenta extends Producto{
    private int quantity;

    public ProductoVenta(ProductoInventario p, int quantity) {
        super(p.getId(), p.getDescription(), p.getCost(), p.getProfitPercentage());
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return quantity * getPrice();
    }

    public String getTotalStr() {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(getTotal());
    }
}
