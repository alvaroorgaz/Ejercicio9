package vistas;

import modelo.Venta;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class VentaVista {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenuVenta() {
        System.out.println("\n--- Gestión de Ventas ---");
        System.out.println("1. Listar ventas");
        System.out.println("2. Insertar nueva venta");
        System.out.println("3. Actualizar venta");
        System.out.println("4. Eliminar venta");
        System.out.println("5. Volver al menú principal");
        System.out.print("Seleccione opción: ");
    }

    public void mostrarVentas(List<Venta> ventas) {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }
        System.out.println("\nListado de ventas:");
        for (Venta v : ventas) {
            System.out.printf("ID: %d | Cliente ID: %d | Fecha: %s | Total: %.2f\n",
                v.getIdVenta(), v.getIdCliente(), v.getFecha().toString(), v.getTotal());
        }
    }

    public Venta leerDatosVenta() {
        System.out.print("ID cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());
        System.out.print("Fecha (aaaa-mm-dd): ");
        Date fecha = Date.valueOf(sc.nextLine());
        System.out.print("Total: ");
        double total = Double.parseDouble(sc.nextLine());
        return new Venta(0, idCliente, fecha, total);
    }

    public Venta leerDatosVentaActualizar() {
        System.out.print("Ingrese ID de la venta a actualizar: ");
        int idVenta = Integer.parseInt(sc.nextLine());
        System.out.print("ID cliente: ");
        int idCliente = Integer.parseInt(sc.nextLine());
        System.out.print("Fecha (aaaa-mm-dd): ");
        Date fecha = Date.valueOf(sc.nextLine());
        System.out.print("Total: ");
        double total = Double.parseDouble(sc.nextLine());
        return new Venta(idVenta, idCliente, fecha, total);
    }

    public int leerIdVentaEliminar() {
        System.out.print("Ingrese ID de la venta a eliminar: ");
        return Integer.parseInt(sc.nextLine());
    }
}

