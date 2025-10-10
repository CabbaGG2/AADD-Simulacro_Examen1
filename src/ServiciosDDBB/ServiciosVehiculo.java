package ServiciosDDBB;

import Conection.dbConnection;
import Modelos.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiciosVehiculo {

    public static List<Vehiculo> selectAllVehiculos() {
        String sql = "SELECT * FROM vehiculo";
        List<Vehiculo> vehiculos= new ArrayList<>();
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toRead = conn.prepareStatement(sql);
             ResultSet rs = toRead.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int ano = rs.getInt("ano");
                String descripcion = rs.getString("descripcion");

                Modelos.Vehiculo vehiculo = new Modelos.Vehiculo(id, modelo, marca, ano, descripcion);
                System.out.println(vehiculo);
                vehiculos.add(vehiculo);
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
        }
        return vehiculos;
    }

    public static void insertarEntrada(Vehiculo vehiculo) {

        String sql = "INSERT INTO vehiculo (modelo, marca, ano, descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setString(1,vehiculo.getmodelo());
            toInsert.setString(2,vehiculo.getmarca());
            toInsert.setInt(3,vehiculo.getano());
            toInsert.setString(4,vehiculo.getdescripcion());

        } catch (SQLException e) {
            System.out.println("Error al insertar la entrada: " + e.getMessage());;
        }
    }
}
