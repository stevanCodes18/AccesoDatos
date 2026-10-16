package com.stevancodes18.tema1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;


public class Act02 {
    void main(){
        Path rutaD=Path.of("/home/iamstevan/prueba");

        try(Stream<Path> stream= Files.walk(rutaD)){
                   stream
                           .filter(Files::isRegularFile)
                           .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
