package vistas;

import modelo.Articulo;

import java.util.List;
import java.util.Scanner;

public class ArticuloVista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenuArticulo() {
        System.out.println("\n--- Gestión de Artículos ---");
        System.out.println("1. Listar Artículos");
        System.out.println("2. Agregar Artículo");
        System.out.println("3. Modificar Artículo");
        System.out.println("4. Eliminar Artículo");
        System.out.println("5. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarArticulos(List<Articulo> articulos) {
        System.out.println("\nLista de Artículos:");
        for (Articulo art : articulos) {
            System.out.println(art);
        }
    }

    public Articulo leerDatosArticulo() {
        Articulo articulo = new Articulo();
        System.out.print("Nombre: ");
        articulo.setNombre(scanner.nextLine());
        System.out.print("Precio unitario: ");
        articulo.setPrecio_unitario(Double.parseDouble(scanner.nextLine()));
        System.out.print("Stock: ");
        articulo.setStock(Integer.parseInt(scanner.nextLine()));
        return articulo;
    }

    public int leerIdArticulo() {
        System.out.print("Ingrese ID del artículo: ");
        return Integer.parseInt(scanner.nextLine());
    }
}

