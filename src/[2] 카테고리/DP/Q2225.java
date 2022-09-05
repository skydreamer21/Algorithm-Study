// 2225번 합분해 (g5) [dp]
/*
<문제 정보>
 1. 0부터 N까지의 정수 K개를 더해서 합이 N이 되는 경우의 수를 출력
 2. 덧셈의 순서가 다른 경우는 다른 경우로 센다.
 3. 한 개의 수를 여러번 쓸 수 있다.
 4. 답을 1,000,000,000 으로 나눈 나머지를 출력

 // 똑같은 문제에 대한 메모이제이션, 완전 탐색

<변수 범위>
 1. 2초 / 128MB
 2. 1 <= N <= 200
 3. 1 <= K <= 200

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2225 {
    static int N, K;
    static int[][] dp;

    static final int EMPTY = -1;
    static final int DIV = 1_000_000_000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1]; // dp[a][b] => b개의 숫자를 더해서 a를 만드는 경우의 수
        for (int i=0;i<=N;i++) Arrays.fill(dp[i], -1);


        // ******************** 메인 로직 ********************

        int count = solveDP(N, K);

        // ******************** 정답 출력 ********************

        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP (int n, int k) {
        if (dp[n][k] != EMPTY) return dp[n][k];

        if (k == 1) {
            return 1;
        }

        dp[n][k] = 0;
        for (int i=0;i<=n;i++) {
            dp[n][k] += solveDP(n-i, k-1);
//            if (n==N && k==K) System.out.printf("dp[n][k] : %d\n", dp[n][k]);
            dp[n][k] %= DIV;
        }
        return dp[n][k];
    }
}
