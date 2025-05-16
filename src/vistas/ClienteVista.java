package vistas;

import modelo.Cliente;
import java.util.List;

public class ClienteVista {

    public void mostrarMenu() {
        System.out.println("\n--- Gestión de Clientes ---");
        System.out.println("1. Crear cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Editar cliente");
        System.out.println("4. Eliminar cliente");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
    }

    public void mostrarClientes(List<Cliente> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente c : lista) {
            System.out.println("ID: " + c.getId()
                             + " | Nombre: " + c.getNombre()
                             + " | Email: " + c.getEmail()
                             + " | Teléfono: " + c.getTelefono());
        }
    }
}
