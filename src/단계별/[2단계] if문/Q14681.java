// 14681번 사분면 고르기

import java.util.Scanner;

public class Q14681 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int x;
       int y;
       x=sc.nextInt();
       y=sc.nextInt();
       if (x*y>0) {
           if(x>0) System.out.println("1");
           else if(x<0) System.out.println("3");
       }else if(x*y<0) {
           if (x>0) System.out.println("4");
           else if (x<0) System.out.println("2");
       }
   }
}

