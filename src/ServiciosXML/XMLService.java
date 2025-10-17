package ServiciosXML;

import Modelos.InventarioTienda;
import Modelos.Vehiculo;

import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLService {
    private static final String XML_FILE_VEHICULOS = "vehiculos.xml";
    private static final String XML_FILE_TIENDAS = "tiendas.xml";

    public static SAXParser crearXMLVehiculo(List<Vehiculo> vehiculos){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter((new FileWriter(XML_FILE_VEHICULOS)));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("vehiculos");

            for (Vehiculo v : vehiculos) {
                writer.writeStartElement("vehiculo");
                writer.writeAttribute("id", String.valueOf(v.getId()));
                writer.writeStartElement("modelo");
                writer.writeCharacters(v.getmodelo());
                writer.writeEndElement();
                writer.writeStartElement("marca");
                writer.writeCharacters(v.getmarca());
                writer.writeEndElement();
                writer.writeStartElement("año");
                writer.writeCharacters(String.valueOf(v.getano()));
                writer.writeEndElement();
                writer.writeStartElement("descripción");
                writer.writeCharacters(v.getdescripcion());
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
            System.out.println("Archivo 'vehiculos.xml' creado con exito.");

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static SAXParser crearXMLTienda(List<InventarioTienda> inventarios){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter((new FileWriter(XML_FILE_TIENDAS)));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("inventarios");

            for (InventarioTienda v : inventarios) {
                writer.writeStartElement("inventario");
                writer.writeAttribute("id", String.valueOf(v.getId()));
                writer.writeStartElement("id_vehiculo");
                writer.writeCharacters(String.valueOf(v.getid_vehiculo()));
                writer.writeEndElement();
                writer.writeStartElement("precio_mayorista");
                writer.writeCharacters(String.valueOf(v.getprezo_mayorista()));
                writer.writeEndElement();
                writer.writeStartElement("precio_venta");
                writer.writeCharacters(String.valueOf(v.getprezo_venta()));
                writer.writeEndElement();
                writer.writeStartElement("porcentaje_oferta");
                writer.writeCharacters(String.valueOf(v.getPorcentaxe_oferta()));
                writer.writeEndElement();
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
            writer.close();
            System.out.println("Archivo 'tiendas.xml' creado con exito.");

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
