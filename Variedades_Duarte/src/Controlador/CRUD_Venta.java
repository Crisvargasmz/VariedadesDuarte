//Crud venta
package Controlador;
import Modelo.Detalle_venta;
import Modelo.Venta;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CRUD_Venta {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrar(){
        DefaultTableModel modelo;
        
        String[] titulos={"ID Producto", "Nombre Producto", "Cantidad", "Precio", "Sub Total"};
       modelo=new DefaultTableModel(null,titulos);
       String[] registro =new String[6];
       return modelo;
     }
    
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
        String[] titulos = {"IDVenta","Fecha", "Hora","IDCliente"};
        String[] registro = new String[3];
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarVenta(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("IDVenta");
                registro[1] = rs.getString("fecha_venta");
                registro[2] = rs.getString("hora_venta");
                registro[3] = rs.getString("IDCliente");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public void insertarVenta(Venta venta) {
        try {

            CallableStatement callableStatement = cn.prepareCall("{call InsertarVenta(?,?,?)}");
            callableStatement.setDate(1, venta.getFecha_venta());
            callableStatement.setTime(2,venta.getHora_venta());
            callableStatement.setInt(3, venta.getIDCliente());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
    public void insertarDetalle_venta(Detalle_venta detalle_venta) {
        try {

            CallableStatement callableStatement = cn.prepareCall("{call InsertarVenta(?,?,?)}");
            callableStatement.setInt(1, detalle_venta.getCantidad_venta());
            callableStatement.setInt(2,detalle_venta.getIDVenta());
            callableStatement.setInt(3, detalle_venta.getIDProducto());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
//     public boolean verificarDatos(String dato) {
//        ResultSet rs;
//
//        try {
//            CallableStatement call = cn.prepareCall("{call ConsultarVenta(?)}");
//            call.setString(1, dato);
//            rs = call.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//            return false;
//        }
//    }
     
//     public void eliminar(String IDVenta) {
//        try {
//            CallableStatement cbst = cn.prepareCall("{call EliminarVenta(?)}");
//            cbst.setString(1, IDVenta);
//            cbst.executeUpdate();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
     
//      public void ActualizarCliente(Venta venta) {
//        try {
//           CallableStatement callableStatement = cn.prepareCall("{call ActualizarVenta(?,?,?,?,?,?,?,?)}");
//            callableStatement.setInt(1, venta.getID_venta());
//           callableStatement.setString(2, venta.getFecha_venta());
//            callableStatement.executeUpdate();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
//        }
//    }
 
    
}
