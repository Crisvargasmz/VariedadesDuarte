//Crud cliente
package Controlador;

import Modelo.Cliente;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

public class CRUD_Cliente {

//esto hace referencia a la conexion a la base de datos   
    private final Conexion con = new Conexion();
    private final Connection cn = (Connection) con.conectar();

    private DefaultComboBoxModel<String> comboBoxModel;

//este es el metodo para mostrar datos llamando a los procediminetos almacenados
    public DefaultTableModel mostrarDatos() {

        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDPersona", "IDCliente", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
            "Telefono", "Genero", "Dirección"};
        String[] registro = new String[9]; //se especifica cuantas columnas va a tener de acuerdo a nuestra base de datos

        modelo = new DefaultTableModel(null, titulos);
        try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarCliente}");// aqui llamamos con el nombre que se asigno al procedimiento
            rs = cbstc.executeQuery();
            while (rs.next()) {
                registro[0] = rs.getString("IDPersona");
                registro[1] = rs.getString("IDCliente");
                registro[2] = rs.getString("nombre1");//estas variables tienen que ser las misma como se declararon en la base de datos
                registro[3] = rs.getString("nombre2");
                registro[4] = rs.getString("apellido1");
                registro[5] = rs.getString("apellido2");
                registro[6] = rs.getString("telefono");
                registro[7] = rs.getString("genero_cliente");
                registro[8] = rs.getString("direccion");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultComboBoxModel mostraCombo(){
        ResultSet rs;
        DefaultComboBoxModel modelo;
        String[] registro = new String[9]; //se especifica cuantas columnas va a tener de acuerdo a nuestra base de datos

        modelo = new DefaultComboBoxModel(registro);
           try {
            CallableStatement cbstc = cn.prepareCall("{call ConsultarClienteCombo}");// aqui llamamos con el nombre que se asigno al procedimiento
            rs = cbstc.executeQuery();

            // Crear el modelo del JComboBox
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

            // Iterar sobre los resultados y añadir los clientes al modelo
            while (rs.next()) {
                String idCliente = rs.getString("IDCliente");
                String nombreUno = rs.getString("nombre1");
                String nombreDos = rs.getString("nombre2");
                String apellidoUno = rs.getString("apellido1");
                String apellidoDos = rs.getString("apellido2");
                String cliente = idCliente + ": " + nombreUno + " " + nombreDos + " " + apellidoUno + " " + apellidoDos;
                comboBoxModel.addElement(cliente);
            }
            return this.comboBoxModel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public DefaultTableModel buscarDatos(String Dato) {
        ResultSet rs;
        DefaultTableModel modelo;
        String[] titulos = {"IDPersona","IDCliente", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
            "Telefono", "Genero", "Direcion"};
        String[] registro = new String[9];
        modelo = new DefaultTableModel(null, titulos);

        try {
            CallableStatement call = cn.prepareCall("{call BuscarCliente(?)}");
            call.setString(1, Dato);
            rs = call.executeQuery();

            while (rs.next()) {
                registro[0] = rs.getString("IDPersona");
                registro[1] = rs.getString("IDCliente");
                registro[2] = rs.getString("nombre1");//estas variables tienen que ser las misma como se declararon en la base de datos
                registro[3] = rs.getString("nombre2");
                registro[4] = rs.getString("apellido1");
                registro[5] = rs.getString("apellido2");
                registro[6] = rs.getString("telefono");
                registro[7] = rs.getString("genero_cliente");
                registro[8] = rs.getString("direccion");

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
            CallableStatement callableStatement = cn.prepareCall("{call InsertarPersonaCliente(?,?,?,?,?,?,?)}");
            callableStatement.setString(1, cliente.getNombre1());
            callableStatement.setString(2, cliente.getNombre2());
            callableStatement.setString(3, cliente.getApellido1());
            callableStatement.setString(4, cliente.getApellido2());
            callableStatement.setString(5, cliente.getDireccion());
            callableStatement.setString(6, cliente.getTelefono());
            callableStatement.setString(7, String.valueOf(cliente.getGenero_cliente()));

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public DefaultComboBoxModel BuscarClientesCombo(String datos) {
        // Crea el ArrayList para almacenar los datos de los registros
        ArrayList<String> listaRegistros = new ArrayList<>();
        DefaultComboBoxModel model;
        model = new DefaultComboBoxModel();
        ResultSet rs;
        String[] registros = new String[8];
        try {

            CallableStatement call = cn.prepareCall("{call BuscarClienteCombo(?)}");
            call.setString(1, datos);
            rs = call.executeQuery();

            // Recorre el conjunto de resultados y agrega los datos al ArrayList
            while (rs.next()) {
                String idCliente = rs.getString("IDCliente");
                String nombreUno = rs.getString("nombre1");
                String nombreDos = rs.getString("nombre2");
                String apellidoUno = rs.getString("apellido1");
                String apellidoDos = rs.getString("apellido2");
                String registro = idCliente + ": " + nombreUno + " " + nombreDos + " " + apellidoUno + " " + apellidoDos;
                listaRegistros.add(registro);
                model.addElement(listaRegistros);
            }
            return model;


        } catch (SQLException e) {
            return null;
        }
    }

    public boolean verificarDatos(String dato) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call ConsultarClientes(?)}");
            call.setString(1, dato);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean verificarTelefonoCliente(String numeroTelefono) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call VerificarTelefonoExistente(?)}");
            call.setString(1, numeroTelefono);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    
    public boolean verificarTelefonoClienteActualizado(int IDPersona, String numeroTelefono) {
        ResultSet rs;

        try {
            CallableStatement call = cn.prepareCall("{call VerificarTelefonoActualizado(?,?)}");
            call.setInt(1, IDPersona);
            call.setString(2, numeroTelefono);
            rs = call.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public void eliminar(String IDCliente) {
        try {
            CallableStatement cbst = cn.prepareCall("{call EliminarClienteVenta(?)}");
            cbst.setString(1, IDCliente);
            cbst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarCliente(Cliente cliente) {
        try {
            CallableStatement callableStatement = cn.prepareCall("{call ActualizarPersonaCliente(?,?,?,?,?,?,?,?,?)}");
            callableStatement.setInt(1, cliente.getIDPersona());
             callableStatement.setInt(2, cliente.getIDCliente());
            callableStatement.setString(3, cliente.getNombre1());
            callableStatement.setString(4, cliente.getNombre2());
            callableStatement.setString(5, cliente.getApellido1());
            callableStatement.setString(6, cliente.getApellido2());
            callableStatement.setString(7, cliente.getTelefono());
            callableStatement.setString(8, String.valueOf(cliente.getGenero_cliente()));
            callableStatement.setString(9, cliente.getDireccion());
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
