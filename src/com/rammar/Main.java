package com.rammar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        boolean logout = false;
        do {
            User user = Authorize.validarUsuario();
            if (user == null) {
                return;
            }

            boolean continuar = true;
            while (continuar) {
                Actions action = Menu.printMainMenu(user);
                switch (action) {
                    case SALIR:
                        continuar = false;
                        break;
                    case CERRAR_SISTEMA:
                        continuar = false;
                        logout = true;
                        break;
                    default:
                        actionHandler(action);
                }
//                switch (Menu.printMainMenu(user)) {
//                    case COBRAR:
//                        break;
//                    case MOSTRAR_INVENTARIO:
//                        break;
//                    case RECIBIR_MERCANCIA:
//                        break;
//                    case AGREGAR_PRODUCTO:
//                        break;
//                    case ELIMINAR_PRODUCTO:
//                        break;
//                    case SALIR:
//                        break;
//                    case CERRAR_SISTEMA:
//                        showAction();
//                        break;
//                    default:
//                        continuar = false;
//                }
            }
        } while (!logout);
        Menu.greetings();
    }


    private static void actionHandler(Actions action) {
        Menu.clearScreen();
        System.out.printf("Acción para la opción %s", action);
        Scanner scanner = MyScanner.getInstance().getScanner();
        scanner.nextLine();
    }

}
