package controlador;

import modelo.Proveedor;
import modelo.ProveedorDAO;
import vistas.VistaProveedor;
import java.sql.Connection;
import java.util.*;

public class ProveedorControlador {
    private ProveedorDAO dao;
    private VistaProveedor vista;

    public ProveedorControlador(Connection conn) {
        dao = new ProveedorDAO(conn);
        vista = new VistaProveedor();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n--- Gestión de Proveedores ---");
            System.out.println("1. Añadir proveedor");
            System.out.println("2. Ver proveedores");
            System.out.println("3. Editar proveedor");
            System.out.println("4. Eliminar proveedor");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> agregar();
                case 2 -> listar();
                case 3 -> editar();
                case 4 -> eliminar();
                case 0 -> vista.mensaje("Volviendo...");
                default -> vista.mensaje("Opción inválida");
            }
        } while (opcion != 0);
    }

    private void agregar() {
        try {
            Proveedor p = vista.pedirDatos();
            dao.agregar(p);
            vista.mensaje("Proveedor añadido correctamente.");
        } catch (Exception e) {
            vista.mensaje("Error al añadir proveedor: " + e.getMessage());
        }
    }

    private void listar() {
        try {
            List<Proveedor> lista = dao.listar();
            vista.mostrar(lista);
        } catch (Exception e) {
            vista.mensaje("Error al mostrar proveedores: " + e.getMessage());
        }
    }

    private void editar() {
        try {
            int id = vista.pedirId();
            Proveedor p = vista.pedirDatos();
            p.setId(id);
            dao.actualizar(p);
            vista.mensaje("Proveedor actualizado.");
        } catch (Exception e) {
            vista.mensaje("Error al actualizar proveedor: " + e.getMessage());
        }
    }

    private void eliminar() {
        try {
            int id = vista.pedirId();
            dao.eliminar(id);
            vista.mensaje("Proveedor eliminado.");
        } catch (Exception e) {
            vista.mensaje("Error al eliminar proveedor: " + e.getMessage());
        }
    }
}

