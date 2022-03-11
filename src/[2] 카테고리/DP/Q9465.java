// 9465번 스티커 (S1)
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB
 2. 스티커 2n 개 1<=n<=100,000
 3. 각 점수는 100이하의 음이 아닌 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q9465 {
    static int N;
    static int[][] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int ans;
        while (T-->0) {
            N = Integer.parseInt(br.readLine());
            dp = new int[3][N+1];
            for (int i=1;i<=2;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1;j<=N;j++) dp[i][j]=Integer.parseInt(st.nextToken());
            }
            solveDP();
            ans = Math.max(dp[0][N], Math.max(dp[1][N],dp[2][N]));
            sb.append(ans).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solveDP() {
        for (int j=2;j<=N;j++) {
            for (int i=0;i<3;i++) {
                switch (i) {
                    case 0 :
                        dp[i][j]=Math.max(dp[1][j-1],dp[2][j-1]);
                        break;
                    case 1 :
                        dp[i][j]=Math.max(dp[0][j-1],dp[2][j-1])+dp[i][j];
                        break;
                    case 2 :
                        dp[i][j]=Math.max(dp[0][j-1],dp[1][j-1])+dp[i][j];
                }
            }
        }
    }
}


