
package Modelo;

public class Producto {
    
    int ID_producto;
    String nombre_producto;
    String cantidad_producto;
    String precio_compra;
    String precio_venta;
    String descripcion;
    String fecha_vencimiento;

    public Producto() {
    }

    public Producto(int ID_producto, String nombre_producto, String cantidad_producto, String precio_compra, String precio_venta, String descripcion, String fecha_vencimiento) {
        this.ID_producto = ID_producto;
        this.nombre_producto = nombre_producto;
        this.cantidad_producto = cantidad_producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.descripcion = descripcion;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getID_producto() {
        return ID_producto;
    }

    public void setID_producto(int ID_producto) {
        this.ID_producto = ID_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(String cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public String getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(String precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    
}
