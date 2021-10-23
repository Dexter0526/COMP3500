package academy.pocu.ch07;

public class Point {
    private int x;
    private int y;

    public Point(final int x, final int y){
        assert (x >= 0);
        assert (y >= 0);
        this.x = x;
        this.y = y;
    }

    public Point(Point other){
        this.x = other.x;
        this.y = other.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
