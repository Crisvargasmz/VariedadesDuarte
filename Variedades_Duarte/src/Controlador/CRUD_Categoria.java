
package Controlador;
import Modelo.Categoria;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CRUD_Categoria {
    
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public DefaultTableModel mostrarDatos() {

        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"ID Categoria", "Nombre Categoria"};
        String[] registro = new String[2]; 

        modelo = new DefaultTableModel(null, titulos);
        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarCategoria}");// 
            rs = cbstc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("IDCategoria");
                registro[1] = rs.getString("nombre_categoria");
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
        String[] titulos = {"Nombre Categoria"};
        String[] registro = new String[3]; 
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarCategoria(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

             while (rs.next()) {
                registro[0] = rs.getString("nombre_categoria");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public void insertarCategoria(Categoria categoria) {
        try {
           CallableStatement callableStatement = cn.prepareCall("{call InsertarCategoria(?)}");
            callableStatement.setString(1, categoria.getNombre_Categoria());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
    public boolean verificarDatos(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarCategoria(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public void eliminar(String IDCategoria) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarCategoria(?)}");
            cbst.setString(1, IDCategoria);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void ActualizarCategoria(Categoria categoria) {
        try {
           CallableStatement callableStatement = cn.prepareCall("{call ActualizarCliente(?,?)}");
            callableStatement.setInt(1, categoria.getID_categoria());
            callableStatement.setString(2, categoria.getNombre_Categoria());
            
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

}

