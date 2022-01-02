// 2884번 알람시계
// 주어진 시간의 45분 전 시간을 시간과 분 단위로 표현
import java.util.Scanner;

public class Q2884 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int hour;
       int min;
       int hour_1;
       int min_1;
       int min_2;
       hour=sc.nextInt();
       min=sc.nextInt();
       hour_1=hour-1;
       min_1 = min-45;
       min_2 = 60 - (45-min);
       if (min>=45) System.out.println(hour+" "+min_1);
       else {
           if (hour!=0) System.out.println(hour_1+" "+min_2);
           else if (hour==0) System.out.println("23 "+min_2);
       }
   }
}

