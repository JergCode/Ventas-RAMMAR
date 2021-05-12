package com.rammar;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    public List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>() {{
            add(new Producto(1, "Pluma Azul", 5.60, 45, 100));
            add(new Producto(2, "Cuaderno Escolar", 15.20, 50, 50));
            add(new Producto(3, "Calculadora", 63.90, 35, 20));
            add(new Producto(4, "Pluma Negra", 5.60, 45, 100));
            add(new Producto(5, "Lápiz", 3.60, 45, 100));
            add(new Producto(6, "Paquete de Hojas Blancas", 40.36, 30, 100));
            add(new Producto(7, "Borrador", 4.35, 30, 100));
            add(new Producto(8, "Libreta Universitaria", 35.40, 30, 30));
            add(new Producto(9, "Mochila", 375.60, 45, 10));
            add(new Producto(10, "Plumón Negro", 15.60, 45, 100));
        }};
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Producto> addNewProducto(Producto producto) {
        for (Producto p : productos) {
            if (p.getUid() == producto.getUid()) {
                return productos;
            }
        }
        productos.add(producto);
        return productos;
    }

    public Producto getProducto(int uid, int quantity) {
        for (Producto p : productos) {
            if (p.getUid() == uid) {
                return p;
            }
        }
        return null;
    }


}
