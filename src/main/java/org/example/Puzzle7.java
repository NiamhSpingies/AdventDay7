package org.example;

import org.example.Database.Directory;
import org.example.Database.File;
import org.example.Database.FileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Puzzle7 {
    private static Map<String, List> filesystem = new HashMap<>();
    private static Map<String, Long> directorySizes = new HashMap<>();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        FileManager fileManger = new FileManager("src/main/resources/inputdata.txt");
        System.out.println(fileManger.specifiedDeletion(100000));
        System.out.println(fileManger.justEnoughStorage());
    }
}
