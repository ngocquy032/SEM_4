package StudentManagement.entity;

import java.util.Scanner;

public class Student {
    // 4 thuộc tính
    private  int id;
    private  String firstName;
    private  String lastName;
    private  double mark;
    public Student(int id, String firstName, String lastName, double mark) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }
    public  void scanInfo(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter StudentManagement.entity.Student ID: ");
        this.id = scan.nextInt();
        System.out.println("Enter First Name: ");
        this.firstName = scan.next();
        System.out.println("Enter Last Name: ");
        this.lastName = scan.next();
        System.out.println("Enter Mark: ");
        this.mark = scan.nextDouble();
    }
    public  void  printInfo(){
        System.out.printf("%3d|%10s%10s|%5f\n", getId(), getFirstName(), getLastName(), getMark());
    }
    public String getFirstName(){
        return firstName;
    }
     public String getLastName(){
        return lastName;
     }
     public double getMark(){
        return mark;
     }
     public int getId(){
        return id;
     }

}
