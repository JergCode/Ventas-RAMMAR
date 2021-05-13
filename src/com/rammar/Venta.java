package com.rammar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private static int uid = 0;
    private String folio;
    private List<ProductoVenta> productos;

    public Venta() {
        productos = new ArrayList<>();
        this.folio = "F-" + uid++;
    }

    public List<ProductoVenta> agregarProducto(ProductoVenta producto) {
        this.productos.add(producto);
        return this.productos;
    }

    public List<ProductoVenta> eliminarProducto(int index) {
        this.productos.remove(index);
        return this.productos;
    }

    public String getFolio() {
        return folio;
    }

    public List<ProductoVenta> getProductos() {
        return productos;
    }

    public Double getTotal() {
        double total = 0;
        for (ProductoVenta p : productos) {
            total += p.getTotal();
        }
//        total = productos.stream().map(Producto::getPrice).reduce(0.0, Double::sum);
        return total;
    }

    public String getTotalStr() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(getTotal());
    }


}
