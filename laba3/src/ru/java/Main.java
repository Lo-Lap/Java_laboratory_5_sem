package ru.java;

public class Main {
    public static void main(String[] args) {
        int min = 0;
        int max = 10;
        int[]arr = new int[5];
        arr[0] = 4;
        arr[1] = 15;
        arr[2] = -8;
        arr[3] = 1;
        arr[4] = -5;

        //example with !
        System.out.println("Print number, if it is positive number");
        for (int i = 0; i < arr.length; i++) {
            if (!(arr[i] <=0)) {
                System.out.println(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; i++) {

            //example with &&
            if(min < arr[i] && arr[i] < max){
                System.out.println("Number_first_if " + arr[i]);
            }

            //example with ||
            if(min > arr[i] || arr[i] > max){
                System.out.println("Number_second_if " + arr[i] );
            }

        }

        //example with x < y ? x : y
        System.out.println("Заменяем все отрицательные числа на 0:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Было: " + arr[i]);
            arr[i] = arr[i] < 0 ? 0 : arr[i];
            System.out.println("Стало: " + arr[i]);
        }


        //example with & | ^ ~ (эти операции выполняются для бинарной записи числа (побитовые операции))
        int a = 5;
        int b = 15;
        int c = -10;
        System.out.println("a = 5 = " + Integer.toBinaryString(a));
        System.out.println("b = 15 = " + Integer.toBinaryString(b));
        System.out.println("c = -10 = " + Integer.toBinaryString(c));
        System.out.println("a & b = " + (a & b) );
        System.out.println("a | b = " + (a | b) );

        //^ - исключающее или
        System.out.println("a ^ b = " + (a ^ b));

        //~ - операция отрицания
        System.out.println("~a = " + (~a));
        System.out.println("~c = " + (~c));


        //example with  >> << >>>
        int r = 125;
        System.out.println("r = 125 = " + Integer.toBinaryString(r));
        //<< i - добавление в конец бинарной записи i-штук нулей
        System.out.println("r << 1 = " + (r<<1) );
        System.out.println("r << 2 = " + (r<<2));
        System.out.println("r << 3 = " + (r<<4) );

        //>> i - удаляет в конце бинарной записи i-штук цифр
        System.out.println("r >> 2 = " + (r>>2) );
        System.out.println("r >> 4 = " + (r>>4) );

        //>>> i - сдвиг вправо
        System.out.println("r >>> 2 = " + (r>>>2));
        System.out.println("r >>> 4 = " + (r>>>4));
    }
}
