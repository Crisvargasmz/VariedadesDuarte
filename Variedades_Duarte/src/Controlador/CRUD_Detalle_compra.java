
package Controlador;

import Modelo.Detalle_compra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CRUD_Detalle_compra {
    
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public String IdCompras(){
        ResultSet rs;
      String idc="";
             String sql =("Select max(IDCompra)  from Compra");
            
            
            try {
                PreparedStatement pst =cn.prepareStatement(sql);
               rs=pst.executeQuery();
               
                while (rs.next()) {
                    idc=rs.getString(1);
                    
                }
               
               
            } catch (SQLException e1) {
               
            }
            
            return idc;
        } 
    
        public void insertarDetalle_compra(Detalle_compra detalle_compra) {
        try {

            CallableStatement callableStatement = cn.prepareCall("{call DetalleCompra(?,?,?)}");
            callableStatement.setInt(1, detalle_compra.getCantidad_compra());
            callableStatement.setInt(2,detalle_compra.getIDCompra());
            callableStatement.setInt(3, detalle_compra.getIDProducto());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
}
