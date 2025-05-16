package modelo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAO {
	private Connection conn;

	public ArticuloDAO(Connection conn) {
	    this.conn = conn;
	}

   

    // Crear un artículo
    public boolean insertarArticulo(Articulo articulo) {
        String sql = "INSERT INTO Articulos (nombre, precio_unitario, stock) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, articulo.getNombre());
            ps.setDouble(2, articulo.getPrecio_unitario());
            ps.setInt(3, articulo.getStock());
            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Leer todos los artículos
    public List<Articulo> listarArticulos() {
        List<Articulo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Articulos";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setId_articulo(rs.getInt("id_articulo"));
                articulo.setNombre(rs.getString("nombre"));
                articulo.setPrecio_unitario(rs.getDouble("precio_unitario"));
                articulo.setStock(rs.getInt("stock"));
                lista.add(articulo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Actualizar un artículo
    public boolean actualizarArticulo(Articulo articulo) {
        String sql = "UPDATE Articulos SET nombre=?, precio_unitario=?, stock=? WHERE id_articulo=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, articulo.getNombre());
            ps.setDouble(2, articulo.getPrecio_unitario());
            ps.setInt(3, articulo.getStock());
            ps.setInt(4, articulo.getId_articulo());
            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un artículo
    public boolean eliminarArticulo(int id_articulo) {
        String sql = "DELETE FROM Articulos WHERE id_articulo=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_articulo);
            int resultado = ps.executeUpdate();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Buscar artículo por ID
    public Articulo buscarArticuloPorId(int id_articulo) {
        String sql = "SELECT * FROM Articulos WHERE id_articulo=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_articulo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Articulo articulo = new Articulo();
                articulo.setId_articulo(rs.getInt("id_articulo"));
                articulo.setNombre(rs.getString("nombre"));
                articulo.setPrecio_unitario(rs.getDouble("precio_unitario"));
                articulo.setStock(rs.getInt("stock"));
                return articulo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
