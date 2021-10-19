package academy.pocu.ch01;

public class ArrayQueue implements Queue {
    private char[] queueArray;
    private int back;
    private int front;
    private int queueSize;

    public ArrayQueue(int queueSize){
        back = -1;
        front = -1;
        this.queueSize = queueSize;
        queueArray = new char[queueSize];
    }

    @Override
    public boolean isEmpty() {
        return (back == front);
    }

    @Override
    public boolean isFull() {
        return (back - front == this.queueSize - 1);
    }

    @Override
    public void enqueue(char item) {
        if(isFull()) System.out.println("Full");
        if(back == this.queueSize - 1) back = -1;
        back++;
        queueArray[back] = item;
        System.out.println(queueArray[back]);
    }

    @Override
    public char dequeue() {
        if(isEmpty()) return 0;

        if(front == this.queueSize - 1) front = -1;
        front++;
        char item = queueArray[front];
        queueArray[front] = 0;
        return item;
    }

    @Override
    public char peek() {
        if(isEmpty()) return 0;
        return queueArray[front];
    }

    @Override
    public void clear() {
        back = -1;
        front = -1;
        queueArray = new char[queueSize];
    }

    // 큐에 저장된 모든 데이터를 출력
    public void printQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue elements : ");
            // front 포인터는 -1 또는 삭제된 요소의 위치에 있기 때문에,
            // +1 위치를 시작점으로 지정.
            for(int i=front+1; i<=back; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int queueSize = 5;
        ArrayQueue arrQueue = new ArrayQueue(queueSize);

        arrQueue.enqueue('A');
        arrQueue.printQueue();

        arrQueue.enqueue('B');
        arrQueue.printQueue();

        arrQueue.enqueue('C');
        arrQueue.printQueue();

        arrQueue.enqueue('D');
        arrQueue.printQueue();

        arrQueue.enqueue('E');
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.peek();
        arrQueue.printQueue();

        arrQueue.clear();
        arrQueue.printQueue();
    }
}
