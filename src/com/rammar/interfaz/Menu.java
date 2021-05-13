package com.rammar.interfaz;

import com.rammar.Actions;
import com.rammar.Inventario;
import com.rammar.PerformMenuOptions;
import com.rammar.User;
import static com.rammar.interfaz.Helpers.*;

public class Menu {
    private final Inventario inventario;
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

    private void printMenuOptions(Actions[] options) {
        for (Actions option : options) {
            String OPTIONS_LINE_FORMAT = "| %-2s | %-91s |%n";
            System.out.printf(OPTIONS_LINE_FORMAT, option.getCode(), option.getDescription());
        }
        printLine();
    }

    public static void printGreetings() {
        clearScreen();
        printTitleMessage("Gracias por usar VentasFer!!!");
    }

    public Actions printMainMenu() {
        Actions action;
        do {
            clearScreen();
            printUserInfo(user);
            printTitleMessage("MENU PRINCIPAL");
            printMenuOptions(user.actions());
            Character option = InputHandlers.getInput();
            action = Actions.parseAction(option);
        } while (action == null);

        return action;
    }

    public void actionHandler(Actions action) {
        PerformMenuOptions.actionHandler(action, inventario, user);
        InputHandlers.waitForEnter();
    }
}

