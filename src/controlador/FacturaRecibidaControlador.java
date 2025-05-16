package controlador;

import modelo.FacturaRecibida;
import modelo.FacturaRecibidaDAO;
import vistas.FacturaRecibidaVista;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class FacturaRecibidaControlador {
    private FacturaRecibidaDAO modelo;
    private FacturaRecibidaVista vista;

    public FacturaRecibidaControlador(Connection conexion) {
        this.modelo = new FacturaRecibidaDAO(conexion);
        this.vista = new FacturaRecibidaVista();
    }

    public void ejecutar() {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        while (!salir) {
            vista.mostrarMenuFactura();
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    List<FacturaRecibida> facturas = modelo.listarFacturas();
                    vista.mostrarFacturas(facturas);
                    break;
                case 2:
                    FacturaRecibida nueva = vista.leerDatosFactura();
                    if (modelo.insertarFactura(nueva)) {
                        System.out.println("Factura insertada correctamente.");
                    } else {
                        System.out.println("Error al insertar la factura.");
                    }
                    break;
                case 3:
                    FacturaRecibida actualizada = vista.leerDatosFacturaActualizar();
                    if (modelo.actualizarFactura(actualizada)) {
                        System.out.println("Factura actualizada correctamente.");
                    } else {
                        System.out.println("Error al actualizar la factura.");
                    }
                    break;
                case 4:
                    int idEliminar = vista.leerIdFacturaEliminar();
                    if (modelo.eliminarFactura(idEliminar)) {
                        System.out.println("Factura eliminada correctamente.");
                    } else {
                        System.out.println("Error al eliminar la factura.");
                    }
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
