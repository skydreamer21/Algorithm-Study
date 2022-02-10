// 1520번 내리막 길
/*
<문제 정보>
 1. 내리막길로만 가는 모든 경우의 수 출력

<변수 범위>
 1. 2초 / 128MB
 2. M,N 500 이하 자연수
 3. 각 지점 높이 10,000 이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1520 {
    static Integer[][] dp;
    static int[][] map;
    static int M;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M+1][N+1];
        dp = new Integer[M+1][N+1];
        for (int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        dp[M][N]=1;
        bw.write(String.valueOf(navi(1,1)));
        //for (int i=0;i<=M;i++) System.out.println(Arrays.toString(dp[i]));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int navi (int x, int y) {
        //System.out.printf("x : %d, y : %d\n",x,y);
        if(dp[x][y]==null) {
            dp[x][y]=0;
            if(x!=1 && map[x][y]>map[x-1][y]) dp[x][y]+=navi(x-1,y); //up
            if(x!=M && map[x][y]>map[x+1][y]) dp[x][y]+=navi(x+1,y); //down
            if(y!=1 && map[x][y]>map[x][y-1]) dp[x][y]+=navi(x,y-1); //left
            if(y!=N && map[x][y]>map[x][y+1]) dp[x][y]+=navi(x,y+1); //right
        }
        return dp[x][y];
    }
}