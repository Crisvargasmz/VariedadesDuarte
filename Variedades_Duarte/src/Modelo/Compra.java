
package Modelo;

public class Compra {
    
    int IDCompra;
    String fecha_compra;
    String hora_compra;

    public Compra() {
    }

    public Compra(int IDCompra, String fecha_compra, String hora_compra) {
        this.IDCompra = IDCompra;
        this.fecha_compra = fecha_compra;
        this.hora_compra = hora_compra;
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
    
    
}
