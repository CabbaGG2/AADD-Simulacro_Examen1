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

    public static void insertarEntradaVehiculo(String modelo, String marca, int ano, String descripcion) {

        String sql = "INSERT INTO vehiculo (modelo, marca, ano, descripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setString(1,modelo);
            toInsert.setString(2,marca);
            toInsert.setInt(3,ano);
            toInsert.setString(4,descripcion);
            toInsert.executeUpdate();
            System.out.println("Se realizó la inserción con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al insertar la entrada: " + e.getMessage());;
        }
    }

    public static void eliminarTodoNOHACERESTONUNCA(){
        String sql = "DELETE FROM vehiculo";
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toDelete = conn.prepareStatement(sql)) {
            int filasAfectadas = toDelete.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se eliminó TODO de vehiculos inconciente!!!");
            } else {
                System.out.println("No se eliminó nada de la tabla.");
            }
        } catch (SQLException e) {
            System.out.println("Error al tratar de eliminar los datos: " + e.getMessage());;
        }
    }
}
