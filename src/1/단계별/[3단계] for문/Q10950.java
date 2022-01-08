// 10950번 A+B-3
import java.util.ArrayList;
import java.util.Scanner;

public class Q10950 {
   public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       int T;
       int x;
       int y;
       ArrayList<Integer> sum = new ArrayList<Integer>();
       T=sc.nextInt(); //T는 반복 횟수
       for (int i=0; i<T; i++) {
           x=sc.nextInt();
           y=sc.nextInt();
           sum.add(x+y);
       }
       for (int i=0;i<T;i++) {
           System.out.println(sum.get(i));
       }

   }
}


/* 백준에서 입력과 출력을 따로 분리할 필요가 없음
public class Q10950 {
    public static void main(String[] args) {
        // 반복문을 몇 번 수행할 지 정할 변수 선언
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt();

        // 결과 값을 출력해줄 변수 선언
        int b;
        int c;

        // 반복문 실행
        for(int i = 0; i < a; i++)
        {
            b = sc.nextInt();
            c = sc.nextInt();
            System.out.println(b + c);
        }
    }
}
*/




