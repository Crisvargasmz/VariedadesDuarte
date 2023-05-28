
package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;


public class CRUD_Presentacion {
    
       private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
   public DefaultComboBoxModel Llenar ()
   {
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    modelo.addElement("Unidad de medida");
    try {
   CallableStatement cbstc = cn.prepareCall("{call LlenarCombo2}");
   ResultSet rs = cbstc.executeQuery();
   while(rs.next())//realizamos un recorrido para buscar los datos existentes
   {
       modelo.addElement(rs.getString(1));
     }  
  } catch (Exception e) {
  }
    return modelo;
}
}
