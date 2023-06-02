package Modelo;

public class Proveedor extends Persona {

    int ID_proveedor;
    String empresa_proveedor;

    public Proveedor() {
    }

    public Proveedor(String nombre1, String nombre2, String apellido1, String apellido2,String empresa_proveedor, String telefono, String direccion) {
        super(nombre1, nombre2, apellido1, apellido2, telefono, direccion);
        this.empresa_proveedor = empresa_proveedor;
    }

    public Proveedor(int ID_proveedor, int IDPersona, String nombre1, String nombre2, String apellido1, String apellido2,String empresa_proveedor, String telefono, String direccion) {
        super(IDPersona, nombre1, nombre2, apellido1, apellido2, telefono, direccion);
        this.ID_proveedor = ID_proveedor;
        this.empresa_proveedor = empresa_proveedor;
    }
    
    
    
    

//    public Proveedor(String nombre1, String nombre2, String apellido1, String apellido2,String empresa_proveedor, String telefono, String direccion) {
//        super(IDPersona,nombre1, nombre2, apellido1, apellido2, telefono, direccion);
//        this.empresa_proveedor = empresa_proveedor;
//    }

//    public Proveedor(int ID_proveedor, String nombre1, String nombre2, String apellido1, String apellido2, String empresa_proveedor, String telefono, String direccion ) {
//        super(IDPersona,nombre1, nombre2, apellido1, apellido2, telefono, direccion);
//        this.ID_proveedor = ID_proveedor;
//        this.empresa_proveedor = empresa_proveedor;
//    }
    
    

    public int getID_proveedor() {
        return ID_proveedor;
    }

    public void setID_proveedor(int ID_proveedor) {
        this.ID_proveedor = ID_proveedor;
    }

    public String getEmpresa_proveedor() {
        return empresa_proveedor;
    }

    public void setEmpresa_proveedor(String empresa_proveedor) {
        this.empresa_proveedor = empresa_proveedor;
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