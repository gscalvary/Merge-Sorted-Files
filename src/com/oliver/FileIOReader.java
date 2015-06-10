package com.oliver;

import java.io.*;

public class FileIOReader {

    private BufferedReader br;

    public FileIOReader(String file) {

        try {
            br = new BufferedReader(new FileReader(file));
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readLine() {

        String line;

        try {
            line = br.readLine();
        } catch(IOException e) {
            line = null;
            System.out.println(e.getMessage());
        }

        return line;
    }

    public void close() {

        try {
            br.close();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
