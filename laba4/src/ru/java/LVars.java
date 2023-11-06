package ru.java;

import java.util.Scanner;

public class LVars {
    //    @SuppressWarnings("fallthrough")
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //примитивные типы
        System.out.print("Input a number month: ");
        int number_month = in.nextInt();

        switch (number_month) {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
            default:
                System.out.println("Такого месяца не существует");
                break;
        }

        System.out.print("Input a byte number: ");
        byte b1 = in.nextByte();

        switch (b1) {
            case -120:
                System.out.println("switch1 for byte");
                break;
            case 0:
                System.out.println("switch2 for byte");
                break;
            case 50:
                System.out.println("switch3 for byte");
                break;
            default:
                System.out.println("switchdef for byte");
                break;
        }

        System.out.print("Input a char: ");
        char c1 =in.next().charAt(0);

        switch (c1) {
            case 'c':
                System.out.println("switch1 for char: char");
                break;
            case 'e':
                System.out.println("switch2 for char: exit");
                break;
            case 'r':
                System.out.println("switch3 for char: rabbit");
                break;
            default:
                System.out.println("switchdef for char");
                break;
        }

        System.out.print("Input a short number: ");
        short s1 = in.nextShort();

        switch (s1) {
            case -8:
                System.out.println("switch1 for short");
                break;
            case 0:
                System.out.println("switch2 for short");
                break;
            case 14:
                System.out.println("switch3 for short");
                break;
            default:
                System.out.println("switchdef for short");
                break;
        }


        //класс  строки
        System.out.print("Input a day: ");
        String day = in.next();
        switch (day) {
            case "Friday":
                System.out.println("Today is cloudy !");
                break;
            case "Monday":
                System.out.println("Today is sunny !");
                break;
            case "Wednesday":
                System.out.println("Today is frosty!");
                break;
            default:
                System.out.println("Oooops, something wrong !");
        }

        in.close();
    }
}
