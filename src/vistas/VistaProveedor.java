package vistas;

import modelo.Proveedor;
import java.util.*;
import java.util.Scanner;

public class VistaProveedor {
    private Scanner sc = new Scanner(System.in);

    public Proveedor pedirDatos() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("CIF: ");
        String cif = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        return new Proveedor(0, nombre, cif, telefono);
    }

    public int pedirId() {
        System.out.print("ID del proveedor: ");
        return Integer.parseInt(sc.nextLine());
    }

    public void mostrar(List<Proveedor> lista) {
        for (Proveedor p : lista) {
            System.out.println("ID: " + p.getId() + " | Nombre: " + p.getNombre() + " | CIF: " + p.getCif() + " | Teléfono: " + p.getTelefono());
        }
    }

    public void mensaje(String msg) {
        System.out.println(msg);
    }
}