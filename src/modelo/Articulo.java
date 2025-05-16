package modelo;

public class Articulo {
    private int id_articulo;
    private String nombre;
    private double precio_unitario;
    private int stock;

    public Articulo() {
    }

    public Articulo(int id_articulo, String nombre, double precio_unitario, int stock) {
        this.id_articulo = id_articulo;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
        this.stock = stock;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id_articulo=" + id_articulo +
                ", nombre='" + nombre + '\'' +
                ", precio_unitario=" + precio_unitario +
                ", stock=" + stock +
                '}';
    }
}
