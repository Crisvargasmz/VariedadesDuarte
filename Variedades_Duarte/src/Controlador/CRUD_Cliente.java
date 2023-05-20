
package Controlador;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CRUD_Cliente {
 private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=VariedadesDuarte"+
         "integratedSecurity = true;" + " encrypt= true;trustServerCertificate= true;";

    public void insertarCliente(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String procedureCall = "{call InsertarCliente(?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement callableStatement = connection.prepareCall(procedureCall);
            callableStatement.setString(1, cliente.getNombre_cliente1());
            callableStatement.setString(2, cliente.getNombre_cliente2());
            callableStatement.setString(3, cliente.getApellido_cliente1());
            callableStatement.setString(4, cliente.getApellido_cliente2());
            callableStatement.setString(5, cliente.getTelefono_cliente());
            callableStatement.setString(6, String.valueOf(cliente.getGenero_cliente()));
            callableStatement.setString(7, cliente.getDireccion_cliente());
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente consultarCliente(int IDCliente) {
        Cliente cliente = null;
        try (Connection connection = DriverManager.getConnection(URL)) {
            String procedureCall = "{call ConsultarCliente(?)}";
            CallableStatement callableStatement = connection.prepareCall(procedureCall);
            callableStatement.setInt(1, IDCliente);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setIDCliente(resultSet.getInt("IDCliente"));
                cliente.setNombre_cliente1(resultSet.getString("nombre_cliente1"));
                cliente.setNombre_cliente2(resultSet.getString("nombre_cliente2"));
                cliente.setApellido_cliente1(resultSet.getString("apellido_cliente1"));
                cliente.setApellido_cliente2(resultSet.getString("apellido_cliente2"));
                cliente.setTelefono_cliente(resultSet.getString("telefono_cliente"));
                cliente.setGenero_cliente(resultSet.getString("genero_cliente").charAt(0));
                cliente.setDireccion_cliente(resultSet.getString("direccion_cliente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void actualizarCliente(Cliente cliente) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String procedureCall = "{call ActualizarCliente(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement callableStatement = connection.prepareCall(procedureCall);
            callableStatement.setInt(1, cliente.getIDCliente());
            callableStatement.setString(2, cliente.getNombre_cliente1());
            callableStatement.setString(3, cliente.getNombre_cliente2());
            callableStatement.setString(4, cliente.getApellido_cliente1());
            callableStatement.setString(5, cliente.getApellido_cliente2());
            callableStatement.setString(6, cliente.getTelefono_cliente());
            callableStatement.setString(7, String.valueOf(cliente.getGenero_cliente()));
            callableStatement.setString(8, cliente.getDireccion_cliente());
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCliente(int IDCliente) {
        try (Connection connection = DriverManager.getConnection(URL)) {
            String procedureCall = "{call EliminarCliente(?)}";
            CallableStatement callableStatement = connection.prepareCall(procedureCall);
            callableStatement.setInt(1, IDCliente);
            callableStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
