package com.rammar.interfaz;

import com.rammar.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import static com.rammar.interfaz.Helpers.*;

public class ActionHandler {

    private static final Scanner scan = MyScanner.getInstance().getScanner();

    public static void cobrar(Inventario inventario, User user) {
        Venta venta = RegistroVentas.nuevaVenta();
        while (true) {
            List<ProductoVenta> productos = venta.getProductos();
            clearScreen();
            printUserInfo(user);
            printSalesTableTitles();
            for (ProductoVenta p : productos) {
                System.out.printf(SALES_TABLE_FORMAT, p.getId(), p.getDescription(), p.getQuantity(), p.getTotalStr());
            }
            printTotal(venta.getTotalStr());
            System.out.println();
            System.out.print("Ingrese el código del producto (0 para cobrar): ");
            int code = scan.nextInt();
            scan.nextLine();
            if (code == 0) {
                break;
            }
            ProductoInventario pi = inventario.getProducto(code);
            if (pi == null) {
                System.out.println("El código ingresado no esta en el inventario.");
                continue;
            }

            System.out.printf("Cantidad a vender de %s: ", pi.getDescription());
            int cantidad = scan.nextInt();
            scan.nextLine();

            ProductoVenta pv = new ProductoVenta(pi, cantidad);
            pi.subtractStock(cantidad);
            venta.agregarProducto(pv);
        }
        cobrarVenta(venta);
    }

    private static void cobrarVenta(Venta venta) {
        DecimalFormat df = new DecimalFormat("0.00");
        double saldoPendiente = venta.getTotal();
        while (true) {
            System.out.print("Desea pagar con (T)arjeta o (E)fectivo: ");
            char tipoPago = scan.next().charAt(0);
            scan.nextLine();
            if (Character.toUpperCase(tipoPago) == 'T') {
                try {
                    System.out.printf("Cobrando $%s%n", df.format(saldoPendiente));
                    System.out.println("Validando tarjeta...");
                    Thread.sleep(3000);
                    System.out.println("Gracias por su pago.");
                    break;
                } catch (Exception ignored) {
                }
            } else if (Character.toUpperCase(tipoPago) == 'E') {
                System.out.print("Ingrese el monto entregado por el cliente: ");
                double efectivo = scan.nextDouble();
                scan.nextLine();
                saldoPendiente -= efectivo;
                if (saldoPendiente > 0) {
                    System.out.printf("%nAún queda pendiente %s%n%n", df.format(-saldoPendiente));
                } else if (saldoPendiente == 0) {
                    System.out.println("Gracias por su pago.");
                    break;
                } else {
                    System.out.printf("El cambio a regresar es de: $%s", df.format(-saldoPendiente));
                    System.out.println("Gracias por su pago.");
                    break;
                }
            }

        }
    }

    public static void printInventario(Inventario inventario) {
        printTableTitles();
        for (ProductoInventario p : inventario.productos) {
            System.out.printf(TABLE_FORMAT, p.getId(), p.getDescription(), p.getCostStr(), p.getPriceStr(), p.getStock());
        }
        printTableLine();
    }

    public static boolean printRecibirMercancia(Inventario inventario) {
        printLine();
        System.out.print("¿Cuál es el ID del producto que se recibe (0 para terminar)? ");
        int id = scan.nextInt();
        if (id == 0) {
            return false;
        }

        System.out.print("¿Cuantos productos se recibieron? ");
        int cantidad = scan.nextInt();
        scan.nextLine();
        ProductoInventario p = inventario.agregarStock(id, cantidad);
        if (p == null) {
            System.out.println("No se encontró el producto ");
        } else {
            System.out.printf("%n%nSe agregaron al inventario %d %s quedando en stock: %n", cantidad, p.getDescription());
            printTableTitles();
            System.out.printf(TABLE_FORMAT, p.getId(), p.getDescription(), p.getCostStr(), p.getPriceStr(), p.getStock());
            printTableLine();
        }
        return true;

    }

    public static void printAgregarProducto(Inventario inventario) {
        printLine();
        // TODO: Falta validar los inputs
        System.out.print("¿Cuál es la descripción del producto? ");
        String desc = scan.nextLine();
        System.out.print("¿Cuál es el costo del producto? ");
        Double costo = scan.nextDouble();
        System.out.print("¿Cuál es el porcentaje (en entero) de ganancia para este producto? ");
        Integer porcentaje = scan.nextInt();
        System.out.print("¿Cuántos productos de estos se tendrán en el stock inicial? ");
        Integer stock = scan.nextInt();
        scan.nextLine();
        ProductoInventario newProducto = new ProductoInventario(desc, costo, porcentaje, stock);
        if (inventario.addNewProduct(newProducto)) {
            System.out.printf("%n%nSe agregó al inventario el siguiente producto: %n");
            printTableTitles();
            System.out.printf(TABLE_FORMAT, newProducto.getId(), newProducto.getDescription(), newProducto.getCostStr(), newProducto.getPriceStr(), newProducto.getStock());
            printTableLine();
        } else {
            printTableLine();
            System.out.printf("%n%nNo se pudo agregar el nuevo producto...");
        }
    }

    public static boolean printEliminarProducto(Inventario inventario) {
        printTitleMessage("ALERTA: EL SIGUIENTE PRODUCTO SERA ELIMINADO DEL STOCK");
        printLine();
        System.out.println();
        System.out.print("¿Cuál es el ID del producto que desea eliminar (0 para cancelar acción)? ");
        int id = scan.nextInt();
        scan.nextLine();
        if (id == 0) {
            System.out.println("NO SE ELIMINO NINGUN PRODUCTO DEL INVENTARIO");
            return true;
        }

        ProductoInventario p = inventario.getProducto(id);
        if (p == null) {
            System.out.println("ID no encontrado en el inventario... Favor de revisar el ID.");
            return false;
        }

        if (inventario.deleteProduct(p)) {
            System.out.printf("%n%nSe eliminó del inventario producto: %n");
            printTableTitles();
            System.out.printf(TABLE_FORMAT, p.getId(), p.getDescription(), p.getCostStr(), p.getPriceStr(), p.getStock());
            printTableLine();
        } else {
            printTableLine();
            System.out.printf("%n%nNo se pudo eliminar el nuevo producto deseado...");
        }
        return true;
    }
}
