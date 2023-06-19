
package Modelo;

public class Compra {
    
    int IDCompra;
    String fecha_compra;
    String hora_compra;
    int IDProveedor;

    public Compra() {
    }

    public Compra(String fecha_compra, String hora_compra, int IDProveedor) {
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
        this.IDProveedor = IDProveedor;
    }

    public int getIDCompra() {
        return IDCompra;
    }

    public void setIDCompra(int IDCompra) {
        this.IDCompra = IDCompra;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getHora_compra() {
        return hora_compra;
    }

    public void setHora_compra(String hora_compra) {
        this.hora_compra = hora_compra;
    }

    public int getIDProveedor() {
        return IDProveedor;
    }

    public void setIDProveedor(int IDProveedor) {
        this.IDProveedor = IDProveedor;
    }

   
    
    
}
