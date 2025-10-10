import Conection.dbConnection;
import Modelos.Vehiculo;
import ServiciosDDBB.ServiciosVehiculo;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        dbConnection dbConn = new dbConnection();
        Connection conn = dbConn.conectar();
        if (conn != null) {
            System.out.println("Conexión exitosa a la Base de datos");
        } else {
            System.out.println("Fallo la conexión a la base de datos");
        }
        List<Vehiculo> listVehiculos = new ArrayList<>(ServiciosVehiculo.selectAllVehiculos());
        System.out.println(listVehiculos);


    }
}