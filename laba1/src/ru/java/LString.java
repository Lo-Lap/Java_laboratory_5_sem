package ru.java;

public class LString {
    public static void main(String[] args) {
        String s1 = "Hello world";

        //method 'length'
        int length=s1.length();
        System.out.println("Length of s1: " +length);

        //method 'equals'
        String s2 = "Hello world?";
        String s3 = "Hello world";
        System.out.println("s1 = s2: " + s1.equals(s2));
        System.out.println("s1 = s3: " + s1.equals(s3));

        //method 'compareTo'
        String s = "Hello";
        System.out.println("s3 is a string lexically equal to s1: " + s1.compareTo(s3));
        System.out.println("s2 is a string lexically larger than s1: " +s1.compareTo(s2));
        System.out.println("s is a string lexically less than s1: " +s1.compareTo(s) );

        //method 'replace'
        System.out.println("Change 'Hello' to 'Hi' in s1: " +s1.replace("Hello", "Good afternoon"));

        //method 'getBytes'
        System.out.println("Encoded string s1 in bytes: " +s1.getBytes());

        // method 'charAt'
        System.out.println("Seventh element of string s1: " +s1.charAt(7-1));

        // method 'indexOf'
        System.out.println("First element that == 'o' in s1: " +s1.indexOf('o'));
        System.out.println("Element that == 't' in s1: " +s1.indexOf('t'));
        System.out.println("Returns -1 because there is no 't' in s1");

        // method 'contains'
        String s4 = "monday friday sarturday";
        String s5 = "monday";
        String s6 = "Tuesday";
        System.out.println("Check if there is s5 in s4: " + s4.contains(s5));
        System.out.println("Check if there is s6 in s4: " + s4.contains(s6));

        //method 'substring'
        System.out.println("Return from s1: " +s1.substring(7,11));
        System.out.println("Return from s1 (another variant): " +s1.substring(7) );

        //method 'concat'
        String s8 = " It's cloudy today ";
        System.out.println("s1+s8: " +s1.concat(s8));

        //method 'trim'
        String s9 = "   More spaces     ";
        System.out.println("s9 without spaces: " +s9.trim());

        //method 'repeat'
        String s10 = "Hello! ";
        System.out.println("Repeat s10 four times: " +s10.repeat(4));

        //method 'toString'
        Integer x = 48551;
        System.out.println("String representing the value of this s11: " +x.toString());
    }
}
