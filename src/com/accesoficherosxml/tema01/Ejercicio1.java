package com.accesoficherosxml.tema01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;


public class Ejercicio1 {
     private Ejercicio1(){}

    public static Empleado[] parsearEmpleados(String ruta) throws IOException, ParserConfigurationException, SAXException {
        /*Inicializamos a null el array de empleados*/
        Empleado[] empleados = null;

        try(FileInputStream fis= new FileInputStream(ruta)){
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document dom = builder.parse(fis);

            dom.getDocumentElement().normalize();

            NodeList items= dom.getElementsByTagName("empleado");
            empleados= new Empleado[items.getLength()];
            for (int i = 0; i < items.getLength(); i++) {
                Element empleadoEtiqueta = (Element) items.item(i);
                String id=empleadoEtiqueta.getAttribute("id");
                String nombre=empleadoEtiqueta.getElementsByTagName("nombre").item(0).getTextContent();
                String departamento=empleadoEtiqueta.getElementsByTagName("departamento").item(0).getTextContent();
                Element salarioElemento= (Element) empleadoEtiqueta.getElementsByTagName("salario").item(0);
                String moneda= salarioElemento.getAttribute("moneda");
                double salario= Double.parseDouble(salarioElemento.getTextContent());
                String fechaAlta= empleadoEtiqueta.getElementsByTagName("fechaAlta").item(0).getTextContent();
                LocalDate fecha= LocalDate.parse(fechaAlta);
                empleados[i]= new Empleado(id,nombre,departamento,moneda,salario, fecha);


                }
            }
        return empleados;
        }

    }



