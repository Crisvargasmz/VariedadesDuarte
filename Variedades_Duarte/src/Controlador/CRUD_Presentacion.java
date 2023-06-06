
package Controlador;

import Modelo.Presentacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class CRUD_Presentacion {
        private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
      
public DefaultComboBoxModel<Presentacion> Llenar() {
    DefaultComboBoxModel<Presentacion> modelo = new DefaultComboBoxModel<>();
    modelo.addElement(new Presentacion(-1, "Unidad de medida"));

    try {
        CallableStatement cbstc = cn.prepareCall("{call LlenarPresentacion}");
        ResultSet rs = cbstc.executeQuery();
        while (rs.next()) {
            int IDPresentacion = rs.getInt(1);
            String nombre_presentacion = rs.getString(2);
            Presentacion presentacion = new Presentacion(IDPresentacion, nombre_presentacion);
            modelo.addElement(presentacion);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return modelo;
}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//   public DefaultComboBoxModel Llenar ()
//   {
//    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
//    modelo.addElement("Unidad de medida");
//    try {
//   CallableStatement cbstc = cn.prepareCall("{call LlenarCombo2}");
//   ResultSet rs = cbstc.executeQuery();
//   while(rs.next())//realizamos un recorrido para buscar los datos existentes
//   {   modelo.addElement(Integer.valueOf(rs.getString(1)));
//       modelo.addElement(rs.getString(2));
//     }  
//  } catch (Exception e) {
//  }
//    return modelo;
//}
    
    
    
    
}
