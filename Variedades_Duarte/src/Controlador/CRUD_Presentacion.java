package Controlador;

import Modelo.Presentacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class CRUD_Presentacion {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultComboBoxModel Llenar() {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Unidad de medida");
        try {
            CallableStatement cbstc = cn.prepareCall("{call LlenarCombo2}");
            ResultSet rs = cbstc.executeQuery();
            while (rs.next())//realizamos un recorrido para buscar los datos existentes
            {
                modelo.addElement(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return modelo;
    }
    
    public void insertarDetallePresentacion(Presentacion presentacion) {
        try {
           CallableStatement callableStatement = cn.prepareCall("{call InsertarProductoPresentacion(?)}");
            callableStatement.setDouble(1, presentacion.getPrecio_pproducto());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
}
