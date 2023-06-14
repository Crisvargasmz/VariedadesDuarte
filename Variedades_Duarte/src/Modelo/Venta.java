package Modelo;

import java.sql.Date;
import java.sql.Time;

public class Venta {
    
    int ID_venta;
    Date fecha_venta;
    Time hora_venta;
    int IDCliente;
    int IDProducto;
    int cantidad_venta;

    public Venta() {
    }

    public Venta(Date fecha_venta, Time hora_venta, int IDCliente, int IDProducto, int cantidad_venta) {
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
        this.IDCliente = IDCliente;
        this.IDProducto = IDProducto;
        this.cantidad_venta = cantidad_venta;
    }

    public Venta(int ID_venta, Date fecha_venta, Time hora_venta, int IDCliente, int IDProducto, int cantidad_venta) {
        this.ID_venta = ID_venta;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
        this.IDCliente = IDCliente;
        this.IDProducto = IDProducto;
        this.cantidad_venta = cantidad_venta;
    }

    public Venta(int IDCliente, int IDProducto, int cantidad_venta) {
        this.IDCliente = IDCliente;
        this.IDProducto = IDProducto;
        this.cantidad_venta = cantidad_venta;
    }
    
    

    public int getID_venta() {
        return ID_venta;
    }

    public void setID_venta(int ID_venta) {
        this.ID_venta = ID_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Time getHora_venta() {
        return hora_venta;
    }

    public void setHora_venta(Time hora_venta) {
        this.hora_venta = hora_venta;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }
    

   
    
}
