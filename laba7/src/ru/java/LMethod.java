package ru.java;

public class LMethod {
    public static void main(String[] args) {

        LMethod lmp = new LMethod();
        int i = 20;
        lmp.updateMember(i);
        lmp.updateString("app");
        // 5. Вызов метода со ссылочным параметром
        LMethod lmp2 = new LMethod(10, "ten");
        LMethod lmp3 = new LMethod(20, "twenty");

        System.out.println("lmp2:");
        lmp2.print_value(lmp2);
        System.out.println("lmp3:");
        lmp2.print_value(lmp3);
        System.out.println();
        // обмена не произойдёт, так как все обмены ссылками произойдут только в самой функции, но не в глобальной области видимости
        LMethod.swap(lmp2, lmp3);
        System.out.println("swap:");
        System.out.println("lmp2:");
        lmp2.print_value(lmp2);
        System.out.println("lmp3:");
        lmp2.print_value(lmp3);
        System.out.println();
        //так как нельзя передавать ссылки, то будем обменивать значения объектов класса
        LMethod.swap_value(lmp2,lmp3);
        System.out.println("swap_value:");
        System.out.println("lmp2:");
        lmp2.print_value(lmp2);
        System.out.println("lmp3:");
        lmp2.print_value(lmp3);
        System.out.println();

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

    public static void swap(LMethod p1, LMethod p2) {
        LMethod temp = p1;
        p1 = p2;
        p2 = temp;
    }

    public static void swap_value(LMethod p1, LMethod p2)  //метод для обмена значениями между двумя объектами одного класса
    {
        int member_ = p1.member;
        p1.updateMember(p2.member);
        p2.updateMember(member_);

        String string_ = p1.string;
        p1.updateString(p2.string);
        p2.updateString(string_);
    }

    public void print_value(LMethod p) {
        System.out.println("member="+p.member + ", string="+p.string);
    }
}
