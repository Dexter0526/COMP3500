package src.academy.pocu;

public class ArrayStack implements Stack{
    private char[] stackArray;
    private int top;
    private int stackSize;

    public ArrayStack(int stackSize){
        top = -1;
        this.stackSize = stackSize;
        stackArray = new char[stackSize];
    }

    @Override
    public boolean isEmpty() {
        if(top == -1) return true;
        return false;
    }

    @Override
    public boolean isFull() {
        if(top == stackSize - 1) return true;
        return false;
    }

    @Override
    public void push(char item) {
        if(isFull()) System.out.println("Full");
        top++;
        stackArray[top] = item;
        System.out.println("push:::" + stackArray[top]);
    }

    @Override
    public char pop() {
        if(isEmpty()) return 0;
        char result = stackArray[top];
        stackArray[top] = 0;
        top--;

        System.out.println("pop:::" + result);
        return result;
    }

    @Override
    public char peek() {
        if(isEmpty()) return 0;
        return stackArray[top];
    }

    @Override
    public void clear() {
        top = -1;
        stackArray = new char[stackSize];
        System.out.println("clear");
    }

    // 스택에 저장된 모든 데이터를 출력
    public void printStack() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack elements : ");
            for(int i=0; i<=top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int stackSize = 5;
        ArrayStack arrStack = new ArrayStack(stackSize);

        arrStack.push('A');
        arrStack.printStack();

        arrStack.push('B');
        arrStack.printStack();

        arrStack.push('C');
        arrStack.printStack();

        arrStack.pop();
        arrStack.printStack();

        arrStack.pop();
        arrStack.printStack();

        arrStack.peek();
        arrStack.printStack();

        arrStack.clear();
        arrStack.printStack();

    }
}
