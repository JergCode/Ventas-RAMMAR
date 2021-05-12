package com.rammar;

public enum Actions {
    COBRAR('C', "(C)obrar"),
    MOSTRAR_INVENTARIO('I', "Mostrar (I)nventario"),
    RECIBIR_MERCANCIA('R', "(R)ecibir Mercancía"),
    ELIMINAR_PRODUCTO('E', "(E)liminar Producto"),
    AGREGAR_PRODUCTO('A', "(A)gregar Producto"),
    SALIR('S', "(S)alir"),
    CERRAR_SISTEMA('0', "Cerrar el Sistema");

    private final char code;
    private final String description;

    Actions(char code, String description) {
        this.code = code;
        this.description = description;
    }

    public char getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Actions parseAction(Character code) {
        for (Actions action : Actions.values()) {
            if (action.getCode() == code) {
                return action;
            }
        }
        return null;
    }
}
