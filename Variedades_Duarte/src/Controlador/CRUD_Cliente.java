
package Controlador;
import Modelo.Cliente;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class CRUD_Cliente {
//esto hace referencia a la conexion a la base de datos   
private final Conexion con = new Conexion();
private final Connection cn = (Connection) con.conectar();

//este es el metodo para mostrar datos llamando a los procediminetos almacenados
    public DefaultTableModel mostrarDatos() {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
            "Telefono", "Genero", "Dirección"};
        String[] registro = new String[7]; //se especifica cuantas columnas va a tener de acuerdo a nuestra base de datos

        modelo = new DefaultTableModel(null, titulos);
        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarCliente}");// aqui llamamos con el nombre que se asigno al procedimiento
            rs = cbstc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("nombre_cliente1");//estas variables tienen que ser las misma como se declararon en la base de datos
                registro[1] = rs.getString("nombre_cliente2");
                registro[2] = rs.getString("apellido_cliente1");
                registro[3] = rs.getString("apellido_cliente2");
                registro[4] = rs.getString("telefono_cliente");
                registro[5] = rs.getString("genero_cliente");
                registro[6] = rs.getString("direccion_cliente");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
public DefaultTableModel buscarDatos(String nombre_cliente1 ) {
    ResultSet rs;
    DefaultTableModel modelo;
     String[] titulos = {"Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
            "Telefono", "Genero", "Dirección"};
    String[] registro = new String[7];
    modelo = new DefaultTableModel(null, titulos);

    try {
        CallableStatement call = cn.prepareCall("{call BuscarCliente(?)}");
        call.setString(1, "nombre_cliente1");
//        call.setString(2, "nombre_cliente2");
//        call.setString(3, "apellido_cliente1");
//        call.setString(4, "apellido_cliente2");
//        call.setString(5,"telefono_cliente");
        rs = call.executeQuery();

        while (rs.next()) {
                  registro[0] = rs.getString("nombre_cliente1");//estas variables tienen que ser las misma como se declararon en la base de datos
                registro[1] = rs.getString("nombre_cliente2");
                registro[2] = rs.getString("apellido_cliente1");
                registro[3] = rs.getString("apellido_cliente2");
                registro[4] = rs.getString("telefono_cliente");
                registro[5] = rs.getString("genero_cliente");
                registro[6] = rs.getString("direccion_cliente");
            modelo.addRow(registro);
        }
        return modelo;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
}

 
    
   

















public void insertarCliente(Cliente cliente) {
        try {
           CallableStatement callableStatement = cn.prepareCall("{call InsertarCliente(?,?,?,?,?,?)}");
            callableStatement.setString(1, cliente.getNombre_cliente1());
            callableStatement.setString(2, cliente.getNombre_cliente2());
            callableStatement.setString(3, cliente.getApellido_cliente1());
            callableStatement.setString(4, cliente.getApellido_cliente2());
            callableStatement.setString(5, cliente.getTelefono_cliente());
            callableStatement.setString(6, String.valueOf(cliente.getGenero_cliente()));
            callableStatement.setString(7, cliente.getDireccion_cliente());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
}

//    public Cliente consultarCliente(int IDCliente) {
//        Cliente cliente = null;
//        try (Connection connection = DriverManager.getConnection(URL)) {
//            String procedureCall = "{call ConsultarCliente(?)}";
//            CallableStatement callableStatement = connection.prepareCall(procedureCall);
//            callableStatement.setInt(1, IDCliente);
//            ResultSet resultSet = callableStatement.executeQuery();
//            if (resultSet.next()) {
//                cliente = new Cliente();
//                cliente.setIDCliente(resultSet.getInt("IDCliente"));
//                cliente.setNombre_cliente1(resultSet.getString("nombre_cliente1"));
//                cliente.setNombre_cliente2(resultSet.getString("nombre_cliente2"));
//                cliente.setApellido_cliente1(resultSet.getString("apellido_cliente1"));
//                cliente.setApellido_cliente2(resultSet.getString("apellido_cliente2"));
//                cliente.setTelefono_cliente(resultSet.getString("telefono_cliente"));
//                cliente.setGenero_cliente(resultSet.getString("genero_cliente").charAt(0));
//                cliente.setDireccion_cliente(resultSet.getString("direccion_cliente"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return cliente;
//    }
//
//    public void actualizarCliente(Cliente cliente) {
//        try (Connection connection = DriverManager.getConnection(URL)) {
//            String procedureCall = "{call ActualizarCliente(?, ?, ?, ?, ?, ?, ?, ?)}";
//            CallableStatement callableStatement = connection.prepareCall(procedureCall);
//            callableStatement.setInt(1, cliente.getIDCliente());
//            callableStatement.setString(2, cliente.getNombre_cliente1());
//            callableStatement.setString(3, cliente.getNombre_cliente2());
//            callableStatement.setString(4, cliente.getApellido_cliente1());
//            callableStatement.setString(5, cliente.getApellido_cliente2());
//            callableStatement.setString(6, cliente.getTelefono_cliente());
//            callableStatement.setString(7, String.valueOf(cliente.getGenero_cliente()));
//            callableStatement.setString(8, cliente.getDireccion_cliente());
//            callableStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void eliminarCliente(int IDCliente) {
//        try (Connection connection = DriverManager.getConnection(URL)) {
//            String procedureCall = "{call EliminarCliente(?)}";
//            CallableStatement callableStatement = connection.prepareCall(procedureCall);
//            callableStatement.setInt(1, IDCliente);
//            callableStatement.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
