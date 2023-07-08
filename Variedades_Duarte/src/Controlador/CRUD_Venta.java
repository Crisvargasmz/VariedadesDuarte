//Crud venta
package Controlador;

import Modelo.Detalle_venta;
import Modelo.Producto;
import Modelo.Venta;
import Vistas_formularios.DialogVentaRealizada;
import java.awt.List;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CRUD_Venta {

    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo;

        String[] titulos = {"ID Producto", "Nombre Producto", "Cantidad", "Precio", "Sub Total"};
        modelo = new DefaultTableModel(null, titulos);
        String[] registro = new String[6];
        return modelo;
    }

    public DefaultTableModel mostrarventadia() {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {
            "IDVenta", "Nombre", "Apellido", "Fecha", "Hora"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        try {
            CallableStatement ct = cn.prepareCall("{call MostrarVentasDelDia}");
            rs = ct.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("IDVenta");
                registro[1] = rs.getString("nombre1");
                registro[2] = rs.getString("apellido1");
                registro[3] = rs.getString("fecha_venta");
                registro[4] = rs.getString("hora_venta");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel mostrarDatos() {

        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDVenta", "Fecha", "IDCliente"};
        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);
        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarVenta}");
            rs = cbstc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("IDVenta");
                registro[1] = rs.getString("Fecha");
                registro[2] = rs.getString("IDCliente");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel buscarDatos(String Dato) {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDVenta", "Fecha", "Hora", "IDCliente"};
        String[] registro = new String[3];
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarVenta(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("IDVenta");
                registro[1] = rs.getString("fecha_venta");
                registro[2] = rs.getString("hora_venta");
                registro[3] = rs.getString("IDCliente");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void insertarVenta(Venta venta) {
        try {

            CallableStatement callableStatement = cn.prepareCall("{call InsertarVenta(?,?,?)}");
            callableStatement.setDate(1, venta.getFecha_venta());
            callableStatement.setTime(2, venta.getHora_venta());
            callableStatement.setInt(3, venta.getIDCliente());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

//     public boolean verificarDatos(String dato) {
//        ResultSet rs;
//
//        try {
//            CallableStatement call = cn.prepareCall("{call ConsultarVenta(?)}");
//            call.setString(1, dato);
//            rs = call.executeQuery();
//            return rs.next();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//            return false;
//        }
//    }
//     public void eliminar(String IDVenta) {
//        try {
//            CallableStatement cbst = cn.prepareCall("{call EliminarVenta(?)}");
//            cbst.setString(1, IDVenta);
//            cbst.executeUpdate();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//      public void ActualizarCliente(Venta venta) {
//        try {
//           CallableStatement callableStatement = cn.prepareCall("{call ActualizarVenta(?,?,?,?,?,?,?,?)}");
//            callableStatement.setInt(1, venta.getID_venta());
//           callableStatement.setString(2, venta.getFecha_venta());
//            callableStatement.executeUpdate();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//            e.printStackTrace();
//        }
//    }
    //Metodo para sumar las ventas realizadas por dia
    public int obtenerSumaVentasPorDia() {
        int sumaVentas = 0;
        try {
            CallableStatement ct = cn.prepareCall("{call ObtenerSumaVentasPorDia}");
            ResultSet rs;
            rs = ct.executeQuery();
            if (rs.next()) {
                sumaVentas = rs.getInt("suma_ventas");
                return sumaVentas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Metodo para mostrar el total de ganancias por dia
    public double ObtenerTotalProductosPorDia() {
        int sumaTotal = 0;
        try {
            CallableStatement ct = cn.prepareCall("{call ObtenerTotalProductosPorDia}");
            ResultSet rs;
            rs = ct.executeQuery();
            if (rs.next()) {
                sumaTotal = rs.getInt("total_productos");
                return sumaTotal;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

//    private void obtenerDatosVenta() {
//        // Llamar al procedimiento almacenado
//        String query = "EXEC ConsultarClienteVentaDetalleVenta";
//
//        try {
//            CallableStatement ct = cn.prepareCall("{call ConsultarClienteVentaDetalleVenta}");
//            ResultSet rs;
//            rs = ct.executeQuery();
//            // Variables para almacenar los datos obtenidos
//            String nombreCliente = "";
//            Date fechaVenta = null;
//            Time horaVenta = null;
//            List<Producto> productos = new ArrayList<>();
//
//            // Obtener los datos del resultado de la consulta
//            while (rs.next()) {
//                nombreCliente = rs.getString("nombre1") + " " + rs.getString("nombre2")
//                        + " " + rs.getString("apellido1") + " " + rs.getString("apellido2");
//                fechaVenta = rs.getDate("fecha_venta");
//                horaVenta = rs.getTime("hora_venta");
//
//                int idProducto = rs.getInt("IDProducto");
//                String nombreProducto = rs.getString("nombre_producto");
//                int cantidadVenta = rs.getInt("cantidad_venta");
//                double precioVenta = rs.getDouble("precio_venta");
//
//                Producto producto = new Producto(idProducto, nombreProducto, BigDecimal.valueOf(precioVenta));
//                Detalle_venta dv = new Detalle_venta(cantidadVenta);
//                productos.add(producto);
//            }
//
//            // Actualizar los componentes de la interfaz de usuario
//            DialogVentaRealizada.txtNombreCliente.setText(nombreCliente);
//            DialogVentaRealizada.txtFechaVenta.setText(fechaVenta.toString());
//            DialogVentaRealizada.txtHoraVenta.setText(horaVenta.toString());
//
//            DefaultTableModel tableModel = new DefaultTableModel();
//            tableModel.addColumn("ID Producto");
//            tableModel.addColumn("Nombre Producto");
//            tableModel.addColumn("Cantidad");
//            tableModel.addColumn("Precio");
//
//            for (Producto producto : productos) {
//                Object[] rowData = {
//                    producto.getIDProducto(),
//                    producto.getNombre_producto(),
//                    producto.getCantidad_producto(),
//                producto.getPrecio_venta(),
//            };
//            tableModel.addRow(rowData);
//        }
//
//        DialogVentaRealizada.tableProductosComprado.setModel(tableModel);
//
//    }
//    catch (SQLException e
//
//    
//        ) {
//            e.printStackTrace();
//    }
//}
}
