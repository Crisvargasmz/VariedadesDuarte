// a
package Modelo;

public class Cliente {
    
    int ID_cliente;
    String nombre_cliente1;
    String nombre_cliente2;
    String apellido_cliente1;
    String apellido_cliente2;
    String telefono_cliente;
    char sexo_cliente;
    String direccion_cliente;

    public Cliente() {
    }

    public Cliente(int ID_cliente, String nombre_cliente1, String nombre_cliente2, String apellido_cliente1, String apellido_cliente2, String telefono_cliente, char sexo_cliente, String direccion_cliente) {
        this.ID_cliente = ID_cliente;
        this.nombre_cliente1 = nombre_cliente1;
        this.nombre_cliente2 = nombre_cliente2;
        this.apellido_cliente1 = apellido_cliente1;
        this.apellido_cliente2 = apellido_cliente2;
        this.telefono_cliente = telefono_cliente;
        this.sexo_cliente = sexo_cliente;
        this.direccion_cliente = direccion_cliente;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public String getNombre_cliente1() {
        return nombre_cliente1;
    }

    public void setNombre_cliente1(String nombre_cliente1) {
        this.nombre_cliente1 = nombre_cliente1;
    }

    public String getNombre_cliente2() {
        return nombre_cliente2;
    }

    public void setNombre_cliente2(String nombre_cliente2) {
        this.nombre_cliente2 = nombre_cliente2;
    }

    public String getApellido_cliente1() {
        return apellido_cliente1;
    }

    public void setApellido_cliente1(String apellido_cliente1) {
        this.apellido_cliente1 = apellido_cliente1;
    }

    public String getApellido_cliente2() {
        return apellido_cliente2;
    }

    public void setApellido_cliente2(String apellido_cliente2) {
        this.apellido_cliente2 = apellido_cliente2;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public char getSexo_cliente() {
        return sexo_cliente;
    }

    public void setSexo_cliente(char sexo_cliente) {
        this.sexo_cliente = sexo_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }
    
    
}