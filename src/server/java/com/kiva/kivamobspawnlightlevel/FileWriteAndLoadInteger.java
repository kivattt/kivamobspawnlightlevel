package com.kiva.kivamobspawnlightlevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteAndLoadInteger {
    public static void writeIntegerToFile(final int integer, final String filename){
        try {
            FileWriter fileWriter = new FileWriter(filename);
            fileWriter.write(Integer.toString(integer));
            fileWriter.close();
        } catch(IOException e){
            System.err.println("Failed to write integer to file: " + filename);
            e.printStackTrace();
        }
    }

    public static Integer loadIntegerFromFile(final String filename){
        Integer ret = null;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            ret = scanner.nextInt();
            scanner.close();
        } catch(FileNotFoundException e){
            System.err.println("Failed to load integer from file: " + filename);
            return null;
        }

        return ret;
    }
}
