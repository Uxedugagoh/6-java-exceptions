package com.example.task05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task05Main {
    public static void main(String[] args)  {
        String pathToFile = args[0]; // "/home/user/file.txt"

        String s = null;
        try {
            s = readFile(pathToFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("файл " + pathToFile + " не найден", e);
        } catch (IOException e) {
            throw new RuntimeException("произошла ошибка при чтении файла " + pathToFile, e);
        }
        System.out.println(s);
    }

    public static String wrongReadFile(String pathToFile) throws IOException {
            FileReader fileReader = new FileReader(pathToFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder stringBuilder = new StringBuilder();
            String currentLine;
            // !!! вот здесь типо если вылетит исключение во время чтения, то файл не закроется, это может приводить к тому
            // что память не освобождается и со временем (с каждым вызовом этого метода) и программа крашнется
            while ((currentLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(currentLine);
                stringBuilder.append("\n");
            }
            bufferedReader.close();

            return stringBuilder.toString();
    }

    public static String readFile(String pathToFile) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))){
            StringBuilder stringBuilder = new StringBuilder();
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(currentLine);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    }
}