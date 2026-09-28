package Tema1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class act04 {
    void main(){
        Path file = Path.of("/home/iamstevan/prueba/hola.txt");


    try{
        LocalDateTime fechaModificacion=LocalDateTime.ofInstant(Files.getLastModifiedTime(file).toInstant(),
            ZoneId.systemDefault());

        if (Files.exists(file)) {
            System.out.println("La ruta absoluta: " + file.toFile().getAbsolutePath());
            System.out.println("Es un archivo oculto :" + file.toFile().isHidden());
            System.out.println("Se puede leer: " + file.toFile().canRead());
            System.out.println("Se puede escribir: " + file.toFile().canWrite());
            System.out.println("Fecha Modificacion : "+fechaModificacion);
            System.out.println("Tamaño: " + file.toFile().length());
        }
    } catch (IOException ioe) {
        throw new RuntimeException("Error : "+ioe.getMessage());
    }

    }

}
