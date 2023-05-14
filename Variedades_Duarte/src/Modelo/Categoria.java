
package Modelo;

public class Categoria {
    
    int ID_categoria;
    String nombre;

    public Categoria() {
    }

    public Categoria(int ID_categoria, String nombre) {
        this.ID_categoria = ID_categoria;
        this.nombre = nombre;
    }

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
