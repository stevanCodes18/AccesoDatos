package com.accesoficherosxml.tema01;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MainParsers {
    static void main(){
        try{
            Empleado[] empleados= Ejercicio1.parsearEmpleados(Config.ruta);
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero de empleados");
        } catch (ParserConfigurationException e) {
            System.err.println("Error al interpretar el fichero de empleados");
        } catch (SAXException e) {
            System.err.println("Error al contruir el DOM jerarquico de empleados");
        }
    }
}
