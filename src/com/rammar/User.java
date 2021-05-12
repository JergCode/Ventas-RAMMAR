package com.rammar;

public class User {
    private String id;
    private String nombre;
    private String email;
    private String password;
    private char tipo;

    public User() {
    }

    public User(String id, String nombre, String email, String password, char tipo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }

    public Actions[] actions() {
        switch (tipo) {
            case 'V':
                return new Actions[]{Actions.COBRAR, Actions.MOSTRAR_INVENTARIO, Actions.RECIBIR_MERCANCIA, Actions.SALIR, Actions.CERRAR_SISTEMA};
            case 'A':
                return new Actions[]{Actions.COBRAR, Actions.MOSTRAR_INVENTARIO, Actions.RECIBIR_MERCANCIA, Actions.ELIMINAR_PRODUCTO, Actions.AGREGAR_PRODUCTO, Actions.SALIR, Actions.CERRAR_SISTEMA};
        }
        return new Actions[]{};
    }

    public boolean validar(String email, String password) {
        return (getEmail().equals(email) && getPassword().equals(password));
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTipo() {
        switch (tipo) {
            case 'V':
                return "Vendedor";
            case 'A':
                return "Administrador";
            default:
                return "Categoría no valida";
        }
    }
}
