package controlador;

import modelo.Cliente;
import modelo.ClienteDAO;
import vistas.ClienteVista;

import java.util.List;
import java.util.Scanner;

public class ClienteControlador {
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ClienteVista vista = new ClienteVista();
    private Scanner sc = new Scanner(System.in);

    public void gestionar() {
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    editarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    private void crearCliente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Cliente c = new Cliente(nombre, email, telefono);
        clienteDAO.insertar(c); // Inserta al cliente en la base de datos
        System.out.println("Cliente añadido correctamente.");  
    }

    
    
    private void listarClientes() {
        List<Cliente> lista = clienteDAO.obtenerTodos();
        vista.mostrarClientes(lista);
    }
    

    private void editarCliente() {
        System.out.print("ID del cliente a modificar: ");
        int id = sc.nextInt(); sc.nextLine();
        Cliente existente = clienteDAO.buscarPorId(id);
        if (existente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo email: ");
        String email = sc.nextLine();
        System.out.print("Nuevo teléfono: ");
        String telefono = sc.nextLine();

        existente.setNombre(nombre);
        existente.setEmail(email);
        existente.setTelefono(telefono);
        clienteDAO.actualizar(existente);
        System.out.println("Cliente actualizado correctamente.");
    }

    private void eliminarCliente() {
        System.out.print("ID del cliente a eliminar: ");
        int id = sc.nextInt(); sc.nextLine();
        boolean eliminado = clienteDAO.eliminar(id);
        if (eliminado) {
        } else {
            System.out.println("No se pudo eliminar el cliente.");
        }
    }}

