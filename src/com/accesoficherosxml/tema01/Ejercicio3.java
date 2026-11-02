package com.accesoficherosxml.tema01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
        private Ejercicio3(){}

    public static Libro[] parsearLibros(String ruta) throws IOException, ParserConfigurationException, SAXException {
            Libro[] libros = null;

            try(FileInputStream fis= new FileInputStream(ruta)){
                DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
                DocumentBuilder builder= factory.newDocumentBuilder();

                Document dom= builder.parse(fis);
                dom.getDocumentElement().normalize();

                NodeList items=dom.getElementsByTagName("libro");
                libros = new Libro[items.getLength()];

                for ( int i = 0; i < items.getLength(); i++ ) {
                    Element libroEtiqueta= (Element) items.item(i);

                    String isbn=libroEtiqueta.getAttribute("isbn");
                    String titulo=libroEtiqueta.getElementsByTagName("titulo").item(0).getTextContent();

                    Element autorElemento=(Element) libroEtiqueta.getElementsByTagName("autor").item(0);
                    String nombreAutor=autorElemento.getElementsByTagName("nombre").item(0).getTextContent();
                    LocalDate fechaNacimiento=LocalDate.parse(libroEtiqueta.getElementsByTagName("nacimiento").item(0).getTextContent());

                    int anio=Integer.parseInt(libroEtiqueta.getElementsByTagName("anio").item(0).getTextContent());

                    List<String> listaGeneros = new ArrayList<>();
                    NodeList generosContainerList = libroEtiqueta.getElementsByTagName("generos");
                    if (generosContainerList.getLength() > 0) {
                        Element generosElemento = (Element) generosContainerList.item(0);
                        NodeList generoItems = generosElemento.getElementsByTagName("genero");
                        for (int j = 0; j < generoItems.getLength(); j++) {
                            String gen = generoItems.item(j).getTextContent();
                            if (gen != null && !gen.isEmpty()) {
                                listaGeneros.add(gen);
                            }
                        }
                    }
                    boolean disponible=Boolean.parseBoolean(libroEtiqueta.getAttribute("disponible"));



                    libros[i]=new Libro(isbn,titulo,nombreAutor,fechaNacimiento,anio,listaGeneros,disponible);
                }

            }
            return libros;
    }
}
