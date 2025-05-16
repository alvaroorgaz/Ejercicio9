package vistas;

import controlador.ClienteControlador;
import controlador.FacturaRecibidaControlador;
import controlador.ProveedorControlador;
import controlador.ArticuloControlador;
import controlador.VentaControlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class MenuPrincipal {

    public void mostrar() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javapooSL", "root", "1234");

            ClienteControlador clienteControlador = new ClienteControlador();
            ProveedorControlador proveedorControlador = new ProveedorControlador(conn);
            ArticuloControlador articuloControlador = new ArticuloControlador(conn);
            FacturaRecibidaControlador facturaControlador = new FacturaRecibidaControlador(conn);
            VentaControlador ventaControlador = new VentaControlador(conn, null, null); // Instancia del controlador de ventas

            Scanner sc = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Gestión de Clientes");
                System.out.println("2. Gestión de Proveedores");
                System.out.println("3. Gestión de Artículos");
                System.out.println("4. Gestión de Facturas Recibidas");
                System.out.println("5. Gestión de Ventas");
                System.out.println("6. Informes de Ventas por Cliente");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> clienteControlador.gestionar();
                    case 2 -> proveedorControlador.menu();
                    case 3 -> articuloControlador.ejecutar();
                    case 4 -> facturaControlador.ejecutar();
                    case 5 -> ventaControlador.ejecutar(); // Llamada al controlador de ventas
                    case 6 -> System.out.println(">> Generando informe de ventas por cliente...");
                    case 0 -> System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }

            } while (opcion != 0);

        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}




