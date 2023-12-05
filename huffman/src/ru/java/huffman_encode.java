package ru.java;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.NoSuchFileException;

import java.util.*;


public class huffman_encode {
    huffman_encode(String input_file_name, String output_file_name, String encode)
    {
        this.input_file_name = input_file_name+".txt";
        this.out_file_name = output_file_name + ".arc";
        this.map_char_freq = new HashMap<>();
        this.queue_node = new PriorityQueue<>(Comparator.comparingInt(Node::getFrequency));
        this.original_line = "";
        this.encode = encode;
    }

    public void read_file_to_coding() {
        FileReader inputStream;

        try {
            inputStream = new FileReader(this.input_file_name, Charset.forName(encode));

            int c;

            while ((c = inputStream.read()) != -1) //read() читает один байт из потока
            {
                count_character++;
                original_line += (char)c;
                if (!map_char_freq.containsKey((char) c))
                {
                    map_char_freq.put((char)c, 1);
                    continue;
                }

                //для HashMap если ключ уже сущесвует, то put сделает обновление значения по ключу
                map_char_freq.put((char)c, map_char_freq.get((char)c) + 1); // обновляем значение по ключу
            }

            inputStream.close();

            System.out.println("Исходный файл прочитан");



        } catch (NoSuchFileException e) {
            System.out.println("Exception 1: " + e);
        }
        catch (IOException e) {
            System.out.println("Exception 2: " + e);
        }
        catch (Exception e) {
            System.out.println("Exception 3: " + e);
        }
    }

    public void build_Huffman_tree()
    {
        //сначала заполняем очередь используя словарь созданный при чтении файла
        //метод entrySet() - возвращает набор сопоставлений ключ-значение, содержащихся в карте
        for (HashMap.Entry<Character, Integer> char_freq : map_char_freq.entrySet()) {
            queue_node.add(new Node(char_freq.getKey(), char_freq.getValue()));
        }

        while (queue_node.size()!=1) {
            //берём и удаляем узлы из приоритетной очереди
            //так как очередь с приоритетам по частоте,
            //то удалятся узлы с наименьшим приоритетом
            Node left = queue_node.poll();
            Node right = queue_node.poll();

            if (left != null && right != null) {
                int sum_frequency = left.getFrequency() + right.getFrequency();
                //создаем и добавляем новый узел в очередь
                queue_node.add(new Node('\0', sum_frequency, left, right));
            }
        }

        root_tree = queue_node.peek(); //корень дерева это теперь последний оставшийся элемент в очереди

        map_coding = new HashMap<>();
        coding(root_tree,"",map_coding); //заполняем символ с его зашифрованной версией

    }


    //рекурсивная функция для определения последовательности 0 и 1 закодирования буквы
    public void coding(Node root, String str, HashMap<Character, String> map_code)
    {
        if (root == null)
            return;

        if (root.getLeft() == null && root.getRight() == null) { //дошли до листа (в котором буква из исходного текста)
            map_code.put(root.getCharacter(), str);
        }

        coding(root.getLeft(),str + "0", map_code); //для левой ветви ребро обозначаем через 0
        coding(root.getRight(),str + "1",map_code); //для правой ветви ребро обозначаем через 1
    }

    public void encode_and_write_to_file()
    {
        try(FileOutputStream writer = new FileOutputStream(this.out_file_name))
        {
            if (encode.equals("UTF-8")) writer.write(1);
            else writer.write(2);
            String string_count_char = Integer.toBinaryString(count_character);

            write_chunk(writer,string_count_char, false); //нужно будет деление, если число элементов превышвет 256
            //если запись числа занимает больше 8 бит (или 16 бит)

            String string_map_size = Integer.toBinaryString(map_coding.size());
            write_chunk(writer, string_map_size, false);


            for (HashMap.Entry<Character, String> entry : map_coding.entrySet()) {

                char ch = entry.getKey();
                int charIntcode = Integer.parseInt(Integer.toBinaryString((int)ch), 2);
                writer.write(charIntcode); //записываем байт символа

                write_chunk(writer,entry.getValue(), false);

            }

            // создаём зашифрованную строку:
            StringBuilder encode_string = new StringBuilder();
            for (int i = 0; i < original_line.length(); i++)
            {
                char ch = original_line.charAt(i);
                String code_line = map_coding.get(ch);
                encode_string.append(code_line);
            }
            write_chunk(writer,encode_string.toString(), true);

            System.out.println("Сжатый файл создан");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

    private void write_chunk(FileOutputStream writer, String string, boolean drop_len) throws IOException {
        int chunkSize = 8;
        String[] chunks = string.split("(?<=\\G.{" + chunkSize + "})"); //для деление строки используем регулярное выражение
        //\\G.{chunkSize} совпадает ровно с chunkSize символами, которые сразу следуют за предыдущим совпадением.
        //?<= выбирает положительный поиск сзади, поэтому остальное является регулярным выражением для поиска

        if (drop_len) //для закодированной строки размер массива дробления может быть больше 256, поэтому нужно подробить
        {
            String size = Integer.toBinaryString(chunks.length);
            write_chunk(writer, size, false);
        }
        else writer.write(chunks.length);

        int count = 1;
        for (String chunk: chunks)
        {
            int count_zero = 0;
            for (int i=0; i<chunk.length(); i++)
            {
                char c = chunk.charAt(i);
                if (c!='0') break;
                count_zero++;
            }

            int chunk_code = Integer.parseInt(chunk, 2);

            if (count==chunks.length)
            {
                System.out.println(Arrays.toString(chunks));
                writer.write(count_zero);
                writer.write(chunk_code);
                count++;
                continue;
            }

            writer.write(chunk_code);

            count++;
        }
    }



    private HashMap<Character, Integer> map_char_freq; //словарь символ и его частота вхождения в файл
    private PriorityQueue<Node> queue_node; //очередь из узлов для построения дерева Хаффмана
    private Node root_tree; //корень дерева Хаффмана
    private HashMap<Character, String> map_coding; //словарь для сохранения кодировок букв
    private String original_line; //исходный текст
    private String input_file_name; //входной (исходный) файл
    private String out_file_name; //файл вывода информации (закодированный)
    private String encode; //кодировка файла
    private int count_character=0; //количество всех элементов в исходном файле
}
