package vistas;

import modelo.FacturaRecibida;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class FacturaRecibidaVista {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenuFactura() {
        System.out.println("\n--- Gestión de Facturas Recibidas ---");
        System.out.println("1. Listar facturas");
        System.out.println("2. Insertar nueva factura");
        System.out.println("3. Actualizar factura");
        System.out.println("4. Eliminar factura");
        System.out.println("5. Volver al menú principal");
        System.out.print("Seleccione opción: ");
    }

    public void mostrarFacturas(List<FacturaRecibida> facturas) {
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas registradas.");
            return;
        }
        System.out.println("\nListado de facturas recibidas:");
        for (FacturaRecibida f : facturas) {
            System.out.printf("ID: %d | Proveedor ID: %d | Fecha: %s | Total: %.2f\n",
                f.getIdFactura(), f.getIdProveedor(), f.getFecha().toString(), f.getTotal());
        }
    }

    public FacturaRecibida leerDatosFactura() {
        System.out.print("ID proveedor: ");
        int idProveedor = Integer.parseInt(sc.nextLine());
        System.out.print("Fecha (aaaa-mm-dd): ");
        Date fecha = Date.valueOf(sc.nextLine());
        System.out.print("Total: ");
        double total = Double.parseDouble(sc.nextLine());
        return new FacturaRecibida(0, idProveedor, fecha, total);
    }

    public FacturaRecibida leerDatosFacturaActualizar() {
        System.out.print("Ingrese ID de la factura a actualizar: ");
        int idFactura = Integer.parseInt(sc.nextLine());
        System.out.print("ID proveedor: ");
        int idProveedor = Integer.parseInt(sc.nextLine());
        System.out.print("Fecha (aaaa-mm-dd): ");
        Date fecha = Date.valueOf(sc.nextLine());
        System.out.print("Total: ");
        double total = Double.parseDouble(sc.nextLine());
        return new FacturaRecibida(idFactura, idProveedor, fecha, total);
    }

    public int leerIdFacturaEliminar() {
        System.out.print("Ingrese ID de la factura a eliminar: ");
        return Integer.parseInt(sc.nextLine());
    }
}

