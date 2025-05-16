package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private Connection conn;

    public ProveedorDAO(Connection conn) {
        this.conn = conn;
    }

    public void agregar(Proveedor p) throws SQLException {
        String sql = "INSERT INTO Proveedores (nombre, cif, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCif());
            ps.setString(3, p.getTelefono());
            ps.executeUpdate();
        }
    }

    public List<Proveedor> listar() throws SQLException {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Proveedores";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Proveedor(
                    rs.getInt("id_proveedor"),
                    rs.getString("nombre"),
                    rs.getString("cif"),
                    rs.getString("telefono")
                ));
            }
        }
        return lista;
    }

    public void actualizar(Proveedor p) throws SQLException {
        String sql = "UPDATE Proveedores SET nombre=?, cif=?, telefono=? WHERE id_proveedor=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCif());
            ps.setString(3, p.getTelefono());
            ps.setInt(4, p.getId()); // Asumo que getId() devuelve id_proveedor
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM Proveedores WHERE id_proveedor = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // Método para validar existencia de proveedor por id
    public boolean existeProveedor(int idProveedor) {
        String sql = "SELECT 1 FROM Proveedores WHERE id_proveedor = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Error al verificar existencia del proveedor: " + e.getMessage());
            return false;
        }
    }
}
