// 2908번 상수
// 주어진 세자리 수의 자리수를 거꾸로한 수의 대소비교

/*
프로그램 진행
1. 3자리를 input으로 넣을 때 자리수 뒤집힌 세자리 return
2. 두 수 중 큰 수 return
 */

import java.io.*;
import java.util.StringTokenizer;

public class Q2908 {
    public static int reverseNum(int N) {
        int hund = N/100;
        int ten = (N/10)%10;
        int one = N%10;
        int reversedNum = 100*one + 10*ten + hund;
        return reversedNum;
    }

    public static int getBigNum(int A, int B) {
        if (A>B) return A;
        else return B;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        String s = br.readLine();
        StringTokenizer tk = new StringTokenizer(s);
        int A = reverseNum(Integer.parseInt(tk.nextToken()));
        int B = reverseNum(Integer.parseInt(tk.nextToken()));
        bw.write(String.valueOf(getBigNum(A, B)));
        bw.flush();
        bw.close();
    }
}






