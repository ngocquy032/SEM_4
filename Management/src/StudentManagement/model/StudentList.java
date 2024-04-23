package StudentManagement.model;

import StudentManagement.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentList {
    // khai báo 1 mảng lưu trữ danh sách đối tượng Student
    // khai báo độ dài của 1 phần tử trong danh sách
    private ArrayList<Student> list;
    private  int length;
    // contructor của StudentList
    public StudentList(){
        // tạo 1 đối tương arrlist gán vào list
        list = new ArrayList<Student>();
    }
    // tìm kếm tên
    public ArrayList<Student> findByName(String name){
       boolean found = false;
       // tao arr luu tru cac sv ten khop voi tham so name
       ArrayList<Student> matches = new ArrayList<>();
       // loop qua cac phan tu trong danh sach lisst roi gan vao S
       for(Student s : list){
           // tao bien fullName va bien doi thanh chu thuong
           String fullName = new String(s.getFirstName() + " " + s.getLastName()).toLowerCase();
           // kiem tra xem fullName co name can tim hay kh bang matches
            if(fullName.matches("(.*)" + name.toLowerCase() + "(.*)")){
                // tim thay thi them sv do vao danh sach matches
                matches.add(s);
                found = true;
            }
       }
        if(found == false){
            System.out.println("Not found");
        }
        return matches;
    }
    // tim kiem theo id

    public Student findById(int id){
        for(Student s : list){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    // them sinh vien
    public  void add(Student s){
        list.add(s);
    }
    // xoa sv
    public void remove(int id){
        boolean found = false;
        for(Student s : list){
            if(s.getId() == id){
                int choice;
                System.out.println("Are you sure you want to delete this student? (1.yes or 2.no)");
                choice =  new Scanner(System.in).nextInt();
                if(choice == 1){
                    list.remove(s);
                    found = true;
                }
            }
            if(found == false){
                System.out.println("Can not find this student with id " + id);
            }
        }
    }
    public  void sortByMarks(){
        // dung sort cua Collections de sap xep danh sach list
        // Comparator de so sanh 2 doi tuong
        Collections.sort(list, new Comparator<Student>() {
            @Override
            // nhan 2 doi tuong cua Student de so sanh
            public int compare(Student s1, Student s2) {
                return Double.valueOf(s2.getMark()).compareTo(Double.valueOf(s1.getMark()));
            }
        });
    }
    // hien thi list danh sach
    public  void showList(){
        for(Student s : list){
            s.printInfo();
        }
    }
    public  void showList(ArrayList<Student> list){
        for(Student s : list){
            s.printInfo();
        }
    }

}
