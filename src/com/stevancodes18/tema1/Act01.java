package com.stevancodes18.tema1;

import java.io.File;

/*la carpeta donde que utilizare sera /home/iamstevan/prueba */
public class Act01 {
    void main(){
        File dir = new File("/home/iamstevan/prueba");
        if(dir.exists() && dir.isDirectory()) {
            IO.println("Es un Directorio");
        }else {
            IO.println("No es un Directorio");
        }
    }
}
