package Buoi1;

import java.util.Scanner;
public class Bai1{

    public static void convert(int a, int b){
        if (a==0) {
            return;
        }
        convert(a/b,b);
        int res=a%b;
        if (res<10){
            System.out.print(res);
        }else {
            char tmp = (char) (res + 55);
            System.out.print(tmp);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        convert(a,b);
    }
}