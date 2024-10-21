package Buoi1;

import java.util.Scanner;
public class Bai2 {
    public static int tinh(int n){
        int tich=1;
        while(n!=0){
            tich*=n%10;
            n/=10;
        }
        return tich;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(tinh(n));
    }
}
