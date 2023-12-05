package ru.java;

//структура узла дерева Хаффмана
public class Node {
    private char character; //символ из текста
    private int frequency; //частота появления буквы в тексте
    private Node left = null; //ссылка на левый дочерний узел в дереве
    private Node right = null; //ссылка на правый дочерний узел в дереве
    public Node(char ch, int freq)
    {
        this.character = ch;
        this.frequency = freq;
    }

    public Node(char ch, int freq, Node left, Node right)
    {
        this.character = ch;
        this.frequency = freq;
        this.left = left;
        this.right = right;
    }

    public int getFrequency() {
        return frequency;
    }

    public char getCharacter() {
        return character;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

}
