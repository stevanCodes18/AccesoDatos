package com.stevancodes18.tema1;

import java.io.File;

/*la carpeta donde que utilizare sera /home/iamstevan/prueba */
public class Act01 {
    void main(){
        File dir = new File("/home/iamstevan/Files/prueba/hola.txt");
        if (dir.exists()){
            System.out.println(dir.getAbsolutePath() + " Directory exists");
        }
        if (dir.isDirectory()){
            System.out.println(dir.getAbsolutePath() +  " Is a directory");
        }else {
            System.out.println(dir.getAbsolutePath() + " Is not a directory");
        }
    }
}
