// 4991번 로봇청소기 (G2) [bfs & 백트래킹]
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1. 먼지쌓인곳 노드로 해서 인접 행렬 만들자
 2. 거리가 같은 곳이나 더 먼곳이라도 먼저 방문해야 되는 곳이 있음 -> 완전탐색으로 접근

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.ArrayList;

public class Q4991 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int numOfDirty = 0;
    static int[][] graph;
    static ArrayList<Pair26> dirtyList;
    static int minDist = Integer.MAX_VALUE;
    static boolean[] dirtyVisited;

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
            minDist = Integer.MAX_VALUE;
            dirtyList = new ArrayList<>();
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
                    if (map[i][j] == DIRTY) {
                        map[i][j] = numOfDirty++;
                        dirtyList.add(new Pair26(i, j));
                    }
                    if (map[i][j] == START) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            graph = new int[numOfDirty][numOfDirty];
            dirtyVisited = new boolean[numOfDirty];

            /*
            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    System.out.printf("%d ",map[i][j]);
                }
                System.out.println();
            }
             */

            // ******************** 메인 로직 ********************
            boolean isPossible = true;

            for (Pair26 dirty : dirtyList) {
                int dirtyNum = map[dirty.x][dirty.y];
                int[] dist = bfs(dirty.x, dirty.y);
                if (dist[0] == -1) {
                    isPossible = false;
                    break;
                }
                System.arraycopy(dist, 0, graph[dirtyNum], 0, numOfDirty);
            }

            if (!isPossible) {
                sb.append(-1).append("\n");
                continue;
            }

            int [] distFromStart = bfs(startX, startY);
            for (int i=0; i<numOfDirty; i++) {
                Arrays.fill(dirtyVisited, false);
                dirtyVisited[i] = true;
                dfs(1, i, distFromStart[i]);
                dirtyVisited[i] = false;
            }


            // ******************** 정답 출력 ********************
            sb.append(minDist).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int dirty, int sum) {
        if (depth == numOfDirty) {
            minDist = Math.min(minDist, sum);
            return;
        }

        for (int i=0; i<numOfDirty; i++) {
            if (dirtyVisited[i]) continue;
            dirtyVisited[i] = true;
            dfs(depth+1, i, sum + graph[dirty][i]);
            dirtyVisited[i] = false;
        }
    }

    public static int[] bfs(int x, int y) {
        for (int i=0;i<N;i++) Arrays.fill(visited[i], false);
        int dirty = numOfDirty;
        int[] distances = new int[numOfDirty];

        Deque<Pair26> q = new ArrayDeque<>();
        q.add(new Pair26(x, y));
        visited[x][y] = true;
        if (map[x][y] < numOfDirty) {
            distances[map[x][y]] = 0;
            dirty--;
        }

        Pair26 now;
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
                        if (map[nextX][nextY] < numOfDirty) {
                            distances[map[nextX][nextY]] = dist;
                            dirty--;
                            if (dirty == 0) return distances;
                        }
                        visited[nextX][nextY] = true;
                        q.add(new Pair26(nextX, nextY));
                    }
                }
            }
        }
        return new int[] {-1};
    }
}

class Pair26 {
    int x, y;

    public Pair26 (int x, int y) {
        this.x=x;
        this.y=y;
    }
}
