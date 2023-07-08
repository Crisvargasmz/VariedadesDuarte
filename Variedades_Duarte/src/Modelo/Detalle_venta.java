/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Windows 10
 */
public class Detalle_venta {

    int ID_DVenta;
    int cantidad_venta;
    int IDVenta;
    int IDProducto;

    public Detalle_venta() {
    }

    public Detalle_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public Detalle_venta(int cantidad_venta, int IDVenta, int IDProducto) {
        this.cantidad_venta = cantidad_venta;
        this.IDVenta = IDVenta;
        this.IDProducto = IDProducto;
    }

    public Detalle_venta(int ID_DVenta, int cantidad_venta, int IDVenta, int IDProducto) {
        this.ID_DVenta = ID_DVenta;
        this.cantidad_venta = cantidad_venta;
        this.IDVenta = IDVenta;
        this.IDProducto = IDProducto;
    }

    public int getID_DVenta() {
        return ID_DVenta;
    }

    public void setID_DVenta(int ID_DVenta) {
        this.ID_DVenta = ID_DVenta;
    }

    public int getCantidad_venta() {
        return cantidad_venta;
    }

    public void setCantidad_venta(int cantidad_venta) {
        this.cantidad_venta = cantidad_venta;
    }

    public int getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(int IDVenta) {
        this.IDVenta = IDVenta;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

}
