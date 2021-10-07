package src.academy.pocu;

public interface Queue {
    boolean isEmpty();
    boolean isFull();
    void enqueue(char item);
    char dequeue();
    char peek();
    void clear();
}
