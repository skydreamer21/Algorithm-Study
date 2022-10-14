// 14600번 샤워실 바닥 깔기 (G5) [분할 정복]
/*
<문제 정보>
 1.

<변수 범위>
 1. 2초 / 512MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q14600 {
    static int K, N;
    static int tileLeft;
    static int tileNum = 1;
    static int[][] map;
    static boolean[][] visited;

    static final int OUT = -1;
    static final int LAST_PIECE = 100;
    static final int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}}; // DOWN, RIGHT, UP, LEFT

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        K = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2,K);
        map = new int[N][N];
        visited = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        int tmpX = Integer.parseInt(st.nextToken());
        int tmpY = Integer.parseInt(st.nextToken());
        int outX = N - tmpY;
        int outY = tmpX - 1;
        tileLeft = N*N - 1;
        map[outX][outY] = -1;
        visited[outX][outY] = true;

        // ******************** 메인 로직 ********************

        fillTile(0,0,N);

        // ******************** 정답 출력 *******************
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void fillTile(int x, int y, int size) {
        if (size == 2) {
            boolean hasOut = false;
            for (int i=0; i<2; i++) {
                if (hasOut) break;
                for (int j=0; j<2; j++) {
                    if (map[x+i][y+j] == OUT) {
                        hasOut = true;
                        break;
                    }
                }
            }

            if (hasOut) {
                for (int i=0; i<2; i++) {
                    for (int j=0; j<2; j++) {
                        if (map[x+i][y+j] == OUT) continue;
                        map[x+i][y+j] = tileNum;
                    }
                }
            }

            else {
                for (int i=0; i<2; i++) {
                    for (int j=0; j<2; j++) {
                        int tileX = x + i;
                        int tileY = y + j;
                        if (isCorner(tileX, tileY) == 0) {
                            map[tileX][tileY] = LAST_PIECE;
                        }
                        else map[tileX][tileY] = tileNum;
                    }
                }
            }
            tileNum++;
            return;
        }

        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                int nextX = x + (i*size/2);
                int nextY = y + (j*size/2);
                fillTile(nextX, nextY, size/2);
            }
        }
    }

    public static int isCorner (int x, int y) {
        int numOfOOB = 0;
        for (int[] d : DIR) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            boolean inRange = nextX >= 0 && nextY >= 0 && nextX < N && nextY < N;
            if (!inRange) numOfOOB++;
        }

        return numOfOOB;
    }

    public static void printMap() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }
    }
}













