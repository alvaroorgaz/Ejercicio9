package controlador;

import modelo.Articulo;
import modelo.ArticuloDAO;
import vistas.ArticuloVista;
import java.sql.Connection;
import java.util.List;

public class ArticuloControlador {
    private ArticuloDAO modelo;
    private ArticuloVista vista;

    public ArticuloControlador(Connection conexion) {
        this.modelo = new ArticuloDAO(conexion);
        this.vista = new ArticuloVista();
    }

    public void ejecutar() {
        boolean salir = false;
        while (!salir) {
            vista.mostrarMenuArticulo();
            int opcion = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
            switch (opcion) {
                case 1:
                    List<Articulo> articulos = modelo.listarArticulos();
                    vista.mostrarArticulos(articulos);
                    break;
                case 2:
                    Articulo nuevo = vista.leerDatosArticulo();
                    if (modelo.insertarArticulo(nuevo)) {
                        System.out.println("Artículo agregado correctamente.");
                    } else {
                        System.out.println("Error al agregar el artículo.");
                    }
                    break;
                case 3:
                    int idActualizar = vista.leerIdArticulo();
                    Articulo articuloExistente = modelo.buscarArticuloPorId(idActualizar);
                    if (articuloExistente != null) {
                        Articulo datosActualizados = vista.leerDatosArticulo();
                        datosActualizados.setId_articulo(idActualizar);
                        if (modelo.actualizarArticulo(datosActualizados)) {
                            System.out.println("Artículo actualizado correctamente.");
                        } else {
                            System.out.println("Error al actualizar el artículo.");
                        }
                    } else {
                        System.out.println("Artículo no encontrado.");
                    }
                    break;
                case 4:
                    int idEliminar = vista.leerIdArticulo();
                    if (modelo.eliminarArticulo(idEliminar)) {
                        System.out.println("Artículo eliminado correctamente.");
                    } else {
                        System.out.println("Error al eliminar el artículo.");
                    }
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }}
