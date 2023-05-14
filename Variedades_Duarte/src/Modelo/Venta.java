package Modelo;

public class Venta {
    
    int ID_venta;
    String fecha_venta;

    public Venta() {
    }

    public Venta(int ID_venta, String fecha_venta) {
        this.ID_venta = ID_venta;
        this.fecha_venta = fecha_venta;
    }

    public int getID_venta() {
        return ID_venta;
    }

    public void setID_venta(int ID_venta) {
        this.ID_venta = ID_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    
}
