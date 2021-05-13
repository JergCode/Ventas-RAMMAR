package com.rammar.interfaz;

import com.rammar.User;

public class Helpers {
    public static final int TABLE_WIDTH = 100;
    private static final String TITLE_FORMAT = "|%s|%n";
    private static final String LEFT_ALIGN_FORMAT = "| %-96s |%n";
    private static final int ID_SPACES = 5;
    private static final int COST_SPACES = 10;
    private static final int PRICE_SPACES = 10;
    private static final int STOCK_SPACES = 7;
    private static final int QUANTITY_SPACES = 10;
    private static final int DESC_SPACES = TABLE_WIDTH - ID_SPACES - COST_SPACES - PRICE_SPACES - STOCK_SPACES - 6;
    private static final int DESC_VENTA_SPACES = TABLE_WIDTH - ID_SPACES - QUANTITY_SPACES - PRICE_SPACES - 5;
    private final String TABLE_LINE_FORMAT = "| %-2s | %-91s |%n";
    public static final String TABLE_FORMAT = "| %-" + (ID_SPACES - 1) + "s| %-" + (DESC_SPACES - 1) + "s" +
            "| %-" + (COST_SPACES - 1) + "s| %-" + (PRICE_SPACES - 1) + "s| %-" + (STOCK_SPACES - 1) + "s|%n";
    public static final String SALES_TABLE_FORMAT = "| %-" + (ID_SPACES - 1) + "s| %-" + (DESC_VENTA_SPACES - 1) +
            "s| %-" + (QUANTITY_SPACES - 1) + "s| %-" + (PRICE_SPACES - 1) + "s|%n";

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

    private static String centerMessage(String message) {
        StringBuilder centeredMessage = new StringBuilder(message);
        int padRight = (TABLE_WIDTH / 2) - (message.length() / 2) - 1;
        int padLeft = message.length() % 2 == 0 ? padRight : padRight - 1;
        centeredMessage.insert(0, " ".repeat(padLeft));
        centeredMessage.append(" ".repeat(padRight));
        return centeredMessage.toString();
    }

    public static void printTitleMessage(String message) {
        printLine();
        System.out.printf(TITLE_FORMAT, centerMessage(message));
        printLine();
    }

    public static void printLine() {
        String line = "+" + "-".repeat(TABLE_WIDTH - 2) + "+";
        System.out.println(line);
    }

    public static void printTableLine() {
        String line = "+" + "-".repeat(ID_SPACES) +
                "+" + "-".repeat(DESC_SPACES) +
                "+" + "-".repeat(COST_SPACES) +
                "+" + "-".repeat(PRICE_SPACES) +
                "+" + "-".repeat(STOCK_SPACES) + "+";
        System.out.println(line);
    }

    public static void printTableTitles() {
        printTableLine();
        System.out.printf(TABLE_FORMAT, "ID", "PRODUCTO", "COSTO", "PRECIO", "STOCK");
        printTableLine();
    }

    public static void printSalesTableLine() {
        String line = "+" + "-".repeat(ID_SPACES) +
                "+" + "-".repeat(DESC_VENTA_SPACES) +
                "+" + "-".repeat(QUANTITY_SPACES) +
                "+" + "-".repeat(PRICE_SPACES) + "+";
        System.out.println(line);
    }

    public static void printSalesTableTitles() {
        printSalesTableLine();
        System.out.printf(SALES_TABLE_FORMAT, "ID", "PRODUCTO", "CANTIDAD", "PRECIO");
        printSalesTableLine();
    }

    public static void printTotal(String total) {
        int spaces = TABLE_WIDTH - PRICE_SPACES - 4;
        final String format = "|%" + (spaces) + "s | $%-" + (PRICE_SPACES - 2) + "s|%n";
        printSalesTableLine();
        System.out.printf(format, "TOTAL", total);
        printSalesTableLine();
    }

    public static void printUserInfo(User user) {
        String name = "Nombre: " + user.getNombre();
        String role = "Categoría: " + user.getTipo();
        printTitleMessage("USUARIO");
        System.out.printf(LEFT_ALIGN_FORMAT, name);
        System.out.printf(LEFT_ALIGN_FORMAT, role);
    }

}
