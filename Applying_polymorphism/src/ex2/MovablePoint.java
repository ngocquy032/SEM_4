package ex2;

public class MovablePoint implements Movable{
    private int x;
    private int y;

    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y++;
    }
    public void moveDown() {
        y--;
    }
    public void moveLeft() {
        x--;
    }
    public void moveRight() {
        x++;
    }
    public void display() {
        System.out.println("Point coordinates: (" + x + ", " + y + ")");
    }
}
