import java.util.Scanner; // 입력을 받기 위한 클래스

public class Q1000 {
   public static void main(String args[]) {
       int x;
       int y;
       Scanner sc = new Scanner(System.in);
       x = sc.nextInt();
       y = sc.nextInt();
       // 같은 sc 객체로부터 받았으므로 순서대로 받게 됨
       System.out.print(x+y);
   }
}

