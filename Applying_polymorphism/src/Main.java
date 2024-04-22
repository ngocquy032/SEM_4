import ex1.Rectangle;
import ex1.Triangle;
import ex2.MovablePoint;
import ex3.MovableCircle3;
import ex3.MovablePoint3;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       System.out.println("Hello World");

//        // tạo đối tượng TaxManager
//        TaxManager taxManager = new TaxManager();
//        // Thêm các đối tượng Taxpayer vào TaxManager
//        taxManager.addTaxpayer(new Company());
//        taxManager.addTaxpayer(new FreeLand());
//        taxManager.addTaxpayer(new Employee());
//
//        // Lấy tổng số tiền phải trả của tất cả các đối tượng
//        double totalTax = taxManager.getTax();
//        System.out.println("Total tax: " + tolTatax);

        //EX1
//        Rectangle rectangle = new Rectangle(4, 5, "Red");
//        System.out.println("Area of Rectangle: " + rectangle.getArea());
//        System.out.println("Color of Rectangle: " + rectangle.getColor());
//
//        Triangle triangle = new Triangle(4, 5, "Blue");
//        System.out.println("Area of Triangle: " + triangle.getArea());
//        System.out.println("Color of Triangle: " + triangle.getColor());
//
//        Rectangle rectangle2 = new Rectangle();
//        System.out.println("Area of Rectangle 2: " + rectangle2.getArea());
//        System.out.println("Color of Rectangle 2: " + rectangle2.getColor());
//
//        Triangle triangle2 = new Triangle();
//        System.out.println("Area of Triangle 2: " + triangle2.getArea());
//        System.out.println("Color of Triangle 2: " + triangle2.getColor());

        // EX2
//        MovablePoint point = new MovablePoint(2, 2);
//        point.display();
//        point.moveUp();
//        point.display();
//        point.moveRight();
//        point.display();
//        point.moveDown();
//        point.display();
//        point.moveLeft();
//        point.display();
//        Ex3
        MovablePoint3 point3 =  new MovablePoint3(10, 5, 4,5);
        System.out.println(point3);
        point3.moveUp();
        System.out.println(point3);

        MovableCircle3 circle3 = new MovableCircle3(20, 10 ,5, 4, 10);
        System.out.println(circle3);
        circle3.moveDown();
        System.out.println(circle3);

    }
}