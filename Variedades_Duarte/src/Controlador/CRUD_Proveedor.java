//Crud proveedor
package Controlador;
import Modelo.Proveedor;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CRUD_Proveedor {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatos() {

        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"ID Proveedor", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
            "Telefono", "Empresa", "Dirección"};
        String[] registro = new String[8]; //se especifica cuantas columnas va a tener de acuerdo a nuestra base de datos

        modelo = new DefaultTableModel( null, titulos);
        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarProveedor}");// 
            rs = cbstc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("IDProveedor");
                registro[1] = rs.getString("nombre1");
                registro[2] = rs.getString("nombre2");
                registro[3] = rs.getString("apellido1");
                registro[4] = rs.getString("apellido2");
                registro[6] = rs.getString("telefono");
                registro[5] = rs.getString("empresa_proveedor");
                registro[7] = rs.getString("direccion");
                
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
     public DefaultTableModel buscarDatos(String Dato) {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
            "Empresa", "Telefono", "Dirección"};
        String[] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarProveedores(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro [0] = rs.getString("IDProveedor");
                registro[1] = rs.getString("nombre1");
                registro[2] = rs.getString("nombre2");
                registro[3] = rs.getString("apellido1");
                registro[4] = rs.getString("apellido2");
                registro[5] = rs.getString("empresa_proveedor");
                registro[6] = rs.getString("telefono");
                registro[7] = rs.getString("direccion");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
 
      public void insertarProveedor(Proveedor proveedor) {
        try {
           CallableStatement callableStatement = cn.prepareCall("{call InsertarPersonaProveedor(?,?,?,?,?,?,?)}");
            callableStatement.setString(1, proveedor.getNombre1());
            callableStatement.setString(2, proveedor.getNombre2());
            callableStatement.setString(3, proveedor.getApellido1());
            callableStatement.setString(4, proveedor.getApellido2());
            callableStatement.setString(5, proveedor.getDireccion());
            callableStatement.setString(6, proveedor.getTelefono());
            callableStatement.setString(7, proveedor.getEmpresa_proveedor());
       
            
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
      
       public boolean verificarDatos(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarProveedor(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
      
       public void eliminar(String Dato) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarProveedorPersona(?)}");
            cbst.setString(1, Dato);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
       
       
       public void ActualizarProveedor(Proveedor proveedor) {
        try {
           CallableStatement callableStatement = cn.prepareCall("{call ActualizarPersonaProveedor(?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, proveedor.getID_proveedor());
           callableStatement.setString(2, proveedor.getNombre1());
            callableStatement.setString(3, proveedor.getNombre2());
            callableStatement.setString(4, proveedor.getApellido1());
            callableStatement.setString(5, proveedor.getApellido2());
            callableStatement.setString(6, proveedor.getEmpresa_proveedor());
            callableStatement.setString(7, proveedor.getTelefono());
            callableStatement.setString(8, proveedor.getDireccion());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
 
}

