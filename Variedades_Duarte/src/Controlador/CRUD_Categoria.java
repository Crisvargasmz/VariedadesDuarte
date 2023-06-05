//Crud categoria
package Controlador;
import Modelo.Categoria;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class CRUD_Categoria {
    
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    
    
public DefaultComboBoxModel<Categoria> Llenar() {
    DefaultComboBoxModel<Categoria> modelo = new DefaultComboBoxModel<>();
    modelo.addElement(new Categoria(-1, "Categoria"));

    try {
        CallableStatement cbstc = cn.prepareCall("{call LlenarCombo}");
        ResultSet rs = cbstc.executeQuery();
        while (rs.next()) {
            int IDCategoria = rs.getInt(1);
            String nombre_categoria = rs.getString(2);
            Categoria categoria = new Categoria(IDCategoria, nombre_categoria);
            modelo.addElement(categoria);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
 
    return modelo;
}

    
    public void insertarCategoria(Categoria categoria) {
        try {
           CallableStatement callableStatement = cn.prepareCall("{call InsertarCategoria(?)}");
            callableStatement.setString(1, categoria.getNombre_categoria());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
//    public boolean verificarDatos(String dato) {
//        ResultSet rs;
//
//        try {
//            CallableStatement call = cn.prepareCall("{call ConsultarCategoria(?)}");
//            call.setString(1, dato);
//            rs = call.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//            return false;
//        }
//    }

//    public void eliminar(String IDCategoria) {
//        try {
//            CallableStatement cbst = cn.prepareCall("{call EliminarCategoria(?)}");
//            cbst.setString(1, IDCategoria);
//            cbst.executeUpdate();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    
//    public void ActualizarCategoria(Categoria categoria) {
//        try {
//           CallableStatement callableStatement = cn.prepareCall("{call ActualizarCliente(?,?)}");
//            callableStatement.setInt(1, categoria.getID_categoria());
//            callableStatement.setString(2, categoria.getNombre_Categoria());
//            
//            callableStatement.executeUpdate();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
//        }
//    }

}

