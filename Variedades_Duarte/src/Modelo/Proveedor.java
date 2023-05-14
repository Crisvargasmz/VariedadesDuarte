package Modelo;

public class Proveedor {
    
    int ID_proveedor;
    String nombre_proveedor1;
    String nombre_proveedor2;
    String apellido_proveedor1;
    String apellido_proveedor2;
    String empresa_proveedor;
    String telefono_proveedor;
    String direccion_proveedor;

    public Proveedor() {
    }

    public Proveedor(int ID_proveedor, String nombre_proveedor1, String nombre_proveedor2, String apellido_proveedor1, String apellido_proveedor2, String empresa_proveedor, String telefono_proveedor, String direccion_proveedor) {
        this.ID_proveedor = ID_proveedor;
        this.nombre_proveedor1 = nombre_proveedor1;
        this.nombre_proveedor2 = nombre_proveedor2;
        this.apellido_proveedor1 = apellido_proveedor1;
        this.apellido_proveedor2 = apellido_proveedor2;
        this.empresa_proveedor = empresa_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.direccion_proveedor = direccion_proveedor;
    }

    public int getID_proveedor() {
        return ID_proveedor;
    }

    public void setID_proveedor(int ID_proveedor) {
        this.ID_proveedor = ID_proveedor;
    }

    public String getNombre_proveedor1() {
        return nombre_proveedor1;
    }

    public void setNombre_proveedor1(String nombre_proveedor1) {
        this.nombre_proveedor1 = nombre_proveedor1;
    }

    public String getNombre_proveedor2() {
        return nombre_proveedor2;
    }

    public void setNombre_proveedor2(String nombre_proveedor2) {
        this.nombre_proveedor2 = nombre_proveedor2;
    }

    public String getApellido_proveedor1() {
        return apellido_proveedor1;
    }

    public void setApellido_proveedor1(String apellido_proveedor1) {
        this.apellido_proveedor1 = apellido_proveedor1;
    }

    public String getApellido_proveedor2() {
        return apellido_proveedor2;
    }

    public void setApellido_proveedor2(String apellido_proveedor2) {
        this.apellido_proveedor2 = apellido_proveedor2;
    }

    public String getEmpresa_proveedor() {
        return empresa_proveedor;
    }

    public void setEmpresa_proveedor(String empresa_proveedor) {
        this.empresa_proveedor = empresa_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }
    
    
}
