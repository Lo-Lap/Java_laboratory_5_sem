package ru.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


//класс, который отдаёт информацию о других классах
public class InfoAboutClass {
    public static void analyzeClass(Class<?> clazz) { //метод для вывода информации о классе

        System.out.println("Имя класса: " + clazz + "\n");
        System.out.println("Имя пакета: " + clazz.getPackage().getName()+ "\n");
        System.out.println("Родительский класс: " + clazz.getSuperclass() + "\n");

        System.out.println("Конструкторы класса: ");
        Constructor<?>[] arr_constructor =clazz.getConstructors();
        for (Constructor<?> constructor : arr_constructor) {
            System.out.println(constructor);
        }

        System.out.println("\n" + "Поля класса: ");
        Field[] arr_field = clazz.getDeclaredFields();
        for (Field field : arr_field) {
            System.out.println(field);
        }

        System.out.println("\n" + "Методы класса: ");
        Method[] arr_meth = clazz.getDeclaredMethods();
        for (Method method : arr_meth) {
            System.out.println(method);
        }
    }
}
