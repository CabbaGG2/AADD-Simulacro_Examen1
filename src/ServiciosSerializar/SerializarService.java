package ServiciosSerializar;

import Modelos.InventarioTienda;
import Modelos.Vehiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializarService {

    public void SerializarInventarioTienda (List<InventarioTienda> inventarioTiendas){
        try(FileOutputStream fos = new FileOutputStream("serialTienda");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(inventarioTiendas);
            System.out.println("Lista guardada en 'serialTienda' con exito.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());;
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    public List<InventarioTienda> DeserializarInventarioTienda (String ruta) {
        List<InventarioTienda> inventariosTienda= new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            inventariosTienda  = (List<InventarioTienda>) ois.readObject();
            System.out.println("Objeto cargado desde: " + ruta + " con exito");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " +e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());;
        }
        return inventariosTienda;
    }

    public static void SerializarVehiculos(List<Vehiculo> vehiculos){
        try(FileOutputStream fos = new FileOutputStream("serialVehiculo");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(vehiculos);
            System.out.println("Lista guardada en 'serialVehiculo' con exito.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());;
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }

    public static List<Vehiculo> DeserializarVehiculos(String ruta) {
        List<Vehiculo> vehiculos= new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            vehiculos  = (List<Vehiculo>) ois.readObject();
            System.out.println("Objeto cargado desde: " + ruta + " con exito");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " +e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Clase no encontrada: " + e.getMessage());;
        }
        return vehiculos;
    }

}
