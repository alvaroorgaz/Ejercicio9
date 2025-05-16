package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {
    private Connection conn;
	private VentaDAO modelo;

    public VentaDAO(Connection conn) {
    	this.modelo = new VentaDAO(conn);
    }

    public List<Venta> listarVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM Ventas";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Venta v = new Venta(
                    rs.getInt("id_venta"),
                    rs.getInt("id_cliente"),
                    rs.getDate("fecha"),
                    rs.getDouble("total")
                );
                ventas.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar ventas: " + e.getMessage());
        }
        return ventas;
    }

    public boolean insertarVenta(Venta venta) {
        String sql = "INSERT INTO Ventas (id_cliente, fecha, total) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdCliente());
            ps.setDate(2, venta.getFecha());
            ps.setDouble(3, venta.getTotal());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar venta: " + e.getMessage());
            return false;
        }
    }

    public Venta buscarPorId(int id) {
        String sql = "SELECT * FROM Ventas WHERE id_venta = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Venta(
                    rs.getInt("id_venta"),
                    rs.getInt("id_cliente"),
                    rs.getDate("fecha"),
                    rs.getDouble("total")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar venta por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizarVenta(Venta venta) {
        String sql = "UPDATE Ventas SET id_cliente = ?, fecha = ?, total = ? WHERE id_venta = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, venta.getIdCliente());
            ps.setDate(2, venta.getFecha());
            ps.setDouble(3, venta.getTotal());
            ps.setInt(4, venta.getIdVenta());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar venta: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarVenta(int id) {
        String sql = "DELETE FROM Ventas WHERE id_venta = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar venta: " + e.getMessage());
            return false;
        }
    }
}

