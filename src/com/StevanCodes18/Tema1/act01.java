package com.StevanCodes18.Tema1;

import java.io.File;

/*la carpeta donde que utilizare sera /home/iamstevan/prueba */
public class act01 {
    void main(){
        File dir = new File("/home/iamstevan/prueba");
        if(dir.exists() && dir.isDirectory()) {
            IO.println("Es un Directorio");
        }else {
            IO.println("No es un Directorio");
        }
    }
}
