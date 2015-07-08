/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.leerarchivo.giwah.utils;

import java.util.Scanner;

/**
 * El Giwiro
 */
public class Receiver {
    
    private final String defaultFileName = "file.txt";
    private final String defaultMensaje = "HELLO WORLD!!";
    private String fileName;
    private String mensaje;
    private Scanner scanner;
    
    public Receiver(){
        this.fileName = defaultFileName;
        this.mensaje = defaultMensaje;
        this.scanner = new Scanner(System.in);
    }
    
    public void init(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Ingrese el nombre del archivo (si no ingresa nada se llamará '"+defaultFileName+"'), NO incluya la extensión: ");
        String t1 = this.scanner.nextLine();
        if (!t1.isEmpty()) {
            this.fileName = t1;
        }
        System.out.println("FileName: " + this.fileName + "\n");
        
        System.out.println("Ingrese el mensaje del archivo (si no ingresa nada se pondrá '"+defaultMensaje+"'): ");
        String t2 = this.scanner.nextLine();
        if (!t2.isEmpty()) {
            this.mensaje = t2;
        }
        System.out.println("FileContent: " + this.mensaje + "\n\n");
        System.out.println("Se crearán 2 archivos: ");
        System.out.println("    (-) " + this.fileName + "-sec.txt >> Es el archivo donde estan los punteros del random access file");
        System.out.println("    (-) " + this.fileName + "-ran.txt >> Es el archivo donde está el mensaje puesto en los luegares de los punteros\n");
        System.out.println("-------------------------------------------------------------------------------------");
    }
    
    public String getFileName(){
        return this.fileName;
    }
    
    public String getMensaje(){
        return this.mensaje;
    }
    
}
