// 1743번 음식물 피하기 (S1) [bfs]
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
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q1743 {
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int maxGarbage = -1;

    static final int EMPTY = 0;
    static final int GARBAGE = -1;
    static final int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = GARBAGE;
        }

        // ******************** 메인 로직 ********************
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if (!visited[i][j] && map[i][j] == GARBAGE) {
                    maxGarbage = Math.max(maxGarbage, bfs(i, j));
                }
            }
        }

        // ******************** 정답 출력 ********************
        sb.append(maxGarbage);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int x, int y) {
        Deque<Pair27> q = new ArrayDeque<>();
        q.add(new Pair27(x, y));
        visited[x][y] = true;

        Pair27 now;
        int nextX, nextY;
        boolean inRange;
        int sizeOfGarbage = 1;

        while (!q.isEmpty()) {
            now = q.poll();

            for (int[] d : DIR) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX > 0 && nextY > 0 && nextX <= N && nextY <= M;

                if (inRange && !visited[nextX][nextY] && map[nextX][nextY] == GARBAGE) {
                    sizeOfGarbage++;
                    visited[nextX][nextY] = true;
                    q.add(new Pair27(nextX, nextY));
                }

            }
        }
        return sizeOfGarbage;
    }
}

class Pair27 {
    int x, y;

    public Pair27(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
