package controlador;

import controlador.VentaControlador;
import modelo.Venta;
import modelo.VentaDAO;
import vistas.VentaVista;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;


// Clase VentaControlador


public class VentaControlador {
    private VentaDAO modelo;
    private VentaVista vista;

    public VentaControlador(Connection conexion, VentaDAO ventaDAO, VentaVista ventaVista) {
        this.modelo = ventaDAO;
        this.vista = new VentaVista();

    }

    public void ejecutar() {
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        while (!salir) {
            vista.mostrarMenuVenta();
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    List<Venta> ventas = modelo.listarVentas();
                    vista.mostrarVentas(ventas);
                    break;
                case 2:
                    Venta nueva = vista.leerDatosVenta();
                    if (modelo.insertarVenta(nueva)) {
                        System.out.println("Venta insertada correctamente.");
                    } else {
                        System.out.println("Error al insertar la venta.");
                    }
                    break;
                case 3:
                    Venta actualizada = vista.leerDatosVentaActualizar();
                    if (modelo.actualizarVenta(actualizada)) {
                        System.out.println("Venta actualizada correctamente.");
                    } else {
                        System.out.println("Error al actualizar la venta.");
                    }
                    break;
                case 4:
                    int idEliminar = vista.leerIdVentaEliminar();
                    if (modelo.eliminarVenta(idEliminar)) {
                        System.out.println("Venta eliminada correctamente.");
                    } else {
                        System.out.println("Error al eliminar la venta.");
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
