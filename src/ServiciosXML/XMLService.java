package ServiciosXML;

import Modelos.Vehiculo;

import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLService {
    private static final String XML_FILE_VEHICULOS = "vehiculos.xml";

    public SAXParser crearXMLVehiculo (List<Vehiculo>){
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter((new FileWriter(XML_FILE_VEHICULOS)));

            writer.writeStartDocument("1.0");
            while()

        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
