package ru.java;

public class Main {
    public static void main(String[] args) {
        Triple<Integer> tr1 =new Triple<Integer>();
        System.out.println("Triple 1:");
        System.out.print("getFirst:");
        Main.Method(tr1.getFirst());

        System.out.print("max:");
        Main.Method(tr1.max());

        System.out.print("min:");
        Main.Method(tr1.min());

        System.out.print("mean:");
        Main.Method(tr1.mean());
        System.out.println();


        tr1.setFirst(7);
        tr1.setSecond(4);
        tr1.setThird(10);

        System.out.print("max=");
        Main.Method(tr1.max());

        System.out.print("min=");
        Main.Method(tr1.min());

        System.out.print("mean=");
        Main.Method(tr1.mean());
        System.out.println();

        Triple<Integer> tr2 =new Triple<Integer>(82, 41, 56);
        System.out.println("Triple 2:");
        System.out.print("first=");
        Main.Method(tr2.getFirst());

        System.out.print("second=");
        Main.Method(tr2.getSecond());

        System.out.print("third=");
        Main.Method(tr2.getThird());

        System.out.println();
        System.out.print("max=");
        Main.Method(tr2.max());

        System.out.print("min=");
        Main.Method(tr2.min());

        System.out.print("mean=");
        Main.Method(tr2.mean());
        System.out.println();

        //Поменяем в tr2 первый элемент и посмотрим, что изменилось
        tr2.setFirst(7);
        System.out.print("first=");
        Main.Method(tr2.getFirst());

        System.out.print("second=");
        Main.Method(tr2.getSecond());

        System.out.print("third=");
        Main.Method(tr2.getThird());

        System.out.println();
        System.out.print("max=");
        Main.Method(tr2.max());

        System.out.print("min=");
        Main.Method(tr2.min());

        System.out.print("mean=");
        Main.Method(tr2.mean());
    }

    public static<T> void Method(T v) {
        System.out.println(v);
    }
}
