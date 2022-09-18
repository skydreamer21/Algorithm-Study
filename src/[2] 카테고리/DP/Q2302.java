// 2302번 극장 좌석 (S1) [DP]
/*
<문제 정보>
 1. 고정석 빼고는 양옆 자리로 옮길 수 있을 때 앉을 수 있는 경우의 수

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q2302 {
    static int N, M;
    static int[] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 & 메인 로직 ********************
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        int before=0;
        int now=0;
        int numOfCases = 1;
        while (M-- >0) {
            now = Integer.parseInt(br.readLine());
            numOfCases *= solveDP(now - before -1);
            before = now;
        }
        numOfCases *= solveDP(N - now);

        // ******************** 정답 출력 ********************
        sb.append(numOfCases);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP(int n) {
        if (dp[n] != 0) return dp[n];
        if (n==0 || n==1) return 1;
        if (n==2) return 2;

        dp[n] = solveDP(n-1) + solveDP(n-2);
        return dp[n];
    }
}
