package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaRecibidaDAO {
    private Connection conn;

    public FacturaRecibidaDAO(Connection conn) {
        this.conn = conn;
    }

    public List<FacturaRecibida> listarFacturas() {
        List<FacturaRecibida> facturas = new ArrayList<>();
        String sql = "SELECT * FROM Facturas_Recibidas";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                FacturaRecibida f = new FacturaRecibida(
                    rs.getInt("id_factura"),
                    rs.getInt("id_proveedor"),
                    rs.getDate("fecha"),
                    rs.getDouble("total")
                );
                facturas.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar facturas recibidas: " + e.getMessage());
        }
        return facturas;
    }

    public boolean insertarFactura(FacturaRecibida factura) {
        String sql = "INSERT INTO Facturas_Recibidas (id_proveedor, fecha, total) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, factura.getIdProveedor());
            ps.setDate(2, factura.getFecha());
            ps.setDouble(3, factura.getTotal());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar factura: " + e.getMessage());
            return false;
        }
    }

    public FacturaRecibida buscarPorId(int id) {
        String sql = "SELECT * FROM Facturas_Recibidas WHERE id_factura = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new FacturaRecibida(
                    rs.getInt("id_factura"),
                    rs.getInt("id_proveedor"),
                    rs.getDate("fecha"),
                    rs.getDouble("total")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar factura por ID: " + e.getMessage());
        }
        return null;
    }

    public boolean actualizarFactura(FacturaRecibida factura) {
        String sql = "UPDATE Facturas_Recibidas SET id_proveedor = ?, fecha = ?, total = ? WHERE id_factura = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, factura.getIdProveedor());
            ps.setDate(2, factura.getFecha());
            ps.setDouble(3, factura.getTotal());
            ps.setInt(4, factura.getIdFactura());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar factura: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarFactura(int id) {
        String sql = "DELETE FROM Facturas_Recibidas WHERE id_factura = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar factura: " + e.getMessage());
            return false;
        }
    }
}
