// 2739번 구구단
import java.util.Scanner;

public class Q2739 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int N;
       N=sc.nextInt();
       for (int i=1; i<10; i++) {
           System.out.printf("%d * %d = %d\n",N,i,N*i); //서식문자의 사용 : printf
       }
   }
}

