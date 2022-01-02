import java.util.Scanner;

public class Q2588 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int x;
       int y;
       x=sc.nextInt();
       y=sc.nextInt();
       //y의 백의 자리, 십의 자리, 일의 자리를 분리해야함
       int y_2; //백의 자리
       int y_1; //십의 자리
       int y_0; //일의 자리
       y_2=y/100;
       y_1=(y%100)/10;
       y_0=y%10;
       System.out.println(x*y_0);
       System.out.println(x*y_1);
       System.out.println(x*y_2);
       System.out.println(x*y);
   }
}

