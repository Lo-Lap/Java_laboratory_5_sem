package ru.java;

import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); // создаём объект класса Scanner
        System.out.print("Введите режим использования (encode, decode, info): ");
        if(sc.hasNext())
        {
            String s = sc.next();
            switch(s)
            {
                case "encode":
                {
                    System.out.print("Введите путь к исходному файлу: ");
                    String input_file ="";
                    if (sc.hasNext())  input_file = sc.next();

                    System.out.print("Введите путь к сжатому файлу: ");
                    String output_file ="";
                    if (sc.hasNext())  output_file = sc.next();

                    huffman_encode huf = new huffman_encode(input_file, output_file);
                    huf.read_file_to_coding();
                    huf.build_Huffman_tree();
                    huf.encode_and_write_to_file();
                    break;
                }
                case "decode":
                {
                    System.out.print("Введите путь к сжатому файлу: ");
                    String input_file ="";
                    if (sc.hasNext())  input_file = sc.next();

                    System.out.print("Введите путь к файлу для восстановленного исходного файла: ");
                    String output_file ="";
                    if (sc.hasNext())  output_file = sc.next();

                    huffman_decode huf = new huffman_decode(input_file, output_file);
                    huf.read_file_to_decoding();
                    huf.decoding();
                    break;
                }
                case "info":
                    System.out.print("Введите путь к сжатому файлу: ");
                    String input_file ="";
                    if (sc.hasNext())  input_file = sc.next();

                    huffman_information huf = new huffman_information(input_file);
                    huf.print_decode_table();
                    huf.print_size();
                    break;
                default: System.out.print("Не верно введён режим ");
            }
        }
    }
}