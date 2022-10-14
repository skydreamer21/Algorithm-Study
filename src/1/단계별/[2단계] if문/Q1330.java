import java.util.Scanner;

public class Q1330 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int x;
       int y;
       x=sc.nextInt();
       y=sc.nextInt();
       if (x>y) {
           System.out.println(">");
       }else if (x<y) {
           System.out.println("<");
       }else {
           System.out.println("==");
       }
   }
}

