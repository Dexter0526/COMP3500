package academy.pocu.ch07;

public class GameObject {
    private final Point position;
    private final int data;


    public GameObject(Point position, int data) {
        this.position = position;
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public Point getPosition() {
        return this.position;
    }
}
