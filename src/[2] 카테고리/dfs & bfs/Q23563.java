// 23563번 벽타기 (G3) [bfs]
/*
<문제 정보>
 1. 맵의 시작에서 끝까지 간다.
 2. 벽을 타고 인접한 칸을 이동할 때는 0초


<변수 범위>
 1. 1초 / 256MB
 1. 1<=H,W<=500

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q23563 {
    static int H, W;
    static int[][] map;
    static boolean[][] visited;

    static final int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static final int WALL = '#';
    static final int EMPTY = '.';
    static final int START = 'S';
    static final int END = 'E';
    static final int IMPOSSIBLE = -1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W];

        char[] input;
        int startX = 0;
        int startY = 0;
        for (int i=0;i<H;i++) {
            input = br.readLine().toCharArray();
            for (int j=0;j<W;j++) {
                map[i][j] = input[j];
                if (map[i][j] == START) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // ******************** 메인 로직 ********************
        int minDist = bfs(startX, startY);
        System.out.println();

        // ******************** 정답 출력 ********************
        sb.append(minDist);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int startX, int startY) {
        Deque<Pair22> q = new ArrayDeque<>();
        if (adjWallCheck(startX, startY)) {
            System.out.print("\n< 0으로 갈수 있는 곳 >\n");
            if (addWallPath(q, startX, startY)) return 0;
        }
        else {
            q.add(new Pair22(startX, startY));
            visited[startX][startY] = true;
        }

        Pair22 now;
        int nextX, nextY;
        boolean inRange;
        int size;
        int dis = 0;

        while (!q.isEmpty()) {
            dis++;
            System.out.printf("\n< %d로 갈수 있는 곳 >\n", dis);
            size = q.size();

            for (int i=0;i<size;i++) {
                now = q.poll();

                for (int[] d : DIR) {
                    nextX = now.x + d[0];
                    nextY = now.y + d[1];
                    inRange = nextX >= 0 && nextY >= 0 && nextX < H && nextY < W;

                    if (inRange && !visited[nextX][nextY] && map[nextX][nextY] != WALL) {
                        if (map[nextX][nextY] == END) return dis;
                        visited[nextX][nextY] = true;
                        q.add(new Pair22(nextX, nextY));
                        System.out.printf("(%d,%d) ",nextX, nextY);

                        // 벽을 타고 이동할 수 있는 곳도 모두 큐에 추가
                        if (adjWallCheck(nextX, nextY) && addWallPath(q, nextX, nextY)) return dis;
                    }
                }
            }
        }
        return IMPOSSIBLE;
    }

    public static boolean addWallPath(Deque<Pair22> mainQ, int x, int y) {
        Deque<Pair22> q = new ArrayDeque<>();
        mainQ.add(new Pair22(x, y));
        q.add(new Pair22(x, y));
        visited[x][y] = true;

        Pair22 now;
        int nextX, nextY;
        boolean inRange;

        while (!q.isEmpty()) {
            now = q.poll();

            for (int[] d : DIR) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX >= 0 && nextY >= 0 && nextX < H && nextY < W;
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY] != WALL && adjWallCheck(nextX, nextY)) {
                    if (map[nextX][nextY] == END) return true;
                    mainQ.add(new Pair22(nextX, nextY));
                    System.out.printf("w(%d, %d) ", nextX, nextY);
                    q.add(new Pair22(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
        return false;
    }

    public static boolean adjWallCheck(int x, int y) {
        int nextX, nextY;
        boolean inRange;
        for (int[] d : DIR) {
            nextX = x + d[0];
            nextY = y + d[1];
            inRange = nextX >= 0 && nextY >= 0 && nextX < H && nextY < W;
            if (inRange && map[nextX][nextY] == WALL) return true;
        }
        return false;
    }
}

class Pair22 {
    int x, y;

    public Pair22(int x, int y) {
        this.x = x;
        this.y = y;
    }
}











