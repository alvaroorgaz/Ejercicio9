package modelo;

public class Proveedor {
    private int id;
    private String nombre;
    private String cif;
    private String telefono;

    public Proveedor() {}

    public Proveedor(int id, String nombre, String cif, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.cif = cif;
        this.telefono = telefono;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
