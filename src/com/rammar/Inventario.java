package com.rammar;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    public List<ProductoInventario> productos;

    public Inventario() {
        this.productos = new ArrayList<>() {{
            add(new ProductoInventario("Pluma Azul", 5.60, 45, 100));
            add(new ProductoInventario("Cuaderno Escolar", 15.20, 50, 50));
            add(new ProductoInventario("Calculadora", 63.90, 35, 20));
            add(new ProductoInventario("Pluma Negra", 5.60, 45, 100));
            add(new ProductoInventario("Lápiz", 3.60, 45, 100));
            add(new ProductoInventario("Paquete de Hojas Blancas", 40.36, 30, 100));
            add(new ProductoInventario("Borrador", 4.35, 30, 100));
            add(new ProductoInventario("Libreta Universitaria", 35.40, 30, 30));
            add(new ProductoInventario("Mochila", 375.60, 45, 10));
            add(new ProductoInventario("Plumón Negro", 15.60, 45, 100));
        }};
    }

    public List<ProductoInventario> getProductos() {
        return productos;
    }

    public boolean addNewProduct(ProductoInventario producto) {
        return productos.add(producto);
    }

    public boolean deleteProduct(ProductoInventario producto) {
        return productos.remove(producto);
    }

    public ProductoInventario agregarStock(int id, int quantity) {
        ProductoInventario p = getProducto(id);
        if (p == null) {
            return null;
        }
        p.addStock(quantity);
        return p;
    }

    public ProductoInventario getProducto(int id) {
        for (ProductoInventario p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }


}
