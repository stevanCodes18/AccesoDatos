package com.stevancodes18.tema1;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class GestionArchivos {
    //A
    public boolean crearArchivo(String directorio, String archivo) {
        File dir = new File(directorio);
        //crea la carpeta si no existe
        if (!dir.exists()) {
            dir.mkdir();
        }
        //ruta completa
        File ArchivoNuevo = new File(dir,archivo);
        try {
            return ArchivoNuevo.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
            return false;
        }
    }
//B
    public void listarDirectorio(String directorio) {
        File dir = new File(directorio);
        if (!dir.exists() && !dir.isDirectory()) {
            System.out.println("No se encontro el directorio");
            return;
        }
        //obtener la lista de archivos y subD
        File[] contenido = dir.listFiles();
        if (contenido == null) {
            System.out.println("No se puede leer el contenido (permiso debegado)");
            return;
        }
        //recorrer y mostrar contenido de info
        for (File elemento : contenido) {
            String tipo = elemento.isDirectory() ? "directorio" : "archivo";
            long size = elemento.length();

            String permisos = (elemento.canRead() ? "r" : "-") + (elemento.canWrite() ? "w" : "-");

            System.out.println(elemento.getName() + " " + tipo + " " + size + " bytes " + permisos);

        }
    }
//C
    public void verInfo(String directorio, String archivo) {
        File archivoInfo = new File(directorio, archivo);

        if (archivoInfo.exists()) {
            System.out.println("El directorio o archivo no existe");
            return;
        }

        System.out.println("Nombre: " + archivoInfo.getName());
        System.out.println("Ruta: " + archivoInfo.getAbsolutePath());
        System.out.println("Se puede ecribir: " + archivoInfo.canWrite());
        System.out.println("Se puede leer: " + archivoInfo.canRead());
        System.out.println("Tamaño: " + archivoInfo.length());
        System.out.println("¿Es un directorio: " + (archivoInfo.isDirectory() ? "directorio" : "archivo"));
        System.out.println("¿Es un archivo?: " + (archivoInfo.isFile() ? "archivo" : "directorio"));

    }

//6
    public void leerArchivo(String directorio, String archivo) {
        File elemento = new File(directorio, archivo);
        if (!elemento.exists() || !elemento.isFile()) {
            System.out.println("El archivo no existe o no es un directorio valido");
            return;
        }
        System.out.println("Nombre archivo: " + elemento.getName());

        try (BufferedReader br = new BufferedReader(new FileReader(elemento))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }

    }

//7
    public  void verContenido(String directorio, String archivo) {
        File elemento = new File(directorio, archivo);

        if (!elemento.exists() || !elemento.isFile()) {
            System.out.println("El archivo no existe o no es un contenido");
            return;
        }

        try (InputStream bis = new FileInputStream(elemento)) {
            int caracter;
            while ((caracter = bis.read()) != -1) {
                System.out.printf("%02x", caracter);
            }
            System.out.println();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
        }
    }

    //9
    public  boolean compararArchivo(String ruta1, String ruta2) {
        File f1=new  File(ruta1);
        File f2=new  File(ruta2);

        if (!f1.exists() || !f2.exists() || !f1.isFile() || !f2.isFile()) {
            System.out.println("Error: uno o ambos archivos no existen o no son ficheros");
            return false;
        }

        if (f1.length() != f2.length()) {
            return false;
        }

        try(
                InputStream is1=new BufferedInputStream(new FileInputStream(f1));
                InputStream is2=new BufferedInputStream(new FileInputStream(f2))
                ){
            int byte1, byte2;
            while ((byte1 = is1.read()) != -1) {
                byte2 = is2.read();

                if (byte1 != byte2) {
                    return false;
                }
            }
            return true;

        }catch (IOException ioe){
            System.out.println("Error al comparar los archivos: " + ioe.getMessage());
            return false;
        }


    }
//10
    public  boolean concat(String archivo1, String archivo2,String archivoDestino) throws  FileNotFoundException, FileAlreadyExistsException {
        File f1=new  File(archivo1);
        File f2=new  File(archivo2);
        File fDestino=new  File(archivoDestino);

        if(!f1.exists() || !f1.isFile()){
            throw new FileNotFoundException("El archivo no existe o no es un archivo");
        }

        if(!f2.exists() || !f2.isFile()){
            throw new FileNotFoundException("El archivo no existe o no es un archivo");
        }
        if(fDestino.exists()){
            throw new FileAlreadyExistsException("El archivo ya existe: "+archivoDestino);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fDestino))){

            try(BufferedReader br1=new BufferedReader(new FileReader(f1))){
                String linea;
                while ((linea = br1.readLine()) != null){
                    bw.write(linea);
                    bw.newLine();
                }
            }

            try(BufferedReader br2= new BufferedReader(new FileReader(f2))){
                String linea;
                while((linea = br2.readLine()) !=null){
                    bw.write(linea);
                    bw.newLine();
                }
            }

            return true;


        }catch (IOException ioe){
            System.out.println("Error al concatenar los archivos: " + ioe.getMessage());
            return false;
        }
    }

//11
    public  boolean concatLines(String archivo1,String archivo2,String archivoDestino) throws  FileNotFoundException, FileAlreadyExistsException {
        File f1=new  File(archivo1);
        File f2=new  File(archivo2);
        File fileDestino=new  File(archivoDestino);

        //validacion de archivos si existen
        if(!f1.exists() || !f1.isFile() || f2.exists() || !f2.isFile()){
            System.out.println("Error: el archivo no existe o no es un archivo");
            return false;
        }

        try (
                BufferedReader br1=new BufferedReader(new FileReader(f1));
                BufferedReader br2=new BufferedReader(new FileReader(f2));
        BufferedWriter bw= new BufferedWriter(new FileWriter(fileDestino))
                ){
            String linea1=br1.readLine();
            String linea2=br2.readLine();

            while(linea1 != null || linea2 != null){
                String texto1=(linea1==null)?linea1:"";
                String texto2=(linea2==null)?linea2:"";

                bw.write(texto1+texto2);
                bw.newLine();

                //lee las linea siguiente solo de los archivos que no llegaron al final
                linea1=(linea1==null)? br1.readLine() : null;
                linea2=(linea2==null)? br2.readLine() : null;
            }
            return true;



        }catch (IOException ioe){
            System.out.println("Error al concatenar los archivos: " + ioe.getMessage());
            return false;
        }



    }



    void main(){
    //uso de los metodos


        //a
        boolean archivo=crearArchivo("Documents","nuevo.txt");
        System.out.println("El archivo es: "+archivo);

        //b

    }
}
