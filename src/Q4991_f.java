// 4991번 로봇청소기 (G2)
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
import java.util.Arrays;

public class Q4991_f {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int numOfDirty = 0;

    static final int CLEAN = '.';
    static final int DIRTY = '*';
    static final int FURN = 'x';
    static final int START = 'o';

    static int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            numOfDirty = 0;
            // ******************** 입력 & 초기화 ********************

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (M == 0 && N == 0) break;
            map = new int[N][M];
            visited = new boolean[N][M];

            int startX = -1;
            int startY = -1;

            for (int i=0; i<N; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j=0; j<M; j++) {
                    map[i][j] = input[j];
                    if (map[i][j] == DIRTY) numOfDirty++;
                    if (map[i][j] == START) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            /*
            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    System.out.printf("%d ",map[i][j]);
                }
                System.out.println();
            }
             */

            // ******************** 메인 로직 ********************
            int minDist = 0;

            while (numOfDirty > 0) {
                int[] cleanRes = bfs(startX ,startY);
                if (cleanRes[0] == -1) {
                    minDist = -1;
                    break;
                }
                numOfDirty--;
                minDist += cleanRes[0];
                startX = cleanRes[1];
                startY = cleanRes[2];
                map[startX][startY] = CLEAN;
            }


            // ******************** 정답 출력 ********************
            sb.append(minDist).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] bfs(int x, int y) {
        for (int i=0;i<N;i++) Arrays.fill(visited[i], false);

        Deque<Pair25> q = new ArrayDeque<>();
        q.add(new Pair25(x, y));
        visited[x][y] = true;

        Pair25 now;
        int nextX, nextY;
        boolean inRange;
        int size;
        int dist = 0;

        while (!q.isEmpty()) {
            dist++;
            size = q.size();

            for (int i=0; i<size; i++) {
                now = q.poll();

                for (int[] d : DIR) {
                    nextX = now.x + d[0];
                    nextY = now.y + d[1];
                    inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                    if (inRange && !visited[nextX][nextY] && map[nextX][nextY] != FURN) {
                        if (map[nextX][nextY] == DIRTY) return new int[] {dist, nextX, nextY};
                        visited[nextX][nextY] = true;
                        q.add(new Pair25(nextX, nextY));
                    }
                }
            }
        }
        return new int[] {-1, -1, -1};
    }
}

class Pair25 {
    int x, y;

    public Pair25 (int x, int y) {
        this.x=x;
        this.y=y;
    }
}
