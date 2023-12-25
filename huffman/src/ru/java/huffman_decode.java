package ru.java;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;



public class huffman_decode {
    public huffman_decode(String file_name_input, String file_name_output)
    {
        this.map_decoding = new HashMap<>();
        this.input_file_name = file_name_input;
        this.output_file_name = file_name_output;
        this.read = new Read_byte_file(this.input_file_name, this.output_file_name);
    }

    public void read_file_to_decoding()
    {
        try {
            read.read_map();
            encode_line = read.read_encode_line();
            HashMap<Character, String> map_decod = read.getMap_decoding();

            for(HashMap.Entry<Character, String> map_dec: map_decod.entrySet())
            {
                map_decoding.put(map_dec.getValue(), map_dec.getKey());
            }
            System.out.println("Сжатый файл прочитан");

        } catch (NoSuchFileException e) {
            System.out.println("Exception 1: " + e);
        } catch (IOException e) {
            System.out.println("Exception 2: " + e);
        } catch (Exception e) {
            System.out.println("Exception 3: " + e);
        }

    }

    public void decoding()
    {
        StringBuilder decode_string = new StringBuilder();
        StringBuilder help_line = new StringBuilder();
        for (int i=0; i<encode_line.length(); i++)
        {
            char ch = encode_line.charAt(i);
            help_line.append(ch);

            if (map_decoding.containsKey(help_line.toString()))
            {
                decode_string.append(map_decoding.get(help_line.toString()));
                help_line.setLength(0);
            }
        }
        read.write_to_file(decode_string.toString());
    }



    private HashMap< String, Character> map_decoding; //словарь для сохранения кодировок букв
    private String encode_line; //закодированный текст
    private String input_file_name; //входной закодированный файл
    private String output_file_name; //выходной файл для сохранения декодированной информации

    Read_byte_file read; //переменная для чтения данных из бинарного файла

}
