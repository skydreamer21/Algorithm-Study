// 10871번 X보다 작은 수

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10871 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer tk;
        int N = sc.nextInt();
        int X = sc.nextInt();
        int token;
        String str = sc.nextLine(); // nextLine을 쓰는 오류 피하기 위해 넣은 것
        String s = sc.nextLine();
        tk= new StringTokenizer(s);
        for (int i=0;i<N;i++) {
            token = Integer.parseInt(tk.nextToken());
            if (token<X) System.out.print(token+" ");
        }
    }
}






