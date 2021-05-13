package com.rammar;

import com.rammar.interfaz.ActionHandler;

import java.util.Scanner;

import static com.rammar.interfaz.Helpers.clearScreen;
import static com.rammar.interfaz.Helpers.printUserInfo;

public class PerformMenuOptions {

    public static void actionHandler(Actions action, Inventario inventario, User user) {
        switch (action) {
            case COBRAR:
                cobrar(inventario, user);
                break;
            case MOSTRAR_INVENTARIO:
                mostrarInventario(inventario, user);
                break;
            case RECIBIR_MERCANCIA:
                recibirMercancia(inventario, user);
                break;
            case AGREGAR_PRODUCTO:
                agregarProducto(inventario, user);
                break;
            case ELIMINAR_PRODUCTO:
                eliminarProducto(inventario, user);
                break;
            default:
                accionNoValida();
        }
    }

    private static void cobrar(Inventario inventario, User user) {
        ActionHandler.cobrar(inventario, user);
    }

    private static void mostrarInventario(Inventario inventario, User user) {
        clearScreen();
        printUserInfo(user);
        ActionHandler.printInventario(inventario);
    }

    private static void recibirMercancia(Inventario inventario, User user) {
        boolean continuar;
        do {
            clearScreen();
            printUserInfo(user);
            continuar = ActionHandler.printRecibirMercancia(inventario);
        } while (continuar);
    }

    private static void agregarProducto(Inventario inventario, User user) {
        clearScreen();
        printUserInfo(user);
        ActionHandler.printAgregarProducto(inventario);
    }

    private static void eliminarProducto(Inventario inventario, User user) {
        clearScreen();
        printUserInfo(user);
        ActionHandler.printEliminarProducto(inventario);
    }

    private static void accionNoValida() {
        System.out.println("La opción seleccionada no es valida");
        Scanner scanner = MyScanner.getInstance().getScanner();
        scanner.nextLine();
    }


}
