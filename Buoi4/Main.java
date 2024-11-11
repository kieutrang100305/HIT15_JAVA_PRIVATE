package Buoi4;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
//       Person p1 = new Person();
//       Person p2 = new Person();
//
//       Person p3 = new Person("a01","Trang",19);
//
//       Student a1 = new Student();
//       a1.setid("2023");
//       a1.setname("trang");
//       a1.setdate(19);
//       a1.display();
//       Student a2 = new Student("2020","Trang",20);
//       a2.display();

//       p3.getName();
//       System.out.println(p3.getName());
//       p3.setName("Hoang");
//       System.out.println(p3.getName());

    int[] arr = new int[3];
    Student[] studentlist = new Student[3];
    studentlist[0] = new Student("2021522","Trang", 35);
    studentlist[1] = new Student("2021523","Trangg", 25);
    studentlist[2] = new Student("2021524","Tranggg", 15);

    Scanner sc= new Scanner(System.in);
    System.out.print("Nhap ten ban muon tim kiem: ");
    String name = sc.nextLine();
    boolean find = false;
    // for ( kieu du lieu cua mang + 1 instance : ten mang )
        // so sanh == va equals
    for(Student s1 : studentlist){
        //s1.display();
        if(s1.getName().equals(name)) {
            s1.display();
            find = true;
        }
    }
    if(!find){
        System.out.println("Khong tim thay nguoi " + name);
    }
    }
}
