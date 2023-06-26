
package Modelo;
import java.sql.Date;

public class Compra {
    
    int IDCompra;
    Date fecha_compra;
    Date hora_compra;
    int cantidad_compra;
    int IDProducto;

    public Compra() {
    }

    public Compra(Date fecha_compra, Date hora_compra, int cantidad_compra, int IDProducto) {
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.cantidad_compra = cantidad_compra;
        this.IDProducto = IDProducto;
    }

    public Compra(int cantidad_compra, int IDProducto) {
        this.cantidad_compra = cantidad_compra;
        this.IDProducto = IDProducto;
    }
    
    

    public int getIDCompra() {
        return IDCompra;
    }

    public void setIDCompra(int IDCompra) {
        this.IDCompra = IDCompra;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Date getHora_compra() {
        return hora_compra;
    }

    public void setHora_compra(Date hora_compra) {
        this.hora_compra = hora_compra;
    }

    public int getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(int cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }

    
    
}
