package ex1;

import java.util.Scanner;

public class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    public Triangle() {
        super("");
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter the base: ");
        base = sc2.nextDouble();
        System.out.print("Enter the height: ");
        height = sc2.nextDouble();
        System.out.print("Enter the color: ");
        setColor(sc2.next());
        sc2.close();
    }


    @Override
    public double getArea() {
        return   0.5 * base * height;
    }
}
