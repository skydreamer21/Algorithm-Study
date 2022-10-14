// 11021번 A+B-7

import java.util.Scanner;

public class Q11021 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int x;
        int y;
        int sum;
        for (int i=0;i<T;i++) {
            x=sc.nextInt();
            y=sc.nextInt();
            sum=x+y;
            System.out.printf("Case #%d: %d\n",i+1,sum); //서식문자쓸때는 printf!
        }
    }
}






