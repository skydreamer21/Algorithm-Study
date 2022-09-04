// 11052번 카드 구매하기 (S1) [dp]
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q11052_2 {
    static int N;
    static int[] prices;
    static int[] dp;

    static final int EMPTY = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************

        N = Integer.parseInt(br.readLine());
        prices = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1];

        // ******************** 메인 로직 ********************

        int maxCost = solveDP(N);

        // ******************** 정답 출력 ********************

        sb.append(maxCost);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP (int n) {
        if (n==0) return 0;
        if (dp[n] != EMPTY) return dp[n];

        int maxCost = 0;
        for (int i=1;i<=n;i++) {
            maxCost = Math.max(maxCost, prices[i] + solveDP(n-i));
        }
        return dp[n] = maxCost;
    }
}
