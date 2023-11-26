package ru.java;

public class LMethod {

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

    public void print_value() {
        System.out.println("member="+this.member + ", string="+this.string);
    }
}
