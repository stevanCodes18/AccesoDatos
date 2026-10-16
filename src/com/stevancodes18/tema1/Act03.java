package com.stevancodes18.tema1;

import java.nio.file.Files;
import java.nio.file.Path;

public class Act03 {
    void main(){
        Path ruta = Path.of("/home/iamstevan/prueba");
//el metodo toFile() lo utilizo para convertir un objeto de tipo Path en uno de tipo file
        if (Files.exists(ruta)){
            System.out.println("Nombre del directorio: "+ruta.getFileName());
            System.out.println("Ruta Absoluta: "+ruta.toAbsolutePath());
            System.out.println("Se puede leer: "+ ruta.toFile().canRead());
            System.out.println("se puede escribir: "+ ruta.toFile().canWrite());
        }



    }
}

