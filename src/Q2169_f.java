// 2169번 로봇 조종하기 (G2) [dp] - FAIL
/*
<문제 정보>
 1. 로봇은 왼쪽, 오른쪽, 아래로만 움직일 수 있다.

<변수 범위>
 1. 1초 / 512MB
 2. 1 <= N, M <= 1,000
 3. 배열의 각 요소 절댓값 100 이하 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2169_f {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;

    static final int EMPTY = Integer.MIN_VALUE;
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;

    static int debug_cnt = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0;i<N;i++) {
            Arrays.fill(dp[i], EMPTY);
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ******************** 메인 로직 ********************
        visited[0][0] = true;
        int maxValue = solveDP(0,0);
        System.out.printf("cnt : %d\n", debug_cnt);

        /*System.out.printf("<DP Result>\n");
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                System.out.printf("%d ",dp[i][j]);
            }
            System.out.println();
        }
        System.out.println();*/

        // ******************** 정답 출력 ********************

        sb.append(maxValue);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP (int x, int y) {
        debug_cnt++;
//        System.out.printf("[IN] (%d, %d)\n" ,x, y);
        if (dp[x][y] != EMPTY) {
//            System.out.printf("[OUT - already computed] (%d, %d)\n" ,x, y);
            return dp[x][y];
        }

        if ( x == N-1 ) {
            if ( y == M-1 ) return dp[x][y] = map[x][y];
            visited[x][y] = true;
            dp[x][y] = map[x][y] + solveDP(x, y+1);
            visited[x][y] = false;
//            System.out.printf("[OUT - last Line] (%d, %d)\n" ,x, y);
            return dp[x][y];
        }

        int nextX = 0;
        int nextY = 0;
        boolean inRange;
        for (int i=0;i<3;i++) {
            switch(i) {
                case LEFT:
                    nextX = x;
                    nextY = y-1;
                    break;
                case RIGHT:
                    nextX = x;
                    nextY = y+1;
                    break;
                case DOWN:
                    nextX = x+1;
                    nextY = y;
            }
            inRange = nextX >=0 && nextY >= 0 && nextX < N && nextY < M;
            if (!inRange || visited[nextX][nextY]) continue;

            visited[nextX][nextY] = true;
            dp[x][y] = Math.max(dp[x][y], map[x][y] + solveDP(nextX, nextY));
            visited[nextX][nextY] = false;
        }
//        System.out.printf("[OUT - all direction searched] (%d, %d)\n" ,x, y);

        return dp[x][y];
    }
}
