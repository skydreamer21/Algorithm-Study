import java.util.Scanner;

public class Q10430 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int x;
       int y;
       int z;
       x=sc.nextInt();
       y=sc.nextInt();
       z=sc.nextInt();
       System.out.println((x+y)%z);
       System.out.println(((x%z)+(y%z))%z);
       System.out.println((x*y)%z);
       System.out.println(((x%z)*(y%z))%z);
   }
}

