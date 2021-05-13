package com.rammar;

import java.util.ArrayList;
import java.util.List;

public class RegistroVentas {
    private static final List<Venta> registroVentas = new ArrayList<>();

    public static Venta nuevaVenta() {
        Venta venta = new Venta();
        registroVentas.add(venta);
        return venta;
    }

    public static List<Venta> obtenerVentas() {
        return registroVentas;
    }
}
