package ServiciosDDBB;

import Conection.dbConnection;
import Modelos.InventarioTienda;
import Modelos.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiciosTienda {

    public static List<InventarioTienda> selectAllTiendas() {
        String sql = "SELECT * FROM inventariotenda";
        List<InventarioTienda> inventariosTienda= new ArrayList<>();
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toRead = conn.prepareStatement(sql);
             ResultSet rs = toRead.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int id_vehiculo = rs.getInt("idvehiculo");
                int prezo_mayorista = rs.getInt("prezomayorista");
                int prezo_venta = rs.getInt("prezoventa");
                int porcentaxe_oferta = rs.getInt("porcentaxeoferta");

                Modelos.InventarioTienda inventario = new Modelos.InventarioTienda(id, id_vehiculo, prezo_mayorista, prezo_venta, porcentaxe_oferta);
                System.out.println(inventario);
                inventariosTienda.add(inventario);
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
        }
        return inventariosTienda;
    }

    public static List<InventarioTienda> selectTiendaPorIdVeiculo(int idQuery) {
        String sql = "SELECT * FROM inventariotenda WHERE idvehiculo = ?";
        List<InventarioTienda> invTienda = new ArrayList<>();
        try (Connection  conn = dbConnection.conectar();
            PreparedStatement toRead = conn.prepareStatement(sql)) {

            toRead.setInt(1,idQuery);
            try (ResultSet resultSet = toRead.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int id_vehiculo = resultSet.getInt("idvehiculo");
                    int prezo_mayorista = resultSet.getInt("prezomayorista");
                    int prezo_venta = resultSet.getInt("prezoventa");
                    int porcentaxe_oferta = resultSet.getInt("porcentaxeoferta");

                    Modelos.InventarioTienda inventario = new Modelos.InventarioTienda(id, id_vehiculo, prezo_mayorista, prezo_venta, porcentaxe_oferta);
                    System.out.println(inventario);
                    invTienda.add(inventario);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
        }
        return invTienda;
    }

    public static void insertarEntradaTienda(int idVehiculo, double prezoMayorista, double prezoVenta, int porcentaxeOferta) {

        String sql = "INSERT INTO inventariotenda (idvehiculo, prezomayorista, prezoventa, porcentaxeoferta) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.conectar();
                PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setInt(1,idVehiculo);
            toInsert.setDouble(2,prezoMayorista);
            toInsert.setDouble(3,prezoVenta);
            toInsert.setInt(4,porcentaxeOferta);
            toInsert.executeUpdate();
            System.out.println("Se realizó la inserción con éxito.");

        } catch (SQLException e) {
            System.out.println("Error al insertar la entrada: " + e.getMessage());;
        }
    }

    public static void eliminarTodoNOHACERESTONUNCA(){
        String sql = "DELETE * FROM inventariotenda";
        try (Connection conn = dbConnection.conectar();
            PreparedStatement toDelete = conn.prepareStatement(sql)) {
            int filasAfectadas = toDelete.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Se eliminó TODO de tiendas inconciente!!!");
            } else {
                System.out.println("No se eliminó nada de la tabla.");
            }
        } catch (SQLException e) {
            System.out.println("Error al tratar de eliminar los datos: " + e.getMessage());;
        }
    }

    public static void modificarOferta(List<InventarioTienda> inventarios, int numero){
        String sql = "UPDATE inventariotenda SET porcentaxeoferta = porcentaxeoferta + ?";
        try(Connection conn = dbConnection.conectar();
            PreparedStatement actualizar = conn.prepareStatement(sql)) {
            actualizar.setInt(1,numero);

            int filasAfectadas = actualizar.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Entradas actualizadas correctamente");
            } else {
                System.out.println("No se encontró ninguna entrada valida para actualizar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el porcentaje de oferta: " + e.getMessage());;
        }
    }
}
