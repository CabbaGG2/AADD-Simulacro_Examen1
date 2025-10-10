package ServiciosSerializar;

import Modelos.InventarioTienda;

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
}
