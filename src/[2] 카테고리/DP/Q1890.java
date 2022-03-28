// 1890번 점프 (S2) [dp]
/*
<문제 정보>
 1. 경로 개수 출력

<변수 범위>
 1. 1초 / 128MB
 2. 게임판 크기 4<=N<=100
 3. 점프 칸 0이상 9이하
 4. 경로의 개수는 2^63 -1 을 넘지 않음

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1890 {
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new long[N+1][N+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i],-1);
            for (int j=1;j<=N;j++) map[i][j]=Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(solve(1,1)));

        /*System.out.println();
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) System.out.printf("%d ",dp[i][j]);
            System.out.println();
        }*/

        bw.flush();
        bw.close();
        br.close();
    }
    public static long solve (int x, int y) {
        if (dp[x][y]==-1) {
            dp[x][y]=0;
            if (x+map[x][y]<=N) {
                if(y==N && x+map[x][y]==N) dp[x][y]=1;
                else dp[x][y]+=solve(x+map[x][y],y);
            }
            if (y+map[x][y]<=N) {
                if(x==N && y+map[x][y]==N) dp[x][y]=1;
                else dp[x][y]+=solve(x,y+map[x][y]);
            }
        }
        return dp[x][y];
    }
}














