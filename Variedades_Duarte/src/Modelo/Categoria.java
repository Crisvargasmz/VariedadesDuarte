
package Modelo;

public class Categoria {
    
    int ID_categoria;
    String nombre_categoria;

    public Categoria() {
    }

    public Categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    

    public Categoria(int ID_categoria, String nombre_categoria) {
        this.ID_categoria = ID_categoria;
        this.nombre_categoria = nombre_categoria;
    }

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public String getNombre_Categoria() {
        return nombre_categoria;
    }

    public void setNombre(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    
    
    
}
