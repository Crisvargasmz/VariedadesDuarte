package Controlador;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {

    private final String url = "jdbc:sqlserver://localhost:55656;databaseName=VariedadesDuarte;" + "integratedSecurity=true;"
            + "encrypt=true;trustServerCertificate=true; user=sa; password=2004";
    Connection cn;

    public Connection conectar() {
        try {
            cn = DriverManager.getConnection(url);
            System.out.println("Conexion establecida");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e);
        }
        return null;
    }

}
