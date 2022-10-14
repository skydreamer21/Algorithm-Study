import java.util.Scanner;

public class Q2753 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int x;
       x=sc.nextInt();
       // 먼저 400의 배수가 아닌 100의 배수를 걸러줌
       // 그러면 나머지 모든 4의 배수가 윤년
       if (x%100==0 && x%400!=0) {
           System.out.println("0");
       }else if (x%4==0) {
           System.out.println("1");
       }else {
           System.out.println("0");
       }
   }
}

