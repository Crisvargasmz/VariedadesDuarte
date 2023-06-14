/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows 10
 */
public class CRUD_Detalle_venta {

    private Conexion SQL = new Conexion();
    private Connection cn = SQL.conectar();

    public DefaultTableModel mostrarDatos() {

        ResultSet rs;

        DefaultTableModel modelo;

        String[] titulos = {"ID", "Cantidad","ID Venta", "ID Producto"};

        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);
        try {

            CallableStatement cbstc = cn.prepareCall("{call ConsultarDetalle_venta}");
            rs = cbstc.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("ID_DVenta");
                registro[1] = rs.getString("cantidad_venta");
                registro[2] = rs.getString("IDVenta");
                registro[3] = rs.getString("IDProducto");

                modelo.addRow(registro);
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public void insertarProducto(Venta detalle) {
    try {
        CallableStatement callableStatement = cn.prepareCall("{call InsertarVentaConDetalle(?,?,?)}");
        callableStatement.setInt(1, detalle.getIDCliente());
        callableStatement.setInt(2, detalle.getCantidad_venta());
        callableStatement.setInt(3, detalle.getIDProducto());
        callableStatement.executeUpdate();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
        e.printStackTrace();
    }
}
}
