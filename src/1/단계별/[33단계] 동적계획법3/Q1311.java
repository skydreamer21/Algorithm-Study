// 1311번 할 일 정하기1 (G1)
/*
<문제 정보>
 1. N명의 사람과 N개의 일이 있다. D_ij : i번 사람이 j번 일을 할 때 드는 비용
    -> 모든 일을 하는데 필요한 비용의 최솟값

<변수 범위>
 1. 1초 / 512MB
 2. 사람, 일의 수 1<=N<=20
 3. 각 비용은 10,000 보다 작거나 같은 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q1311 {
    static int N;
    static int[][] D;
    static int[][] dp;
    static final int EMPTY = 0;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        D = new int[N+1][N+1];
        dp = new int [N+1][1<<N];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) D[i][j] = Integer.parseInt(st.nextToken());
        }

        sb.append(solveDP(1,0));



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP (int person, int status) {
        // 모든 사람에 대한 탐색이 완료됐다면
        if (status == (1<<N)-1) return 0;

        if (dp[person][status]!=EMPTY) return dp[person][status];


        /*//마지막사람에 대한 탐색이라면
        if (person==N) {
            int lastWork = ~status & -(~status);
            lastWork = (int)Math.round(Math.log10(lastWork)/Math.log10(2)) + 1;
            return D[N][lastWork];
        }*/

        dp[person][status] = INF;

        // 꺼져있는 비트를 순회하며 사람을 배치하고 다음 solveDP로 넘김
        for (int i=1;i<=N;i++) {
            // i번 비트가 켜져있다면 다음 비트로 넘김 (i번 일은 이미 다른사람이 함)
            if ((status & (1<<(i-1))) != 0) continue;

            // 꺼져있다면 사람을 배치한 상태를 다음 solveDP로 넘김
            dp[person][status] =
                    Math.min(
                    dp[person][status],
                    D[person][i] + solveDP(person+1, status | (1<<(i-1)))
                    );
        }
        return dp[person][status];
    }
}



















