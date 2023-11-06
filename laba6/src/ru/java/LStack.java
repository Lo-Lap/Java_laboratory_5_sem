package ru.java;

import java.util.Arrays;

public class LStack{
    public static void main(String[] args) {
        System.out.println("LStack");

        LStack stack = new LStack(10);

        stack.push(5);
        stack.push(1);
        stack.push(8);
        stack.push(10);
        stack.push(15);

        System.out.println("Верхний элемент стека = "+stack.peek());

        stack.pop();

        System.out.println("Верхний элемент стека после удаления = "+stack.peek());

        stack.push(20);
        stack.push(84);
        stack.push(11);

        System.out.println("Размер стека = "+stack.size());

    }

    // Конструкторы для инициализации стека
    public LStack()  //Конструктор по умолчанию
    {
        this.array = new int[0];
        this.top = -1;
        this.capacity = 0;
    }

    public LStack(int size) {
        this.array = new int[size];
        this.top = -1;
        this.capacity = size;
    }

    public boolean isEmpty() //функция проверки пустой ли стек
    {
        return this.top == -1; //если top=-1, это значит, чьл стек пустой
    }

    public boolean isFull() //проверяем заполнен ли весь массив на основе, которого создаётся стек
    {
        return this.top == this.capacity - 1;
    }

    public void push(int i) //функция добавления элемента в стек
    {
        if (this.isFull()) //Проверяем на заполненость стека
        {
            System.out.println("Ошибка: переполнение стека");
            System.out.println("Добавить элемент нельзя");
            return;
        }
        this.array[top + 1]=i;
        this.top++;
    }

    public void pop() //функция удаления элемента из начала стека
    {
        if (this.isEmpty()) //Проверяем является ли стек пустым
        {
            System.out.println("Ошибка: стек пуст. Удаление элемента невозможно");
            return;
        }
        Arrays.copyOf(this.array, this.array.length-1); //удаляем последний элемент из массива
        this.top--;
    }

    public int peek() //функция возвращает верхний эдемент стека
    {
        if (!this.isEmpty()) //Проверяем является ли стек пустым
        {
            return this.array[top];
        }
        System.out.println("Ошибка: стек пуст. Удаление элемента невозможно");
        return -1;
    }

    public int size() //функция, с помощью которой узнаём размер заполненого стека
    {
        return this.top+1;
    }

    private int[] array; //массив, на основе которого создаётся стек
    private int top; //индекс верхнего элемента стека (предполагаем что индексы не согут быть отрицательными у непустого стека
    private int capacity; //размер стека

}
