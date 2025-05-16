package modelo;

import java.sql.Date;

public class FacturaRecibida {
    private int idFactura;
    private int idProveedor;
    private Date fecha;
    private double total;

    public FacturaRecibida() {}

    public FacturaRecibida(int idFactura, int idProveedor, Date fecha, double total) {
        this.idFactura = idFactura;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y setters

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
