//Crud proveedor
package Controlador;

import Modelo.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CRUD_Proveedor {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatos() {

        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDPersona", "ID Proveedor", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
            "Telefono", "Empresa", "Dirección"};
        String[] registro = new String[9]; //se especifica cuantas columnas va a tener de acuerdo a nuestra base de datos

        modelo = new DefaultTableModel(null, titulos);
        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarProveedor}");// 
            rs = cbstc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("IDPersona");
                registro[1] = rs.getString("IDProveedor");
                registro[2] = rs.getString("nombre1");
                registro[3] = rs.getString("nombre2");
                registro[4] = rs.getString("apellido1");
                registro[5] = rs.getString("apellido2");
                registro[6] = rs.getString("telefono");
                registro[7] = rs.getString("empresa_proveedor");
                registro[8] = rs.getString("direccion");

                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public ArrayList mostrarDatosCombo() {

        ArrayList<Proveedor> Proveedores = new ArrayList();

        Proveedor proveedor = new Proveedor();
        proveedor.setID_proveedor(0); // ID de categoría por defecto 
        proveedor.setEmpresa_proveedor("Proveedor"); // Texto por defecto a mostrar
        Proveedores.add(proveedor);

        try {
            CallableStatement cbstc = cn.prepareCall("{call LlenarProveedor}");
            ResultSet rs = cbstc.executeQuery();
            while (rs.next()) {
                Proveedor provee = new Proveedor();
                provee.setID_proveedor(Integer.parseInt(rs.getString("IDProveedor")));
                provee.setEmpresa_proveedor(rs.getString("empresa_proveedor"));
                Proveedores.add(provee);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Proveedores;
    }

    public DefaultTableModel buscarDatos(String Dato) {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDPersona", "IDProveedor", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
            "Empresa", "Telefono", "Dirección"};
        String[] registro = new String[9];
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarProveedor(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("IDPersona");
                registro[1] = rs.getString("IDProveedor");
                registro[2] = rs.getString("nombre1");
                registro[3] = rs.getString("nombre2");
                registro[4] = rs.getString("apellido1");
                registro[5] = rs.getString("apellido2");
                registro[6] = rs.getString("empresa_proveedor");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("direccion");
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

    public boolean verificarTelefonoProveedor(String numeroTelefono) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call VerificarTelefonoExistente(?)}");
            call.setString(1, numeroTelefono);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean verificarTelefonoProveedorActualizado(int IDPersona, String numeroTelefono) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call VerificarTelefonoActualizado(?,?)}");
            call.setInt(1, IDPersona);
            call.setString(2, numeroTelefono);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean tieneProductosAsociados(int IDProveedor) throws SQLException {
        try {
            String query = "SELECT 1 FROM Producto WHERE IDProveedor = ?";
            PreparedStatement statement = cn.prepareStatement(query);
            statement.setInt(1, IDProveedor);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public void eliminar(int pr, int perso) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarProveedorPersona(?,?)}");
            cbst.setInt(1, pr);
            cbst.setInt(2, perso);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarProveedor(Proveedor proveedor) {
        try {
            CallableStatement callableStatement = cn.prepareCall("{call ActualizarPersonaProveedor(?,?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, proveedor.getIDPersona());
            callableStatement.setInt(2, proveedor.getID_proveedor());
            callableStatement.setString(3, proveedor.getNombre1());
            callableStatement.setString(4, proveedor.getNombre2());
            callableStatement.setString(5, proveedor.getApellido1());
            callableStatement.setString(6, proveedor.getApellido2());
            callableStatement.setString(7, proveedor.getTelefono());
            callableStatement.setString(8, proveedor.getEmpresa_proveedor());
            callableStatement.setString(9, proveedor.getDireccion());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

}
