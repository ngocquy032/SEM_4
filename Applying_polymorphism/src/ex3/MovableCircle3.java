package ex3;

public class MovableCircle3 implements Movable3 {
    private Movable3 center;
    private int radius;
    public MovableCircle3(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint3(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }
    public void moveDown() {
        center.moveDown();
    }
    public void moveLeft() {
        center.moveLeft();
    }
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public String toString() {
        return String.format("Clice at center %s with radius %d", center.toString(), radius);
    }
}
