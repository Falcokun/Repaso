package com.ejemplo.leerarchivo.giwah.utils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * El Giwiro
 */
public class RandomWritter implements Writter {
    
    private File dataFile;
    private final String fileType = "ran";
    private final String extension = "txt";
    private RandomAccessFile outputFile;
    private List<Integer> cursors;
    private String mensaje;
    
    public RandomWritter (String fileName, String mensaje) {
        dataFile = new File(fileName);
        this.mensaje = mensaje;
        try {
            outputFile = new RandomAccessFile(dataFile+"-"+fileType+"."+extension, "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomWritter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCursors(List<Integer> list){
        this.cursors = list;
    }

    @Override
    public void writeFile() {
        
        for (int i = 0; i < this.cursors.size(); i++) {
            int cursor = (int)this.cursors.get(i);
            char letra = mensaje.charAt(i);
            try {
                outputFile.seek(cursor);
                outputFile.writeChar(letra);
            } catch (IOException ex) {
                Logger.getLogger(RandomWritter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        System.out.println("RandomWritter >> escribiendo mensaje: " + mensaje);
        System.out.println("-------------------------------------------------------------------------------------");
    }
    
}
