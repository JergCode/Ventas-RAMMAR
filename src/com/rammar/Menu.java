package com.rammar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static final Scanner scan = MyScanner.getInstance().getScanner();
    private static final int TABLE_WIDTH = 60;
    private static final String TITLE_FORMAT = "|%s|%n";
    private static final String LEFT_ALIGN_FORMAT = "| %-56s |%n";
    private static final String OPTIONS_LINE_FORMAT = "| %-2s | %-51s |%n";

    public static void printBienvenida() {
        clearScreen();
        squareMessage("BIENVENIDO A VENTAS FER");
        System.out.println();
    }

    public static int printMainMenu(User user) {
        Integer option;
        do {
            clearScreen();
            printUserInfo(user);
            squareMessage("MENU PRINCIPAL");
            printMenuOptions(user.actions());
            option = getInput();
        } while (option == null);
        return option;
    }

    private static void printUserInfo(User user) {
        String name = "Nombre: " + user.getNombre();
        String role = "Categoría: " + user.getTipo();
        squareMessage("USUARIO");
        System.out.printf(LEFT_ALIGN_FORMAT, name);
        System.out.printf(LEFT_ALIGN_FORMAT, role);

    }

    private static void printMenuOptions(Actions[] options) {
        for (Actions option : options) {
            System.out.printf(OPTIONS_LINE_FORMAT, option.getCode(), option.getDescription());
        }
        line();
    }

    private static Integer getInput() {
        Integer option = null;
        try {
            System.out.println();
            System.out.print("Selecciona una opción: ");
            option = scan.nextInt();
            return option;
        } catch (InputMismatchException ex) {
            System.out.println();
            System.out.println("Opción no valida, intente de nuevo...");
        }
        scan.nextLine();
        return option;
    }

    private static void squareMessage(String message) {
        line();
        System.out.printf(TITLE_FORMAT, centerMessage(message));
        line();
    }

    private static String centerMessage(String message) {
        StringBuilder centeredMessage = new StringBuilder(message);
        int padRight = (TABLE_WIDTH / 2) - (message.length() / 2) - 1;
        int padLeft = message.length() % 2 == 0 ? padRight : padRight - 1;
        centeredMessage.insert(0, " ".repeat(padLeft));
        centeredMessage.append(" ".repeat(padRight));
        return centeredMessage.toString();
    }


    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println("No se pudo limpiar la pantalla");
        }
    }

    public static void greetings() {
        clearScreen();
        squareMessage("Gracias por usar VentasFer!!!");
    }

    private static void line() {
        System.out.println("+----------------------------------------------------------+");
    }
}

