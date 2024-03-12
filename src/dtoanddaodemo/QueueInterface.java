package dtoanddaodemo;

public interface QueueInterface<T> 
{
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    int size();
}
