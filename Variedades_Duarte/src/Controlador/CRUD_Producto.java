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
    
    
    public DefaultTableModel mostrarDatos() {
    ResultSet rs;
    DefaultTableModel modelo;
    
    String[] titulos = {"IDProducto", "Nombre", "Cantidad", "Precio Compra", "Precio Venta", "Descripcion",
            "Vencimiento","IDCategoria", "Categoria","ID_PPresentacion","Unidad numerica","IDPresentacion",
            "Presentacion","IDProveedor","Proveedor"};

    String[] registro = new String[15];

    modelo = new DefaultTableModel(null, titulos);
    
    try {
        CallableStatement cbstc = cn.prepareCall("{call ConsultarProducto}");
        rs = cbstc.executeQuery();

        while (rs.next()) {
            registro[0] = rs.getString("IDProducto");
            registro[1] = rs.getString("nombre_producto");
            registro[2] = rs.getString("cantidad_producto");
            registro[3] = rs.getString("precio_compra");
            registro[4] = rs.getString("precio_venta");
            registro[5] = rs.getString("descripcion");
            registro[6] = rs.getString("fecha_vencimiento");
            registro[7] = rs.getString("IDCategoria");
            registro[8] = rs.getString("nombre_categoria");
            registro[9] = rs.getString("ID_PPresentacion");
            registro[10] = rs.getString("medida_numerica");
            registro[11] = rs.getString("IDPresentacion");
            registro[12] = rs.getString("nombre_presentacion");
            registro[13] = rs.getString("IDProveedor");
            registro[14] = rs.getString("empresa_proveedor");

            modelo.addRow(registro);
            
        }

        
        return modelo;

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
}


       
//    public DefaultTableModel mostrarDatos() {
//
//        ResultSet rs;
//
//        DefaultTableModel modelo;
//
//        String[] titulos = {"ID Producto", "Nombre Producto", "Cantidad",
//            "Precio Compra", "Precio Venta", "Descripcion",
//            "Fecha vencimiento","IDCategoria", "Categoria","ID_PPresentacion","Unidad de medida","IDPresentacion","Presentacion"
//                ,"IDProveedor","empresa_proveedor"};
//
//        String[] registro = new String[15];
//
//        modelo = new DefaultTableModel(null, titulos);
//        try {
//
//            CallableStatement cbstc = cn.prepareCall("{call ConsultarProducto}");
//            rs = cbstc.executeQuery();
//
//            while (rs.next()) {
//                registro[0] = rs.getString("IDProducto");
//                registro[1] = rs.getString("nombre_producto");
//                registro[2] = rs.getString("cantidad_producto");
//                registro[3] = rs.getString("precio_compra");
//                registro[4] = rs.getString("precio_venta");
//                registro[5] = rs.getString("descripcion");
//                registro[6] = rs.getString("fecha_vencimiento");
//                registro[7]= rs.getString("IDCategoria");
//                registro[8] = rs.getString("nombre_categoria");
//                registro[9] = rs.getString("ID_PPresentacion");
//                registro[10] = rs.getString("medida_numerica");
//                registro[11] = rs.getString("IDPresentacion");
//                registro[12] = rs.getString("nombre_presentacion");
//                registro[13] = rs.getString("IDProveedor");
//                registro[14] = rs.getString("empresa_proveedor");
//
//                modelo.addRow(registro);
//            }
//            return modelo;
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            return null;
//        }
//    }

    public DefaultTableModel buscarDatos(String Dato) {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDProducto","Nombre Producto", "Cantidad",
            "Precio Compra", "Precio Venta", "Descripcion",
            "Fecha vencimiento","IDCategoria","Categoria","ID_PPresentacion","Medida numerica",
        "IDPresentacion","Presentacion"};
        String[] registro = new String[13];
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarProducto(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("IDProducto");
                registro[1] = rs.getString("nombre_producto");
                registro[2] = rs.getString("cantidad_producto");
                registro[3] = rs.getString("precio_compra");
                registro[4] = rs.getString("precio_venta");
                registro[5] = rs.getString("descripcion");
                registro[6] = rs.getString("fecha_vencimiento");
                registro[7]= rs.getString("IDCategoria");
                registro[8] = rs.getString("nombre_categoria");
                registro[9] = rs.getString("ID_PPresentacion");
                registro[10] = rs.getString("medida_numerica");
                registro[11] = rs.getString("IDPresentacion");
                registro[12] = rs.getString("nombre_presentacion");
           
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    
    public boolean verificarDatos(String Dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call VerificarProducto(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    
    
    public void insertarProducto(Producto producto) {
    try {
        CallableStatement callableStatement = cn.prepareCall("{call InsertarProducto(?,?,?,?,?,?,?,?,?,?)}");
        callableStatement.setString(1, producto.getNombre_producto());
        callableStatement.setInt(2, producto.getCantidad_producto());
        callableStatement.setBigDecimal(3, producto.getPrecio_compra());
        callableStatement.setBigDecimal(4, producto.getPrecio_venta());
        callableStatement.setString(5, producto.getDescripcion());
        callableStatement.setDate(6, producto.getFecha_vencimiento());
        callableStatement.setInt(7, producto.getIDCategoria());
        callableStatement.setInt(8, producto.getIDPresentacion());
        callableStatement.setBigDecimal(9, producto.getMedida_numerica());
        callableStatement.setInt(10, producto.getIDProveedor());

        callableStatement.executeUpdate();

//        insertarProductoPresentacion(producto.getIDCategoria(), producto.getIDPresentacion(), producto.getMedida_numerica());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
        e.printStackTrace();
    }
}
    public void ActualizarProducto(Producto producto){
    
   try{
       CallableStatement callableStatement = cn.prepareCall ("{call ActualizarProducto(?,?,?,?,?,?,?,?,?,?,?)}");
       callableStatement.setInt(1, producto.getIDProducto());
       callableStatement.setString(2, producto.getNombre_producto());
        callableStatement.setInt(3, producto.getCantidad_producto());
        callableStatement.setBigDecimal(4, producto.getPrecio_compra());
        callableStatement.setBigDecimal(5, producto.getPrecio_venta());
        callableStatement.setString(6, producto.getDescripcion());
        callableStatement.setDate(7, producto.getFecha_vencimiento());
        callableStatement.setInt(8, producto.getIDCategoria());
        callableStatement.setInt(9, producto.getIDPresentacion());
        callableStatement.setBigDecimal(10, producto.getMedida_numerica());
        callableStatement.setInt(11,producto.getIDProveedor());
        
        callableStatement.executeUpdate();
       
       }catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
           e.printStackTrace();
       
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



}
