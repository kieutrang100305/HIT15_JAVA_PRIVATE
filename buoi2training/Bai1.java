package buoi2training;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args){
        int n,a;
        double sum = 0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        //int[] a = new int[n];
        for (int i=0; i<n; i++){
            a = sc.nextInt();
            sum += a;
        }
//        int sum=0;
//        for (int i=0; i<n; i++){
//            sum+=a[i];
//
        System.out.println(sum/n);
    }
}
