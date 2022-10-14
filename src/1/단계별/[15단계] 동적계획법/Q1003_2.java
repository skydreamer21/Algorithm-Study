// 1003번 피보나치 함수

/*
<문제 정보>
 1. 피보나치 함수를 재귀함수로 짰을 때, 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력
 2. N<=40, 0포함


<프로그램 진행>
 1.


<필요 함수>
 1. count_0 : 0의 개수를 저장하며 세는 함수
 2. count_1 : 1의 개수를 저장하면 세는 함수

 */

import java.io.*;
import java.util.Arrays;

public class Q1003_2 {
    static int[] memo_0 = new int[41];
    static int[] memo_1 = new int[41];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        Arrays.fill(memo_0,-1);
        Arrays.fill(memo_1,-1);
        memo_0[0] = 1; memo_1[0] = 0;
        memo_0[1] = 0; memo_1[1] = 1;
        int N;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(count_0(N)).append(" ").append(count_1(N)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int count_0 (int n) {
        if (memo_0[n]==-1)  memo_0[n] = count_0(n-1) + count_0(n-2);
        return memo_0[n];
    }

    public static int count_1 (int n) {
        if (memo_1[n]==-1)  memo_1[n] = count_1(n-1) + count_1(n-2);
        return memo_1[n];
    }
}