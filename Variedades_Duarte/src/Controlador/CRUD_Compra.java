/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Compra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHONTAL
 */
public class CRUD_Compra {
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();
    
    public DefaultTableModel mostrarDatos(){
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDCompra" , "Fecha", "Hora", "IDProveedor"};
        String[] registro = new String [4];
        
        modelo = new DefaultTableModel(null,titulos);
        try{
            CallableStatement cbstc = cn.prepareCall("{call ConsultarCompra}");
            rs = cbstc.executeQuery();
            while (rs.next()){
                registro[0] = rs.getString("IDCompra");
                registro[1] = rs.getString("fecha_compra");
                registro[2] = rs.getString("hora_compra");
                registro[3] = rs.getString("IDProveedor");
                modelo.addRow(registro);
            }
            return modelo;
        }   catch (SQLException e){
                    JOptionPane.showMessageDialog(null,e);
                    return null;
                    }
   
    }
    
    public DefaultTableModel buscarDatos(String Dato){
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDCompra", "IDProveedor"};
        String[] registro = new String[2];
        modelo = new DefaultTableModel(null, titulos);
        
        try {
            CallableStatement call = cn.prepareCall("call BuscarCompra(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();
            
            while (rs.next()){
                registro[0] = rs.getString("IDCliente");
                registro[1] = rs.getString("IDProveedor");
                modelo.addRow(registro);
                         
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
          
            }
        
    }
    
    
public void insertarCompra(Compra compra){
        try{
            CallableStatement callableStatement = cn.prepareCall("{call InsertarCompra(?,?,?)}");
            callableStatement.setString(1, compra.getFecha_compra());
            callableStatement.setString(2, compra.getHora_compra());
            callableStatement.setInt(3,compra.getIDProveedor());
            callableStatement.executeUpdate();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            
}
    
}

}