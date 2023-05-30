/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Windows 10
 */
public class Presentacion {

    int IDPPresentacion;
    String nombre_presentacion;
    double precio_pproducto;
    int IDProducto;
    int IDPresentacion;

    public Presentacion() {
    }

    public Presentacion(double precio_pproducto, int IDProducto, int IDPresentacion) {
        this.precio_pproducto = precio_pproducto;
        this.IDProducto = IDProducto;
        this.IDPresentacion = IDPresentacion;
    }

    public Presentacion(int IDPPresentacion, String nombre_presentacion, double precio_pproducto, int IDProducto, int IDPresentacion) {
        this.IDPPresentacion = IDPPresentacion;
        this.nombre_presentacion = nombre_presentacion;
        this.precio_pproducto = precio_pproducto;
        this.IDProducto = IDProducto;
        this.IDPresentacion = IDPresentacion;
    }

    public int getIDPPresentacion() {
        return IDPPresentacion;
    }

    public void setIDPPresentacion(int IDPPresentacion) {
        this.IDPPresentacion = IDPPresentacion;
    }

    public String getNombre_presentacion() {
        return nombre_presentacion;
    }

    public void setNombre_presentacion(String nombre_presentacion) {
        this.nombre_presentacion = nombre_presentacion;
    }

    public double getPrecio_pproducto() {
        return precio_pproducto;
    }

    public void setPrecio_pproducto(double precio_pproducto) {
        this.precio_pproducto = precio_pproducto;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public int getIDPresentacion() {
        return IDPresentacion;
    }

    public void setIDPresentacion(int IDPresentacion) {
        this.IDPresentacion = IDPresentacion;
    }

}
