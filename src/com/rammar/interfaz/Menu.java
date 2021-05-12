package com.rammar.interfaz;

import com.rammar.Actions;
import com.rammar.Inventario;
import com.rammar.PerformMenuOptions;
import com.rammar.User;
import static com.rammar.interfaz.Helpers.*;

public class Menu {
    private final Inventario inventario;
    private final String LEFT_ALIGN_FORMAT = "| %-96s |%n";
    private final String OPTIONS_LINE_FORMAT = "| %-2s | %-91s |%n";
    private final User user;

    public Menu(User user, Inventario inventario) {
        this.user = user;
        this.inventario = inventario;
    }

    public static void printBienvenida() {
        clearScreen();
        printTitleMessage("BIENVENIDO A VENTAS FER");
        System.out.println();
    }

    private void printUserInfo() {
        String name = "Nombre: " + user.getNombre();
        String role = "Categoría: " + user.getTipo();
        printTitleMessage("USUARIO");
        System.out.printf(LEFT_ALIGN_FORMAT, name);
        System.out.printf(LEFT_ALIGN_FORMAT, role);
    }

    private void printMenuOptions(Actions[] options) {
        for (Actions option : options) {
            System.out.printf(OPTIONS_LINE_FORMAT, option.getCode(), option.getDescription());
        }
        printLine();
    }

    public static void printGreetings() {
        clearScreen();
        printTitleMessage("Gracias por usar VentasFer!!!");
    }

    public Actions printMainMenu() {
        Actions action = null;
        do {
            clearScreen();
            printUserInfo();
            printTitleMessage("MENU PRINCIPAL");
            printMenuOptions(user.actions());
            Character option = InputHandlers.getInput();
            action = Actions.parseAction(option);
        } while (action == null);

        return action;
    }

    public void actionHandler(Actions action) {
        clearScreen();
        printUserInfo();
        PerformMenuOptions.actionHandler(action, inventario);
        InputHandlers.waitForEnter();
    }
}

