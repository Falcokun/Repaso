package com.ejemplo.leerarchivo.giwah;/*
 * Este contenido consiste en un generador (simulador)
 * de 3 archivos que se parecen a lo que dijo Irey
 * 
 */


import com.ejemplo.leerarchivo.giwah.solution.RandomReader;
import com.ejemplo.leerarchivo.giwah.solution.SecuentialReader;
import com.ejemplo.leerarchivo.giwah.utils.RandomWritter;
import com.ejemplo.leerarchivo.giwah.utils.Receiver;
import com.ejemplo.leerarchivo.giwah.utils.SecuentialWritter;

/**
 * El Giwiro
 */
public class FilesGenerator {


    /**
     * Clase para pruebas que crea 2 archivos con la logica para probar el codigo
     */
    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        receiver.init();
        String fileName = receiver.getFileName();
        String mensaje = receiver.getMensaje();

        SecuentialWritter sw = new SecuentialWritter(fileName);
        sw.generateRandomCursors(receiver.getMensaje());
        sw.writeFile();

        RandomWritter rw = new RandomWritter(fileName, mensaje);
        rw.setCursors(sw.getCursors());
        rw.writeFile();

        //Esta sería la solución

        //sin extensión y el programa se encarga de completarlo con (**nombre**)-sec.txt, (**nombre**)-ran.txt
        String nombreDelArchivo = fileName;

        SecuentialReader sr = new SecuentialReader();
        sr.setFileName(nombreDelArchivo);
        sr.readFile();

        RandomReader rr = new RandomReader(fileName);
        rr.setCursors(sr.getCursors());
        rr.readFile();

        System.out.println("By Giwiro");


    }

}
