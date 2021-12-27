// 10870번 피보나치 수 5

/*
<문제 정보>
 1. n이 주어졌을 때 n번째 피보나치 수를 구하는 프로그램 작성

<프로그램 진행>
 1. 재귀함수
 2. n=0도  가능

<필요 함수>
 1.

 */

import java.io.*;

public class Q10870 {
    public static int getN_fibonacci (int N) {
        if (N==0) return 0;
        else if (N==1) return 1;
        else return getN_fibonacci(N-1)+getN_fibonacci(N-2);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(getN_fibonacci(N)));
        bw.flush();
        bw.close();
    }
}