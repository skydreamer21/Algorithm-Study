// 2146번 다리 만들기 (G3) [bfs]
/*
<문제 정보>
 1. NxN 지도가 주어질 때, 두 대륙을 잇는 가장 짧은 다리의 길이 출력
 2. 0 : 바다, 1 : 육지

<변수 범위>
 1. 2초 / 192MB
 2. 1 <= N <= 100

<프로그램 진행>
 1. 맵을 돌며 각 섬들의 번호를 매기는 함수
 2. 가장자리 좌표를 큐에 넣는 함수
 3. 위의 큐를 시작으로 다른 섬에 닿을 때까지 진행하는 bfs

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Q2146 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static final int SEA = 0;
    static final int ISLAND = 1;
    static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N ;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // ******************** 메인 로직 ********************

        // 1. 맵을 돌며 섬 탐색
        int numOfIsland = 0;
        ArrayList<Deque<Pos1>> beachesOfIsland = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j] && map[i][j] == ISLAND) {
                    beachesOfIsland.add(getIslandInfo(++numOfIsland, i, j));
                }
            }
        }

        /*System.out.println("< map 확인 >");
        printMap(map);

        System.out.printf("\n < 가장자리 확인 >\n");
        int[][] beachMap = new int[N][N];
        for (int i=0; i<numOfIsland; i++) {
            for (Pos1 beach : beachesOfIsland.get(i)) {
                beachMap[beach.x][beach.y] = i+1;
            }
        }
        printMap(beachMap);*/


        // 2. 각 섬들마다 가장 짧은 다리 길이 확인
        int minLengthOfBridge = Integer.MAX_VALUE;
        for (int i=0; i<numOfIsland; i++) {
            int bridge =  getShortestBridge(i+1, beachesOfIsland.get(i));
//            System.out.printf("%d번 섬 : %d\n", i+1, bridge);
            minLengthOfBridge = Math.min(minLengthOfBridge,bridge);
        }




        // ******************** 정답 출력 ********************
        sb.append(minLengthOfBridge);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static Deque<Pos1> getIslandInfo (int islandNum, int startX, int startY) {
        Deque<Pos1> q = new ArrayDeque<>();
        q.add(new Pos1(startX, startY));
        map[startX][startY] = islandNum;

        Deque<Pos1> beach = new ArrayDeque<>();
        if (isBeach(startX, startY)) beach.add(new Pos1(startX, startY));

        Pos1 now;
        int nextX, nextY;
        boolean inRange;

        while (!q.isEmpty()) {
            now = q.poll();

            for (int[] d : DIRECTIONS) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<N;
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY] == ISLAND) {
                    map[nextX][nextY] = islandNum;
                    visited[nextX][nextY] = true;
                    q.add(new Pos1(nextX, nextY));
                    if (isBeach(nextX, nextY)) beach.add(new Pos1(nextX, nextY));
                }
            }
        }
        return beach;
    }

    public static boolean isBeach(int x, int y) {
        int nextX, nextY;
        boolean inRange;
        for (int[] d : DIRECTIONS) {
            nextX = x + d[0];
            nextY = y + d[1];
            inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<N;
            if (inRange && map[nextX][nextY] == SEA) return true;
        }
        return false;
    }

    public static int getShortestBridge (int islandNum, Deque<Pos1> q) {
        boolean[][] visited = new boolean[N][N];
        for (Pos1 pos : q) visited[pos.x][pos.y] = true;

        Pos1 now;
        int nextX, nextY;
        boolean inRange;
        int size;
        int bridge = -1;
        boolean findAns = false;

        while (!q.isEmpty()) {
            if (findAns) break;
            bridge++;
            size = q.size();

            for (int i=0; i<size; i++) {
                if (findAns) break;
                now = q.poll();

                for (int[] d : DIRECTIONS) {
                    nextX = now.x + d[0];
                    nextY = now.y + d[1];
                    inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<N;
                    if (inRange && !visited[nextX][nextY] && map[nextX][nextY] != islandNum) {
                        if (map[nextX][nextY] != SEA) {
                            findAns = true;
                            break;
                        }

                        q.add(new Pos1(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return bridge;
    }

    public static void printMap(int[][] map) {
        for (int i=0;i<N;i++) {
            for (int j=0; j<N; j++) {
                System.out.printf("%d ",map[i][j]);
            }
            System.out.println();
        }
    }
}

class Pos1 {
    int x, y;

    public Pos1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
