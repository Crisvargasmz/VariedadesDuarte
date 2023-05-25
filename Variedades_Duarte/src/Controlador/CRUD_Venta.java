package Controlador;
import Modelo.Venta;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CRUD_Venta {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrarDatos() {

        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDVenta", "Fecha", "IDCliente"};
        String[] registro = new String[3]; 

        modelo = new DefaultTableModel(null, titulos);
        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarVenta}");
            rs = cbstc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("IDVenta");
                registro[1] = rs.getString("Fecha");
                registro[2] = rs.getString("IDCliente");
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
        String[] titulos = {"Fecha", "IDCliente"};
        String[] registro = new String[3];
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarVenta(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("Fecha");
                registro[1] = rs.getString("IDCliente");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public void insertarCliente(Venta venta) {
        try {
            CallableStatement callableStatement = cn.prepareCall("{call InsertarVenta(?)}");
            callableStatement.setString(1, venta.getFecha_venta());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
}
