// 2665번 미로 만들기 (G4) [최단경로 - 다익스트라 풀이 (아직)]
/*
<문제 정보>
 1. 주어진 미로(nXn)에서 시작에서 끝으로 갈 수 있게 할 때 바꿔야하는 검은방 개수의 최솟값 출력

<변수 범위>
 1. 1초 / 128MB
 2. 1<=n<=50
 3. 0 : 검은 방, 1 : 흰 방

<프로그램 진행>
 1. N^2 X N^2
 2. 처음에 섬의 개수를 알아내고, 각각의 섬에 번호 표시를 해주어야함
 3. 전체 맵을 돌면서 각 섬에서 다른 섬까지의 최단거리를 bfs로 찾아낸다.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q2665 {
    static int N;
    static int islandNum = 0;
    static boolean[][] map;
    static int[][] islandMap;
    static boolean[][] visited;
    static int[][] dist;
    static ArrayList<ArrayList<Pair18>> islandEdge = new ArrayList<>();

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        islandMap = new int[N][N];
        visited = new boolean[N][N];
        for (int i=0;i<N;i++) {
            int j=0;
            for (char c : br.readLine().toCharArray()) map[i][j++] = c=='1';
        }
        getIslandInfo();
        printMap();


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getIslandInfo() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if(map[i][j] && !visited[i][j]) {
                    islandEdge.add(new ArrayList<>());
                    bfs(i,j,++islandNum);
                }
            }
        }
    }

    public static void bfs(int x, int y, int island) {
        Deque<Pair18> q = new ArrayDeque<>();
        q.add(new Pair18(x, y));
        visited[x][y] = true;
        islandMap[x][y] = island;
        Pair18 now;
        int nextX, nextY;
        boolean inRange;
        boolean isEdge;

        while(!q.isEmpty()) {
            now = q.poll();
            isEdge = false;

            for (int[] d : dir) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<N;
                if (inRange) {
                    if (!map[nextX][nextY]) isEdge = true;
                    else if (!visited[nextX][nextY]) {
                        islandMap[nextX][nextY] = island;
                        visited[nextX][nextY] = true;
                        q.add(new Pair18(nextX,nextY));
                    }
                }
            }
            if (isEdge) islandEdge.get(island-1).add(new Pair18(now.x,now.y));
        }
    }

    public static void printMap() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) System.out.printf("%d ",islandMap[i][j]);
            System.out.println();
        }
    }
}

class Pair18 {
    int x, y;

    public Pair18 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
