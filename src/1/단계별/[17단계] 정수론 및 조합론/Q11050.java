// 11050번 이항 계수

/*
<문제 정보>
 1. 자연수 N, 정수 K가 주어졌을 때 이항 계수 (N,K) 구하는 프로그램 작성
 2. 1<=N<=10, 0<=K<=N


<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 이 코드는 int 범위를 넘어가는 수에 대해서 잘못된 값을 반환

import java.io.*;
import java.util.StringTokenizer;

public class Q11050 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int numerator=1; int denominator=1;
        for (int i=0;i<K;i++) numerator*=N-i;
        if (K!=0) {
            for (int i=0;i<K;i++) denominator*=K-i;
        }
        bw.write(String.valueOf(numerator/denominator));
        bw.flush();
        bw.close();
        br.close();
    }
}