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
                switch (Menu.printMainMenu(user)) {
                    case 1:
                        showAction(1);
                        break;
                    case 2:
                        showAction(2);
                        break;
                    case 3:
                        showAction(3);
                        break;
                    default:
                        continuar = false;
                }
            }
        } while (!logout);
        Menu.greetings();
    }


    private static void showAction(int option) {
        Menu.clearScreen();
        System.out.printf("Acción para la opción %d", option);
        Scanner scanner = MyScanner.getInstance().getScanner();
        scanner.nextLine();
    }

}
