// 10952번 A+B -5
// 입력의 개수를 지정하지 않고 마지막에 0 0 이 오면 끝남

import java.util.Scanner;

public class Q10952 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        int sum;
        while(true) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (x==0 & y==0) break;
            sum = x+y;
            System.out.println(sum);
        }
    }
}







