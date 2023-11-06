package ru.java;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //для ввода аргументов командной строки в Intellig Idea
        //для Windows, Linux: ALT+SHIFT+F10
        //нажимаем Edit Сonfigurations
        //используя сочетание клавишь: Alt + R
        //переходим к полю, в которой вводим аргументы командной строки
        //нажимаем Enter
        //в консоли видим результат исполнения программы

        System.out.println("Laboratory work 5");

        int i=0;
        for (String arg: args) //итерируемся по аргументам командной строки (здесь происходит считывание аргументов)
        {
            System.out.println(i+". "+arg); //выводим аргументы командной строки в консоль
            i++;
        }

    }
}