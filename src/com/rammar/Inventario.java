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
            add(new Producto(4, "Pluma Azul", 5.60, 45, 100));
            add(new Producto(5, "Pluma Azul", 5.60, 45, 100));
            add(new Producto(6, "Pluma Azul", 5.60, 45, 100));
            add(new Producto(7, "Pluma Azul", 5.60, 45, 100));
            add(new Producto(8, "Pluma Azul", 5.60, 45, 100));
            add(new Producto(9, "Pluma Azul", 5.60, 45, 100));
            add(new Producto(10, "Pluma Azul", 5.60, 45, 100));

        }};

    }
}
