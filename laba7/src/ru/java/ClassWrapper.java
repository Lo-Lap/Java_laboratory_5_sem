package ru.java;

public class ClassWrapper <T> //класс который будет выполнять действия над другими классами
{
    private T sample_class; //здесь хранится образец класса, который был отправлен в обёртку

    public ClassWrapper(T sample_class) {
        this.sample_class = sample_class;
    };

    public void setSample_class(T sample_class) {
        this.sample_class = sample_class;
    };

    public T getSample_class() {
        return this.sample_class;
    };

    public void swap(ClassWrapper<T> p2) {
        //проверяем совпадают ли классы обиеняемых объектов
        if (this.getSample_class().getClass() == this.getSample_class().getClass()) {
            T tmp = p2.sample_class;
            p2.sample_class = this.sample_class;
            this.sample_class = tmp;
        }
    };

}
