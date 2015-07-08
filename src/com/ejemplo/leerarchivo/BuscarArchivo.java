package com.ejemplo.leerarchivo;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by Ricardo on 06/07/2015.
 * Repaso
 */
public class BuscarArchivo {
    static boolean encontrado;
    static String nombrearchivo = "PruebaRepasoJava-sec.txt";
    static long time;

    public static void main(String[] args) throws IOException {
        //Todo: Cambiar ruta de busqueda:
        Path path = FileSystems.getDefault().getPath("C:\\");
        path = FileSystems.getDefault().getPath("C:\\Users\\Ricardo\\Dropbox\\Ulima\\2015-1");
        time = System.currentTimeMillis();
        System.out.println("Hora de inicio: " + time);
        buscarArchivo(path);
    }

    /**
     * Funcion que busca un archivo con un nombre especifico en el arbol del directorio
     */
    private static void buscarArchivo(Path path) throws IOException {
        //Si no esta encontrado, si es true, deja de buscar
        if (!encontrado) {
            try {
                if (Files.isDirectory(path)) {
                    //Si el path corresponde a un directorio, entonces se aplica esta funcion a cada elemento
                    DirectoryStream<Path> stream = Files.newDirectoryStream(path);
                    for (Path path1 : stream) {
                        buscarArchivo(path1);
                    }
                } else {
                    //Si el path no es directorio, es decir, es un archivo, se realiza la comparacion de nombre

                    //Print opcional para ver que se esta recorriendo
                    //System.out.println(path.getFileName().toString());

                    //Si el nombre del archivo es el que estamos buscando
                    if (nombrearchivo.equals(path.getFileName().toString())) {
                        encontrado = true;
                        System.out.println("Encontrado");
                        System.out.println("Tiempo final: " + System.currentTimeMillis());
                        System.out.println("Tiempo Tardado: " + ((System.currentTimeMillis() - time) / 1000) + " segundos");
                        System.out.println("El archivo estaba en:\n" + path);
                        leerArchivoBase(path);
                    }
                }
            } catch (Exception ignored) {
                /*
                * Este try cath existe porque algunos directorios son protegidos de sistema
                * si no fuera, crashea y la busqueda se detiene.
                */
            }
        }
    }

    private static void leerArchivoBase(Path path) {
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(path.toString());
            BufferedInputStream reader = new BufferedInputStream(inputFile);
            DataInputStream buf = new DataInputStream(reader);
            ArrayList<Integer> indices = new ArrayList<>();
            Integer temp;
            while (buf.available() > 0) {
                temp = buf.readInt();
                System.out.println("Linea: " + temp);
                indices.add(temp);
            }
            leerArchivoRandom(indices);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerArchivoRandom(ArrayList<Integer> indices) {
        try {
            File dataFile = new File("PruebaRepasoJava-ran.txt");
            RandomAccessFile inputFile = null;
            inputFile = new RandomAccessFile(dataFile, "r");
            String mensaje = "";
            for (Integer indice : indices) {
                inputFile.seek(indice);
                mensaje += inputFile.readChar();
            }
            System.out.println(mensaje);
            inputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
