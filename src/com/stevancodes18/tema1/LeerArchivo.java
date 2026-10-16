package com.stevancodes18.tema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//8
public class LeerArchivo {
   public static void main(String[] args) {
      if(args.length < 1){
         System.out.println("Error: debes indicar la ruta del archivo");
         return;
      }

      String rutaArchivo=args[0];
      File archivo=new File(rutaArchivo);
      if(!archivo.exists()){
         System.out.println("Error: archivo "+rutaArchivo+" no existe");
         return;
      }

      if (!archivo.isFile()){
         System.out.println("Error: el archivo" + rutaArchivo +"No es un archivo valido");
         return;
      }

      System.out.println("Archivo: "+archivo.getName());
      try(BufferedReader br=new BufferedReader(new FileReader(archivo))){
         String linea;
         while((linea=br.readLine())!=null){
            System.out.println(linea);
         }
      }catch (IOException ioe){
         System.out.println("Error: "+ioe.getMessage());
      }
   }
}
