// a
package Modelo;

public class Cliente extends Persona {
    
    int IDCliente;
    char genero_cliente;

    public Cliente(char genero_cliente, String nombre1, String nombre2, String apellido1, String apellido2, String telefono, String direccion) {
        super(nombre1, nombre2, apellido1, apellido2, telefono, direccion);
        this.genero_cliente = genero_cliente;
    }
    
    
 

public Cliente(int IDCliente, char genero_cliente, String nombre1, String nombre2, String apellido1, String apellido2, String telefono, String direccion) {
        super(nombre1, nombre2, apellido1, apellido2, telefono, direccion);
        this.IDCliente = IDCliente;
        this.genero_cliente = genero_cliente;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public char getGenero_cliente() {
        return genero_cliente;
    }

    public void setGenero_cliente(char genero_cliente) {
        this.genero_cliente = genero_cliente;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   

   
    
}

   