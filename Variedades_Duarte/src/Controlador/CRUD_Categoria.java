//Crud categoria
package Controlador;
import Modelo.Categoria;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class CRUD_Categoria {
    
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    
    
       public ArrayList mostrarDatosCombo() {

        ArrayList<Categoria> Categorias = new ArrayList();
        
          Categoria categoria = new Categoria();
    categoria.setIDCategoria(0); // ID de categoría por defecto 
    categoria.setNombre_categoria("Categoria"); // Texto por defecto a mostrar
    Categorias.add(categoria);

        try {
            CallableStatement cbstc = cn.prepareCall("{call LlenarCategoria}");
            ResultSet rs = cbstc.executeQuery();
            while (rs.next()) {
                Categoria cate = new Categoria();
                cate.setIDCategoria(Integer.parseInt(rs.getString("IDCategoria")));
                cate.setNombre_categoria(rs.getString("nombre_categoria"));
                Categorias.add(cate);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Categorias;
    }

    
    
    
//public DefaultComboBoxModel<Categoria> Llenar() {
//    DefaultComboBoxModel<Categoria> modelo = new DefaultComboBoxModel<>();
//    modelo.addElement(new Categoria(-1, "Categoria"));
//
//    try {
//        CallableStatement cbstc = cn.prepareCall("{call LlenarCategoria}");
//        ResultSet rs = cbstc.executeQuery();
//        while (rs.next()) {
//            int IDCategoria = rs.getInt(1);
//            String nombre_categoria = rs.getString(2);
//            Categoria categoria = new Categoria(IDCategoria, nombre_categoria);
//            modelo.addElement(categoria);
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
// 
//    return modelo;
//}

    
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

