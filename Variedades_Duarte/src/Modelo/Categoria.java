
package Modelo;

public class Categoria {
    
    int IDCategoria;
    String nombre_categoria;

    public Categoria() {
    }

    public Categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public Categoria(int IDCategoria, String nombre_categoria) {
        this.IDCategoria = IDCategoria;
        this.nombre_categoria = nombre_categoria;
    }

    public int getIDCategoria() {
        return IDCategoria;
    }

    public void setIDCategoria(int IDCategoria) {
        this.IDCategoria = IDCategoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
    
    
       @Override
    public String toString() {
        return IDCategoria + " - " + nombre_categoria;
    }

   
    
}
