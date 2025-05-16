package modelo;

import java.sql.*;
import java.util.*;

public class ClienteDAO {

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/javapooSL", "root", "1234");
    }

    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO Clientes (nombre, email, telefono) VALUES (?, ?, ?)";
        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al añadir cliente: " + e.getMessage());
        }
    }

    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Connection con = conectar(); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"));
                clientes.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener clientes: " + e.getMessage());
        }
        return clientes;
    }

    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM Clientes WHERE id_cliente = ?";
        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("email"), rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar cliente por ID: " + e.getMessage());
        }
        return null;
    }

    public void actualizar(Cliente cliente) {
        String sql = "UPDATE Clientes SET nombre = ?, email = ?, telefono = ? WHERE id_cliente = ?";
        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, cliente.getId());
            ps.executeUpdate();
            System.out.println("Cliente actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Clientes WHERE id_cliente = ?";
        try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cliente eliminado correctamente.");
                return true;
            } else {
                System.out.println("No se encontró un cliente con ese ID.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
}

