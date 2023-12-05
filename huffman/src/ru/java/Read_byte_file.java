package ru.java;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;

public class Read_byte_file {
    public Read_byte_file(String input_file_name, String output_file_name)
    {
        this.input_file_name = input_file_name;
        this.output_file_name = output_file_name;
        this.map_decoding = new HashMap<>();
    }

    public void read_map() throws IOException
    {
        this.inputStream = new FileInputStream(this.input_file_name);
        this.encoding_byte = inputStream.read();

        int byteRead = inputStream.read(); //байт обозначающий количество делений кодовой строки для количества всех символов в исхожном тексте
        //чтение числа всех элементов в исходном файле
        String str = read_for_code_string(byteRead);
        this.total_number_of_characters = Integer.parseInt(str, 2);

        //чтение числа используемых символов
        byteRead = inputStream.read();//обозначающий количество делений кодовой строки для количества различных символов в исхожном тексте
        str = read_for_code_string(byteRead);
        int count_ch = Integer.parseInt(str, 2); //количество различных символов используемых в исходном файле

        //заполняем таблицу Хаффмена
        while (count_ch>0)
        {
            int byteChar = inputStream.read();//байт обозначающий закодированный символ

            int count_chunk = inputStream.read();//обозначающий количество делений кодовой строки для рассатриваемого символа
            str = read_for_code_string(count_chunk); //бинарный код Хаффмена для символа
            map_decoding.put((char)byteChar, str);

            count_ch--;
        }

    }

    public String read_encode_line() throws IOException
            //функция для считывания кодовой строки
    {
        int count_chunks_number = inputStream.read(); //байт обозначающий количество делений для числа делений для закодированного текста
        String str = read_for_code_string(count_chunks_number);

        int count_chunks_encode = Integer.parseInt(str,2); //число всех делений закодированной строки

        return read_for_code_string(count_chunks_encode); //возвращаем закодированную строку

    }

    private String read_for_code_string(int count_chunks_encode) throws IOException
    //функция для чтения байтов записанных в виде число делений строки + сама строка + перед последним элементом количество незначащих нулей
    {
        StringBuilder encode_string = new StringBuilder();
        for (int count = 0; count < count_chunks_encode-1; count++) //до байтов для предпоследнего элемента
        {
            int byte_ = inputStream.read(); //бaйт означающий часть закодированной строки
            String code_line_with_zero ="";
            code_line_with_zero = String.format("%8s", Integer.toBinaryString(((byte) byte_) & 0xff)).replace(" ", "0");

            encode_string.append(code_line_with_zero);
        }

        int count_zero = inputStream.read(); //количество незначащих нулей в начале строки
        int code_int = inputStream.read(); //само кодовое последнее слово

        String zero="0";
        String code_line_with_zero = ""; //строка с нулями в начале строки

        if (Integer.toBinaryString(code_int).equals(zero))  code_line_with_zero = zero.repeat(count_zero);
        else code_line_with_zero =zero.repeat(count_zero)+Integer.toBinaryString(code_int);
        encode_string.append(code_line_with_zero);

        return encode_string.toString(); //возвращаем закодированную строку
    }

    public void write_to_file(String decode_line)
            //функция для записи декодированного текста в файл
    {
        String encode =" ";
        if (this.encoding_byte==1) encode="UTF-8";
        else encode="UTF-16";

        try(OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(this.output_file_name),
                Charset.forName(encode).newEncoder()
        ))
        {
            writer.write(decode_line);
            writer.flush();
            System.out.println("Исходный файл восстановлен по указанному пути");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public HashMap<Character, String> getMap_decoding()
    {
        return map_decoding;
    }

    public int getTotal_number_of_characters() {
        return total_number_of_characters;
    }

    public int getEncoding_byte() {
        return encoding_byte;
    }

    private InputStream inputStream; //входной поток (поток основанный на закодированном файле)
    private String input_file_name; //входной файл (закодированный файл)
    private String output_file_name; //выходной файл (имя файла для восстановления исходного)
    private HashMap<Character, String> map_decoding; //словарь для сохранения кодировок букв
    private int total_number_of_characters=0;

    private int encoding_byte;

}
