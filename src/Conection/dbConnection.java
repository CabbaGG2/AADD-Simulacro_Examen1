package Conection;
import java.sql.*;

public class dbConnection {
    public static Connection conectar() {
        Connection conn = null;
        String url = "jdbc:postgresql://10.0.9.118:5432/probas";
        String usuario = "postgres";
        String contrasinal = "admin";
        try{
           conn = DriverManager.getConnection(url, usuario, contrasinal);

           return conn;
        } catch (SQLException e) {
            System.out.println("Error conectando a la base de datos: " + e.getMessage());
            return conn;
        }
    }
}
