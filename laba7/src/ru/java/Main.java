package ru.java;

public class Main
{
    public static void main(String[] args) {

        LMethod lmp1 = new LMethod(10, "ten");
        LMethod lmp2 = new LMethod(20, "twenty");

        ClassWrapper lmp1_wrap = new ClassWrapper(lmp1);
        ClassWrapper lmp2_wrap = new ClassWrapper(lmp2);

        System.out.println("До изменения:");
        // выведятся адреса объектов класса
        System.out.println("lmp1: " + lmp1_wrap.getSample_class());
        System.out.println("lmp2: " + lmp2_wrap.getSample_class());

        lmp1_wrap.swap(lmp2_wrap);

        System.out.println("После изменений:");
        System.out.println("lmp1: " + lmp1_wrap.getSample_class());
        System.out.println("lmp2: " + lmp2_wrap.getSample_class());
    }

}
