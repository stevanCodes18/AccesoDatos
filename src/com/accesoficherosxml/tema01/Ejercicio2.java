package com.accesoficherosxml.tema01;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio2 {
    static void main(){
        try{
            Empleado[] empleados=Ejercicio1.parsearEmpleados(Config.ruta);

            if (empleados == null || empleados.length == 0){
                System.out.println("No se han encontrado empleados");
                return;
            }

            Map<String,Double> sumaSalarios=new HashMap<>();
            Map<String,Integer> nEmpleados =new HashMap<>();

            for (Empleado empleado : empleados) {
                if(empleado!=null){
                    String depto=empleado.getDepartamento();
                    double salario =empleado.getSalario();


                    sumaSalarios.put(depto,sumaSalarios.getOrDefault(depto,0.0)+salario);
                    nEmpleados.put(depto,nEmpleados.getOrDefault(depto,0)+1);


                }
            }
            System.out.println("\n");
            System.out.println("Departamento |"+" Cantidad de empleados |"+" Salario medio");
            System.out.println("========================================================================");

            for (String depto: nEmpleados.keySet()) {
                int numEmpleados = nEmpleados.get(depto);
                double sumaTotal=sumaSalarios.get(depto);
                double salarioMedio=sumaTotal/numEmpleados;

                System.out.print(depto+" |"+numEmpleados+" | "+salarioMedio);
            }

        }catch (IOException e) {
            System.err.println("Error al leer el fichero de empleados");
        } catch (ParserConfigurationException e) {
            System.err.println("Error al interpretar el fichero de empleados");
        } catch (SAXException e) {
            System.err.println("Error al contruir el DOM jerarquico de empleados");
        }
    }
}
