
package Modelo;

public class Detalle_compra {
    int ID_DCompra;
    int cantidad_compra;
    int IDCompra;
    int IDProducto;

    public Detalle_compra() {
    }

    public Detalle_compra(int cantidad_compra, int IDCompra, int IDProducto) {
        this.cantidad_compra = cantidad_compra;
        this.IDCompra = IDCompra;
        this.IDProducto = IDProducto;
    }

    public int getID_DCompra() {
        return ID_DCompra;
    }

    public void setID_DCompra(int ID_DCompra) {
        this.ID_DCompra = ID_DCompra;
    }

    public int getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(int cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }

    public int getIDCompra() {
        return IDCompra;
    }

    public void setIDCompra(int IDCompra) {
        this.IDCompra = IDCompra;
    }

    public int getIDProducto() {
        return IDProducto;
    }

    public void setIDProducto(int IDProducto) {
        this.IDProducto = IDProducto;
    }
    
    
    

    
}
