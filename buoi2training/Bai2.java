import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n,a,b;
        double sum1=0;
        double sum2=0;
        n=sc.nextInt();
        for (int i=0; i<n; i++){
            a= sc.nextInt();
            b= sc.nextInt();
            sum1+=a;
            sum2+=b;
        }
        if (sum1<=sum2) {
            System.out.println((sum2 - sum1) + 1);
        }
        else {
            System.out.println(0);
        }
    }
}
