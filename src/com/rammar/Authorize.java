package com.rammar;

import com.rammar.interfaz.Helpers;
import com.rammar.interfaz.Menu;

import java.io.Console;
import java.util.Scanner;
import java.util.UUID;

public class Authorize {
    private static final User[] USUARIOS = new User[]
            {
                    new User(UUID.randomUUID().toString(), "Luis Fernando Ramirez", "fer@gmail.com", "12345", 'A'),
                    new User(UUID.randomUUID().toString(), "Maylu Ramirez", "may@gmail.com", "abcde", 'V'),
                    new User(UUID.randomUUID().toString(), "Fulanito Perez", "foo@gmail.com", "qwerty", 'V'),
            };
    private static final Scanner scan = MyScanner.getInstance().getScanner();
    private static final int MAX_TRIES = 3;  // Número de intentos máximo para intentar ingresar al sistema

    public static User validarUsuario() {
        int tries = 0;
        User user = new User();
        while (tries < MAX_TRIES) {
            Menu.printBienvenida();
            String email = preguntarPor("email", false);
            String password = preguntarPor("password", true);
            user = getUserValidado(email, password);
            if (user != null) {
                break;
            }
            if (tries < 2) {
                System.out.println("Usuario no valido... Presione Enter para intentar de nuevo");
            }

            if (tries == 2) {
                System.out.println("Máximo de intentos alcanzado... Presione Enter para cerrar el sistema");
                scan.nextLine();
                Menu.printGreetings();
            }
            scan.nextLine();
            Helpers.clearScreen();
            tries++;
        }
        return user;
    }

    public static User getValidUser() {
        return USUARIOS[0];
    }

    /**
     * Muestra un parrafo preguntando por el valor que se requiere, si el valor requerido es un campo
     * confidencial se puede ocultar con el parametro hide.
     *
     * @param valorRequerido Este es el etiqueta del valor que se solicita, ej: email, password, etc...
     * @param hide Indica si la consola debe ocultar lo que se esta escribiendo
     * @return retorna un String con lo que el usuario ingreso a la consola.
     */
    public static String preguntarPor(String valorRequerido, boolean hide) {
        String message = String.format("¿Cuál es tu %s ?: ", valorRequerido);
        if (!hide) {
            System.out.print(message);
            return scan.nextLine();
        } else {
            Console cons = System.console();
            String pass = "";
            if (cons != null) {
                pass = String.valueOf(cons.readPassword(message));
            } else {
                System.out.println("Console is NULL");
            }
            return String.valueOf(pass);
        }
    }

    public static User getUserValidado(String email, String password) {
        for (User user : USUARIOS) {
            if (user.validar(email, password)) {
                return user;
            }
        }
        return null;
    }
}
