// 14226번 이모티콘 (G5)
/*
<문제 정보>
 1. 이모티콘 만들기 연산
    - 화면의 모든 이코티콘을 복사 -> 클립보드 저장
    - 붙여넣기
    - 화면의 이모티콘중 한개 삭제
 2. 연산 당 1초
 3. 클립보드는 덮어쓰기
    - 비어있는 상태에서는 붙여넣기 불가
 4. 이모티콘 S개를 만드는데 걸리는 시간의 최솟값

<변수 범위>
 1. 2초 / 512MB
 2. 2<=S<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q14226 {
    static int S;
    static int[][] dp;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        S = Integer.parseInt(br.readLine());
        dp = new int[S+1][S+1];

        sb.append(solveDP(1,0));



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP(int n, int clip) {
        if (n==S) return 0;
        if (dp[n][clip] != 0) return dp[n][clip];

        dp[n][clip] = INF;
        if (n!=1) dp[n][clip] = 1 + solveDP(n-1, clip);
        if (clip!=0 || n+clip<=S) dp[n][clip] = Math.min(dp[n][clip], 1 + solveDP(n+clip,clip));
        if (n!=clip) dp[n][clip] = Math.min(dp[n][clip], 1 + solveDP(n,n));

        return dp[n][clip];
    }

}












