package ru.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class huffman_information {

    public huffman_information(String file_name)
    {
        this.input_file_name = file_name;
        this.read_file = new Read_byte_file(this.input_file_name, "");
    }

    public void print_decode_table() {

        try {
            read_file.read_map();
            HashMap<Character, String> map_decode = read_file.getMap_decoding();
            System.out.println("Структура дерева Хаффмена:");
            for(HashMap.Entry<Character, String> map_dec: map_decode.entrySet())
            {
                if (map_screen_char.containsKey(map_dec.getKey()))
                    System.out.println(map_screen_char.get(map_dec.getKey())+": " + map_dec.getValue());
                else
                    System.out.println(map_dec.getKey()+": " + map_dec.getValue());
            }

        } catch (NoSuchFileException e) {
            System.out.println("Exception 1: " + e);
        } catch (IOException e) {
            System.out.println("Exception 2: " + e);
        } catch (Exception e) {
            System.out.println("Exception 3: " + e);
        }
    }

    public void print_size() {
        try {
            Path path = Paths.get(input_file_name);
            int size_original = read_file.getTotal_number_of_characters();
            System.out.println("Размер исходного файла = "+ size_original+" байт");
            int size_encode = (int) Files.size(path);
            System.out.println("Размер сжатого файла = "+ size_encode+" байт");

            System.out.println("Коэффициент сжатия (размер исходного файла к закодированному) = "+ (double)size_original/size_encode);

        } catch (IOException e) {
            System.out.println("Exception 2: " + e);
        }
    }

    private String input_file_name; //закодированный файл
    private Read_byte_file read_file; //для чтения задодированного файла


    private HashMap<Character, String> map_screen_char = new HashMap<>() //словарь для красивого вывода экранированных символов
            {
                {
                    put('\n', "\\n");
                    put('\r', "\\r");
                    put('\t', "\\t");
                    put('\b', "\\b");
                    put('\f', "\\f");
                    put('\\', "\\");

                }
            };

}
