// 11022번 A+B-8

import java.util.Scanner;

public class Q11022 {
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
            System.out.printf("Case #%d: %d + %d = %d\n",i+1,x,y,sum);
        }
    }
}






