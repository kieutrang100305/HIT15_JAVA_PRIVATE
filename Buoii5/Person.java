package Buoii5;

import java.util.Scanner;

public class Person {
    protected String name;
    protected int age;
    protected Address address;

    // Constructor, getter và setter
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void input(Scanner sc) {
        System.out.print("Nhập tên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập địa chỉ (xã, huyện, tỉnh): ");
        String commune = sc.nextLine();
        String district = sc.nextLine();
        String city = sc.nextLine();
        this.address = new Address(commune, district, city);
    }

    public void output() {
        System.out.println("Tên: " + name + ", Tuổi: " + age + ", Địa chỉ: " + address);
    }
}
