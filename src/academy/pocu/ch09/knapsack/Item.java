package academy.pocu.ch09.knapsack;

public class Item {
    private int value;
    private int space;

    public Item(final int value, final int space){
        this.value = value;
        this.space = space;
    }

    public int getSpace() {
        return space;
    }

    public int getValue() {
        return value;
    }
}
