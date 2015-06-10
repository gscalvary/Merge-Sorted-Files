package com.oliver;

import java.io.*;

public class FileIOWriter {

    private FileWriter fw;

    public FileIOWriter(String file) {

        try {
            fw = new FileWriter(file);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeLine(String line) {

        try {
            fw.write(line + "\n");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {

        try {
            fw.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
