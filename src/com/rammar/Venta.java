package com.rammar;

import java.util.List;

public class Venta {
    private String folio;
    private List<Producto> productos;

    public Venta(String folio) {
        this.folio = folio;
    }

    public List<Producto> agregarProducto(Producto producto) {
        this.productos.add(producto);
        return this.productos;
    }

    public List<Producto> eliminarProducto(int index) {
        this.productos.remove(index);
        return this.productos;
    }

    public Double getTotal() {
        double total = 0;
//        for (Producto p : productos) {
//            total += p.getPrice();
//        }
        total = productos.stream().map(Producto::getPrice).reduce(0.0, Double::sum);
        return total;
    }


}
