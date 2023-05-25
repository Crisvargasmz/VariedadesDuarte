//Crud producto
package Controlador;

//Importanto las librerias que se necesitan.
import java.sql.Connection;
import Modelo.Producto;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CRUD_Producto {
    
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public DefaultTableModel mostrarDatos(){
        
       ResultSet rs;
       
       DefaultTableModel modelo;
       
       String[] titulos = {"ID Producto", "Nombre Producto", "Cantidad",
                           "Precio Compra", "Precio Venta", "Descripcion",
                           "Fecha vencimiento", "ID Categoria"};
       
       String[] registro = new String[8];
       
       modelo =  new DefaultTableModel(null, titulos);
        try {
            
            CallableStatement cbstc = cn.prepareCall("{call ConsultarProducto}");
            rs = cbstc.executeQuery();
            
            while (rs.next()){
                registro[0] = rs.getString("IDProducto");
                registro[1] = rs.getString("nombre_producto");
                registro[2] = rs.getString("cantidad_producto");
                registro[3] = rs.getString("precio_compra");
                registro[4] = rs.getString("precio_venta");
                registro[5] = rs.getString("descripcion");
                registro[6] = rs.getString("fecha_vencimiento");
                registro[7] = rs.getString("IDCategoria");
                registro[8] = rs.getString("IDPresentacion");
                
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public DefaultTableModel buscarDatos(String Dato) {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"Nombre Producto", "Cantidad",
                           "Precio Compra", "Precio Venta", "Descripcion",
                           "Fecha vencimiento", "ID Categoria"};
        String[] registro = new String[8];
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarProducto(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("nombre_producto");
                registro[1] = rs.getString("cantidad_producto");
                registro[2] = rs.getString("precio_compra");
                registro[3] = rs.getString("precio_venta");
                registro[4] = rs.getString("descripcion");
                registro[5] = rs.getString("fecha_vencimiento");
                registro[6] = rs.getString("IDCategoria");
                registro[7] = rs.getString("IDPresentacion");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public void insertarProducto(Producto producto) {
        try {
            CallableStatement callableStatement = cn.prepareCall("{call InsertarProducto(?,?,?,?,?,?,?)}");
            callableStatement.setString(1, producto.getNombre_producto());
            callableStatement.setString(2, producto.getCantidad_producto());
            callableStatement.setString(3, producto.getPrecio_compra());
            callableStatement.setString(4, producto.getPrecio_venta());
            callableStatement.setString(5, producto.getDescripcion());
            callableStatement.setString(6, producto.getFecha_vencimiento());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
    public boolean verificarDatos(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarProducto(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public void eliminar(String IDProducto) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarProducto(?)}");
            cbst.setString(1, IDProducto);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     
    public void ActualizarCliente(Producto producto) {
        try {
           CallableStatement callableStatement = cn.prepareCall("{call ActualizarProducto(?,?,?,?,?,?,?)}");
            callableStatement.setString(1, producto.getNombre_producto());
            callableStatement.setString(2, producto.getCantidad_producto());
            callableStatement.setString(3, producto.getPrecio_compra());
            callableStatement.setString(4, producto.getPrecio_venta());
            callableStatement.setString(5, producto.getDescripcion());
            callableStatement.setString(6, producto.getFecha_vencimiento());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    

}
