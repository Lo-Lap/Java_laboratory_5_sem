package ru.java;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

// чтение данных с консоли
public class LScanner {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in); // стандартный ввод

        System.out.print("String: ");  //Вводим строку в консоли
        String string = in.nextLine();  //считываем всю строку
        in.close();  //закрываем

        in = new Scanner(string);  //создаём на основе строки (чтобы не зацикливался in.hasNext)

        while (in.hasNext())  //выводим все слова из строки
        {
            String s=in.next();
            System.out.println(s);
        }

        in.close();


        // Ввод-вывод из файла
        String dir = System.getProperty("user.dir"); // каталог запуска
        System.out.println(dir);
        System.out.println("String in file");
        try {
            Scanner fin = new Scanner(Paths.get(dir, "example.txt"), "UTF-8");
            while (fin.hasNext())  //выводим все слова из файла
            {
                String s = fin.next();
                System.out.println(s);
            }
            fin.close();

        } catch (NoSuchFileException e) {
            System.out.println("Exception 1: " + e);
        } catch (IOException e) {
            System.out.println("Exception 2: " + e);
        } catch (Exception e) {
            System.out.println("Exception 3: " + e);
        }

    }
}
