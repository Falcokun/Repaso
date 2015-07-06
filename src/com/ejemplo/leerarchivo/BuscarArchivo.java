package com.ejemplo.leerarchivo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Ricardo on 06/07/2015.
 * Repaso
 */
public class BuscarArchivo {
    static boolean encontrado;
    static String nombrearchivo = "PSG - Favoritos.txt";
    static long time;

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("C:\\Users\\Ricardo");
        time = System.currentTimeMillis();
        System.out.println("Hora de inicio: " + time);

        buscarArchivo(path);

    }

    private static void buscarArchivo(Path path) throws IOException {
        if (!encontrado) {
            try {
                if (Files.isDirectory(path)) {
                    DirectoryStream<Path> stream = Files.newDirectoryStream(path);
                    for (Path path1 : stream) {
                        buscarArchivo(path1);
                    }
                } else {
                    System.out.println(path.getFileName().toString());
                    if (nombrearchivo.equals(path.getFileName().toString())) {
                        encontrado = true;
                        System.out.println("Encontrado");
                        System.out.println("Tiempo final: " + System.currentTimeMillis());
                        System.out.println("Tiempo Tardado: " + ((System.currentTimeMillis() - time) / 1000) + " segundos");
                    }
                }
            } catch (Exception ignored) {

            }
        }
    }


}
