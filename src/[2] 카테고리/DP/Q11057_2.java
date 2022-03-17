// 11057번 오르막 수(S1) [math] [dp]
/*
<문제 정보>
 1. 수의 길이 N이 주어졌을 때 오르막 수의 개수를 출력 (10,007로 나눈 나머지)
    - 수는 0으로 시작할 수 있음

<변수 범위>
 1. 1초 / 256MB
 2. 1<=N<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 매 반복문마다 dp[i-1]만 쓰이기 때문에 사실 dp는 1차원 배열이면 충분 -> other

import java.io.*;
import java.util.Arrays;

public class Q11057_2 {
    static int N;
    static int[][] dp;
    static int[] sum;
    static final int div=10007;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][10];
        sum = new int[N+1];
//        sum[0]=0;
        Arrays.fill(dp[1],1);
        sum[1]=10;
        for (int i=2;i<=N;i++) {
            dp[i][0]=sum[i-1];
            sum[i]=(sum[i]+dp[i][0])%div;
            for (int j=1;j<10;j++) {
                dp[i][j]=dp[i][j-1]-dp[i-1][j-1];
                if(dp[i][j]<0) dp[i][j]+=div;
                sum[i]=(sum[i]+dp[i][j])%div;
            }
        }
        bw.write(String.valueOf(sum[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}












