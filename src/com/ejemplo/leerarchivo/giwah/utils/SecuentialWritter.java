/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo.leerarchivo.giwah.utils;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * El Giwiro
 */
public class SecuentialWritter implements Writter {

    private final static int MAX_CURSOR = 10000;
    private final String fileType = "sec";
    private final String extension = "txt";
    private List<Integer> cursors;
    private FileOutputStream outputFile;
    private BufferedOutputStream bufferedOutput;
    private DataOutputStream outputStream;
    private boolean readyForWrite;

    public SecuentialWritter(String fileName) {
        cursors = new ArrayList<>();
        readyForWrite = false;
        try {
            outputFile = new FileOutputStream(fileName + "-" + fileType + "." + extension);
            bufferedOutput = new BufferedOutputStream(outputFile);
            outputStream = new DataOutputStream(bufferedOutput);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SecuentialWritter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generateRandomCursors(String mensaje) {
        List<Integer> c = new ArrayList<>();
        Random randito = new Random();


        for (int i = 0; i < mensaje.length(); i++) {
            int cursor = randito.nextInt(MAX_CURSOR) + 1;
            while (isRepeated(cursor, c)) {
                cursor = randito.nextInt(MAX_CURSOR) + 1;
            }
            c.add(cursor);
            char letra = mensaje.charAt(i);

        }

        readyForWrite = true;
        cursors = c;
    }

    @Override
    public void writeFile() {
        if (this.readyForWrite) {
            try {
                for (int i = 0; i < this.cursors.size(); i++) {
                    int temp = (int) this.cursors.get(i);
                    //System.out.println(i+":\t"+temp);
                    outputStream.writeInt(temp);
                }
                outputStream.close();
                System.out.println("SecuentialWritter >> escribiendo cursores: " + this.cursors);
            } catch (IOException ex) {
                Logger.getLogger(SecuentialWritter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("No se pudo excribir el archivo, por que no hay cursores");
        }
    }

    private boolean isRepeated(int number, List arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int t = (int) arrayList.get(i);
            if (number == t) {
                System.out.println("REPETIDO !!!");
                return true;
            }
        }
        return false;
    }

    public List<Integer> getCursors() {
        return this.cursors;
    }
}
