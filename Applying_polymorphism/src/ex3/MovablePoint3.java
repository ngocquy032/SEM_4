package ex3;

public class MovablePoint3 implements Movable3 {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    public MovablePoint3(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y += ySpeed;
    }
    public void moveDown() {
        y -= ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }
    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public String toString() {
        return  String.format("point at  (%d, %d) with speed (%d, %d)", x, y, xSpeed, ySpeed);
    }
}
