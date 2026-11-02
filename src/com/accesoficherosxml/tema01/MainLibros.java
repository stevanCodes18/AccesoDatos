package com.accesoficherosxml.tema01;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainLibros {
    static void main (){
        try{
            Libro[] libros = Ejercicio3.parsearLibros(Config.ruta3);

            if (libros == null || libros.length == 0){
                System.out.println("No libros para mostrar");
                return;
            }

            Map<String,Integer> conteoGeneros= new HashMap<>();
            Map<String, List<String>> tituloXGeneros= new HashMap<>();

            for (Libro libro : libros){
               if (libro !=null){
                   String titulo = libro.getTitulo();
                   List <String> generos = libro.getGeneros();

                    for (String genero : generos) {
                        conteoGeneros.put(genero,conteoGeneros.getOrDefault(genero,0)+1);
                        tituloXGeneros.computeIfAbsent(titulo,k -> new ArrayList<>()).add(genero);
                    }
               }
            }



            System.out.println("======Libros para mostrar======");
            for (String genero:  conteoGeneros.keySet()){
                int totalLibros= conteoGeneros.get(genero);

                List<String> titulos = tituloXGeneros.getOrDefault(genero,new ArrayList<>());

                System.out.println("Genero: "+ genero);
                System.out.println("Total libros: "+ totalLibros);
                System.out.println("   Titulo:");
                for (String t: titulos) {
                    System.out.println(" - "+ t);
                }
                System.out.println("=========================================");

            }
        } catch(IOException e) {
        System.err.println("Error al leer el fichero de empleados");
    } catch(ParserConfigurationException e) {
        System.err.println("Error al interpretar el fichero de empleados");
    } catch(SAXException e) {
        System.err.println("Error al contruir el DOM jerarquico de empleados");
    }
    }
}
