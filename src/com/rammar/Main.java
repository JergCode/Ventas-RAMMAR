package com.rammar;

import com.rammar.interfaz.Menu;

public class Main {

    public static void main(String[] args) {
        boolean logout = false;
        Inventario inventario = new Inventario();
        do {
            User user = Authorize.validarUsuario();
//            User user = Authorize.getValidUser();
            if (user == null) {
                // Esta validación hace que se salga del sistema si no se encontró ningún usuario
                return;
            }

        Menu menu = new Menu(user, inventario);
            boolean continuar = true;
            while (continuar) {
                Actions action = menu.printMainMenu();
                switch (action) {
                    case SALIR:
                        continuar = false;
                        break;
                    case CERRAR_SISTEMA:
                        continuar = false;
                        logout = true;
                        break;
                    default:
                        menu.actionHandler(action);
                }
            }
        } while (!logout);
        Menu.printGreetings();
    }

}
