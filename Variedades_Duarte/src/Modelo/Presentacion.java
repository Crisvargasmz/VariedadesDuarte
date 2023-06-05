
package Modelo;

public class Presentacion {

    int IDPresentacion;
    String nombre_presentacion;


    public Presentacion() {
    }

    public Presentacion(int IDPresentacion, String nombre_presentacion) {
        this.IDPresentacion = IDPresentacion;
        this.nombre_presentacion = nombre_presentacion;
    }

    public Presentacion(String nombre_presentacion) {
        this.nombre_presentacion = nombre_presentacion;
    }

    public int getIDPresentacion() {
        return IDPresentacion;
    }

    public void setIDPresentacion(int IDPresentacion) {
        this.IDPresentacion = IDPresentacion;
    }

    public String getNombre_presentacion() {
        return nombre_presentacion;
    }

    public void setNombre_presentacion(String nombre_presentacion) {
        this.nombre_presentacion = nombre_presentacion;
    }

     @Override
     public String toString() {
        return IDPresentacion + " - " + nombre_presentacion;
    }
    

    
}
