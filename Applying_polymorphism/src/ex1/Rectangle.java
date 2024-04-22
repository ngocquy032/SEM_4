package ex1;

import java.util.Scanner;

public class  Rectangle extends Shape {
    private double length;
    private double width;
    public Rectangle(double length, double width, String color) {
        super(color);
        this.length = length;
        this.width = width;
    }
    public  Rectangle(){
        super("");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the rectangle: ");
        length = sc.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        width = sc.nextDouble();
        System.out.print("Enter the color of the rectangle: ");
        setColor(sc.next());
        sc.close();
    }
    @Override
    public double getArea() {
        return  length * width;
    }
}
