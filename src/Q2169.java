// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2169 {
    static int N, M;
    static int[][] map;
    static int[][][] dp;
    static boolean[][] visited;
    static int originX;

    static final int EMPTY = Integer.MIN_VALUE;
    static final int LEFT = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;

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
        dp = new int[N][M][3];
        visited = new boolean[N][M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], EMPTY);
            }
        }


        // ******************** 메인 로직 ********************
        for (int i=N-1; i>=0; i--) {
            originX = i;
            for (int dir=0;dir<3;dir++) {
                visited[i][0] = true;
                solveDP(i, 0, dir, 0);
                visited[i][0] = false;
            }
        }

        int maxValue = Math.max(dp[0][0][RIGHT], dp[0][0][DOWN]);
        for (int i=0;i<N;i++) {
            for (int j=0; j<M; j++) {
                for (int dir=0;dir<3;dir++) {
                    System.out.printf("[%d]",dp[i][j][dir]);
                }
                System.out.printf(" ");
            }
            System.out.println();
        }
        System.out.println();

        // ******************** 정답 출력 ********************

        sb.append(maxValue);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP(int x, int y, int direction, int space) {
        String d = direction == 0 ? "LEFT" : direction == 1 ? "RIGHT" : "DOWN";
        printSpace(space);
        System.out.printf("[IN] (%d,%d) dir:%s\n", x,y,d);
        if ( dp[x][y][direction] != EMPTY  || x > originX ) {
            dp[x][y][direction] = dp[x][y][direction] == EMPTY ? 0 : dp[x][y][direction];
            printSpace(space);
            System.out.printf("[OUT - EMPTY or Before For state] (%d,%d) dir:%s\n", x,y,d);
            return dp[x][y][direction];
        }
        if ( x == N-1 && y == M-1) {
            printSpace(space);
            System.out.printf("[OUT - GOAL] (%d,%d) dir:%s\n", x,y,d);
            return dp[x][y][direction] = map[x][y];
        }

        int nextX = 0;
        int nextY = 0;
        boolean inRange;
        switch(direction) {
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


        if (!inRange || visited[nextX][nextY] ) {
            printSpace(space);
            System.out.printf("[OUT - next OOB or visited] (%d,%d) dir:%s\n", x,y,d);
            return EMPTY;
        }

        int maxValue = Integer.MIN_VALUE;
        for ( int dir=0; dir<3; dir++ ) {
            visited[nextX][nextY] = true;
            maxValue = Math.max(maxValue, solveDP(nextX, nextY, dir, space+4));
            printSpace(space);
            System.out.printf("%d -> maxValue : %d\n",dir, maxValue);
            visited[nextX][nextY] = false;
        }

        dp[x][y][direction] = map[x][y] + maxValue;
        printSpace(space);
        System.out.printf("[OUT - all searched] (%d,%d) dir:%s\n", x,y,d);
        return dp[x][y][direction];
    }

    public static void printSpace(int n) {
        for (int i=0;i<n;i++) {
            System.out.printf(" ");
        }
    }
}
