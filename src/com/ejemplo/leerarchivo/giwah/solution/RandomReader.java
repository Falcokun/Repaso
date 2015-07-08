/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.leerarchivo.giwah.solution;

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
public class RandomReader {

    private final String fileType = "ran";
    private final String extension = "txt";
    private File dataFile;
    private RandomAccessFile inputFile;
    private List<Integer> cursors;

    public RandomReader(String fileName) {
        this.dataFile = new File(fileName + "-" + fileType + "." + extension);
        try {
            this.inputFile = new RandomAccessFile(dataFile, "r");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setCursors(List<Integer> c) {
        this.cursors = c;
        System.out.println("RandomReader >> leer cursors: " + this.cursors + "\n");
    }

    public void readFile() {
        System.out.print("Mensaje: ");
        for (int i = 0; i < this.cursors.size(); i++) {
            int c = (int) this.cursors.get(i);
            try {
                inputFile.seek(c);
                System.out.print(inputFile.readChar());
            } catch (IOException ex) {
                Logger.getLogger(RandomReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println();
    }

}
