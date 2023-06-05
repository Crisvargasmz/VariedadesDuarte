package Modelo;
import java.sql.Date;
import java.math.BigDecimal;

public class Producto {

    int IDProducto;
    String nombre_producto;
    int cantidad_producto;
    BigDecimal precio_compra;
    BigDecimal  precio_venta;
    String descripcion;
    Date fecha_vencimiento;
    int IDCategoria;
    int IDPresentacion;
    BigDecimal medida_numerica;

    public Producto() {
    }

    public Producto(String nombre_producto, int cantidad_producto, BigDecimal precio_compra, BigDecimal precio_venta, String descripcion, Date fecha_vencimiento, int IDCategoria, int IDPresentacion, BigDecimal medida_numerica) {
        this.nombre_producto = nombre_producto;
        this.cantidad_producto = cantidad_producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.descripcion = descripcion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.IDCategoria = IDCategoria;
        this.IDPresentacion = IDPresentacion;
        this.medida_numerica = medida_numerica;
    }

    public Producto(int IDProducto, String nombre_producto, int cantidad_producto, BigDecimal precio_compra, BigDecimal precio_venta, String descripcion, Date fecha_vencimiento, int IDCategoria, int IDPresentacion, BigDecimal medida_numerica) {
        this.IDProducto = IDProducto;
        this.nombre_producto = nombre_producto;
        this.cantidad_producto = cantidad_producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.descripcion = descripcion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.IDCategoria = IDCategoria;
        this.IDPresentacion = IDPresentacion;
        this.medida_numerica = medida_numerica;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public BigDecimal getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(BigDecimal precio_compra) {
        this.precio_compra = precio_compra;
    }

    public BigDecimal getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(BigDecimal precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getIDCategoria() {
        return IDCategoria;
    }

    public void setIDCategoria(int IDCategoria) {
        this.IDCategoria = IDCategoria;
    }

    public int getIDPresentacion() {
        return IDPresentacion;
    }

    public void setIDPresentacion(int IDPresentacion) {
        this.IDPresentacion = IDPresentacion;
    }

    public BigDecimal getMedida_numerica() {
        return medida_numerica;
    }

    public void setMedida_numerica(BigDecimal medida_numerica) {
        this.medida_numerica = medida_numerica;
    }
    
    
   
   
   

}
