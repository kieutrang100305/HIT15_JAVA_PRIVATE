package Buoi1;

import java.util.Scanner;

public class Bai3 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int [n];
        for (int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        for (int i=0; i<n-1; i++){
            for(int j=n-1; j>i; j--)
                if(arr[j]<arr[j-1]){
                    int tg=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=tg;
            }
        }

        System.out.print((arr[n-1]) + " " + (arr[n-2]));
    }
}
