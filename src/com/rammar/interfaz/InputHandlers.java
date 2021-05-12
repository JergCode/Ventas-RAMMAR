package com.rammar.interfaz;

import com.rammar.MyScanner;

import java.util.Scanner;

public class InputHandlers {
    private static final Scanner scan = MyScanner.getInstance().getScanner();

    public static Character getInput() {
        char option;
        System.out.println();
        System.out.print("Selecciona una opción: ");
        option = scan.next().charAt(0);
        scan.nextLine();
        return Character.toUpperCase(option);
    }

    public static void waitForEnter() {
        scan.nextLine();
    }


}
