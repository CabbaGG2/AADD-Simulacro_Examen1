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

    public static List<InventarioTienda> ejecutarSQL() {
        String sql = "SELECT * FROM inventario_tienda";
        List<InventarioTienda> inventariosTienda= new ArrayList<>();
        try (Connection conn = dbConnection.conectar();
             PreparedStatement toRead = conn.prepareStatement(sql);
             ResultSet rs = toRead.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int id_vehiculo = rs.getInt("id_vehiculo");
                int prezo_mayorista = rs.getInt("prezo_mayorista");
                int prezo_venta = rs.getInt("prezo_venta");
                int porcentaxe_oferta = rs.getInt("porcentaxe_oferta");

                Modelos.InventarioTienda inventario = new Modelos.InventarioTienda(id, id_vehiculo, prezo_mayorista, prezo_venta, porcentaxe_oferta);
                System.out.println(inventario);
                inventariosTienda.add(inventario);
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
        }
        return inventariosTienda;
    }

    public static void insertarEntrada(InventarioTienda inventario) {

        String sql = "INSERT INTO inventariotenda (idvehiculo, prezomayorista, prezoventa, porcentaxeoferta) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.conectar();
                PreparedStatement toInsert = conn.prepareStatement(sql)) {

            toInsert.setInt(1,inventario.getid_vehiculo());
            toInsert.setInt(2,inventario.getprezo_mayorista());
            toInsert.setInt(3,inventario.getprezo_venta());
            toInsert.setInt(4,inventario.getPorcentaxe_oferta());

        } catch (SQLException e) {
            System.out.println("Error al insertar la entrada: " + e.getMessage());;
        }
    }
}
