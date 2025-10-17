import Conection.dbConnection;
import Modelos.InventarioTienda;
import Modelos.Vehiculo;
import ServiciosDDBB.ServiciosTienda;
import ServiciosDDBB.ServiciosVehiculo;
import ServiciosSerializar.SerializarService;
import ServiciosXML.XMLService;

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



        /*ServiciosVehiculo.insertarEntradaVehiculo("Mustang","Ford",2021,"Deportivos americanos icónicos");
        ServiciosVehiculo.insertarEntradaVehiculo("Model S","Tesla",2023,"Sedán eléctrico de lujo con gran autonomía");
        ServiciosVehiculo.insertarEntradaVehiculo("Civic","Honda",2020,"Compacto de gran fiabilidad");
        ServiciosVehiculo.insertarEntradaVehiculo("Corvette","Chevrolet",2022,"Deportivo americano con motor V8");
        ServiciosVehiculo.insertarEntradaVehiculo("Prius","Toyota",2022,"Híbrido de bajo consumo y ecológico");
        ServiciosVehiculo.eliminarTodoNOHACERESTONUNCA();
        ServiciosTienda.insertarEntradaTienda(8,25000.00,30000.00,10);
        ServiciosTienda.insertarEntradaTienda(9,40000.00,50000.00,12);
        ServiciosTienda.insertarEntradaTienda(10,18000.00,22000.00,5);
        ServiciosTienda.insertarEntradaTienda(11,60000.00,70000.00,8);
        ServiciosTienda.insertarEntradaTienda(12,25000.00,30000.00,6);*/
        List<Vehiculo> listVehiculos = new ArrayList<>(ServiciosVehiculo.selectAllVehiculos());
        //List<InventarioTienda> listTienda = new ArrayList<>(ServiciosTienda.selectAllTiendas());
        //System.out.println(listVehiculos);
        SerializarService.SerializarVehiculos(listVehiculos);
        List<Vehiculo> listVehiculos2 = new ArrayList<>(SerializarService.DeserializarVehiculos("serialVehiculo"));
        List<InventarioTienda> listInv = new ArrayList<>(ServiciosTienda.selectAllTiendas());
        //System.out.println(listVehiculos2);
        XMLService.crearXMLVehiculo(listVehiculos2);
        XMLService.crearXMLTienda(listInv);
        System.out.println("---------OFERTAS COCHES---------------");
        //ServiciosTienda.modificarOferta(listInv,15);

        List<InventarioTienda> listInvMustang = new ArrayList<>(ServiciosTienda.selectTiendaPorIdVeiculo(8));
        System.out.println("El precio del Ford Mustang con un porcentaje de oferta de: " + listInvMustang.get(0).getPorcentaxe_oferta() + " es: " + ( listInvMustang.get(0).getprezo_venta()- (listInvMustang.get(0).getPorcentaxe_oferta() * listInvMustang.get(0).getprezo_venta()/100)));

    }
}