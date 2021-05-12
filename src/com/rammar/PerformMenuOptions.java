package com.rammar;

import com.rammar.interfaz.ActionHandler;
import com.rammar.interfaz.Helpers;
import com.rammar.interfaz.Menu;

import java.util.Scanner;

public class PerformMenuOptions {

    public static void actionHandler(Actions action, Inventario inventario) {
        switch (action) {
            case COBRAR:
                cobrar(inventario);
                break;
            case MOSTRAR_INVENTARIO:
                mostrarInventario(inventario);
                break;
            case RECIBIR_MERCANCIA:
                recibirMercancia(inventario);
                break;
            case AGREGAR_PRODUCTO:
                agregarProducto(inventario);
                break;
            case ELIMINAR_PRODUCTO:
                eliminarProducto(inventario);
                break;
            default:
                accionNoValida();
        }
    }

    private static void cobrar(Inventario inventario) {

    }

    private static void mostrarInventario(Inventario inventario) {
        ActionHandler.printInventario(inventario);
    }

    private static void recibirMercancia(Inventario inventario) {

    }

    private static void agregarProducto(Inventario inventario) {

    }

    private static void eliminarProducto(Inventario inventario) {

    }

    private static void accionNoValida() {
        System.out.println("La opción seleccionada no es valida");
        Scanner scanner = MyScanner.getInstance().getScanner();
        scanner.nextLine();
    }


}
