package com.rammar.interfaz;

import com.rammar.Inventario;
import com.rammar.Producto;

public class ActionHandler {
    private static final int ID_SPACES = 5;
    private static final int COST_SPACES = 10;
    private static final int PRICE_SPACES = 10;
    private static final int STOCK_SPACES = 7;
    private static final int DESC_SPACES = Helpers.TABLE_WIDTH - ID_SPACES - COST_SPACES - PRICE_SPACES - STOCK_SPACES - 6;
    private final String TABLE_LINE_FORMAT = "| %-2s | %-91s |%n";
    private static final String tableFormat = "| %-" + (ID_SPACES - 1) + "s| %-" + (DESC_SPACES - 1) + "s" +
            "| %-" + (COST_SPACES - 1) + "s| %-" + (PRICE_SPACES - 1) + "s| %-" + (STOCK_SPACES - 1) + "s|%n";

    public static void printInventario(Inventario inventario) {
        tableTitles();
        for (Producto p : inventario.productos) {
            System.out.printf(tableFormat, p.getUid(), p.getDescription(), p.getCostStr(), p.getPriceStr(), p.getStock());
        }
        tableLine();
    }

    private static void tableLine() {
        String line = "+" + "-".repeat(ID_SPACES) +
                "+" + "-".repeat(DESC_SPACES) +
                "+" + "-".repeat(COST_SPACES) +
                "+" + "-".repeat(PRICE_SPACES) +
                "+" + "-".repeat(STOCK_SPACES) + "+";
        System.out.println(line);
    }

    private static void tableTitles() {
        tableLine();
        System.out.printf(tableFormat, "ID", "PRODUCTO", "COSTO", "PRECIO", "STOCK");
        tableLine();
    }


}
