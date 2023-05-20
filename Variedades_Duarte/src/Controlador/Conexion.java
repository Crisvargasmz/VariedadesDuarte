
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
   
    private static Connection conectar (){
    String conexionUrl = "jdbc:sqlserver://localhost:1433;databaseName= BD_ELGUSTAZO;"
            + "integratedSecurity = true;" + " encrypt= true;trustServerCertificate= true;";
       try {
        Connection cn = DriverManager.getConnection(conexionUrl);
           System.out.println("Conexion correcta" + cn);
        return cn;
        } catch (SQLException e){
        System.out.println("Error en la conexion" + e);
        return null;
      }
   }
}
