package ru.java;

public class Triple <T extends Comparable<T>>{  //extends Comparable<T> нужно, чтобы была возможность сравнивать переменные неопределенного типа T
    private T first;
    private T second;
    private T third;

    public Triple() {}

    public Triple(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return this.first;
    }
    public T getSecond() {
        return this.second;
    }

    public T getThird() {
        return this.third;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public void setThird(T third) {
        this.third = third;
    }

    public T min()
    {
        T min_ = null;
        try
        {
            //Сравниваем первый и второй элементы
            if (this.second.compareTo(this.first)<0)
            {
                min_ = this.second;
            }
            else {
                min_ = this.first;
            }

            //Сравниваем третий элемент с min_
            if (this.third.compareTo(min_)<0) {
                min_ = this.third;
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Ошибка, не все переменные определены значением");
        }
        return min_;
    }

    public T max()
    {
        T max_=null;
        try
        {
            //Сравниваем первый и второй элементы
            if (this.second.compareTo(this.first)>0)
            {
                max_ = this.second;
            }
            else {
                max_ = this.first;
            }

            //Сравниваем третий элемент с max_
            if (this.third.compareTo(max_)>0)
            {
                max_ = this.third;
            }
        }
        catch(NullPointerException e)
        {
            System.out.println("Ошибка, не все переменные определены значением");
        }
        return max_;
    }

    public T mean()  //Среднее значение
    {
        T mean_=null;
        try
        {
            mean_= max(min(this.first, this.second),min(max(this.first, this.second), this.third));
            /*
            Объяснения к формуле на примере: third>first>second:
            min(this.first, this.second) = second;
            max(this.first, this.second) = first
            min(max(this.first, this.second), this.third)) = min(second,third)=first
            max(min(this.first, this.second),min(max(this.first, this.second), this.third))=
            =max(second,first)=first
             */
        }
        catch(NullPointerException e)
        {
            System.out.println("Ошибка, не все переменные определены значением");
        }
        return mean_;
    }

    //Вспомогательные функции для вычисления min, max от двух чисел
    private T min(T a, T b)
    {
        if (a.compareTo(b)<0)
        {
            return a;
        }
        else {
            return b;
        }
    }

    private T max(T a, T b)
    {
        if (a.compareTo(b)>0)
        {
            return a;
        }
        else {
            return b;
        }
    }

}
