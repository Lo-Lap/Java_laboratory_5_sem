package ru.java;

import java.lang.reflect.Method;

public class LMethod {
    public static void main(String[] args) {

        //Создаём экземпляр класса по имени класса
        String s="ru.java.LMethod";
        LMethod lmp = null;
        try {
            lmp = (LMethod) Class.forName(s).newInstance();
            System.out.println("При создании класса:");
            lmp.print_value(lmp);

            //вызываем метод класса используя имя
            Method updateMember = lmp.getClass().getDeclaredMethod("updateMember", int.class);
            updateMember.invoke(lmp,10);

            Method updateString = lmp.getClass().getDeclaredMethod("updateString", String.class);
            updateString.invoke(lmp,"application");
            System.out.println("После изменения полей member, string:");
            lmp.print_value(lmp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }

    private int member;
    private String string;

    public LMethod() {
        this.member = 0;
        this.string = null;
    }
    public LMethod(int member, String string) {
        this.member = member;
        this.string = string;
    }

    public void updateMember(int member) {
        this.member = member;
    }

    public void updateString(String string) {
        this.string = string;
    }


    public void print_value(LMethod p) {
        System.out.println("member="+p.member + ", string="+p.string);
    }
}
