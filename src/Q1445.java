// 1445번 일요일 아침의 데이트 (G2)
/*
<문제 정보>
 1. 쓰레기가 있는 칸을 최소로, 만약 여러개라면 쓰레기와 인접한 칸을 최소로 지나도록
    지나는 쓰레기의 칸과 인접한 칸을 출력

<변수 범위>
 1. 2초 / 128MB
 2. 세로 가로 3<=N,M<=50

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Q1445 {
    static int N, M;
    static int[][] map;
    static int[][][] pathInfo;
    static boolean[][] visited;
    static int startX, startY, flowerX, flowerY;
    static boolean findAns = false;

    static int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    static final int EMPTY = '.';
    static final int GARBAGE = 'g';
    static final int GARBAGE_ADJ = 'a';
    static final int START = 'S';
    static final int FLOWER = 'F';

    static final int G = 0;
    static final int G_ADJ = 1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        pathInfo = new int[N][M][2];
        visited = new boolean[N][M];
        int nextX, nextY;
        boolean inRange;
        for (int i=0;i<N;i++) {
            int j=-1;
            for (char c : br.readLine().toCharArray()) {
                j++;
                switch(c) {
                    case EMPTY:
                        if(map[i][j]==GARBAGE_ADJ) continue;
                        break;
                    case GARBAGE:
                        for (int[] d : dir) {
                            nextX = i+d[0];
                            nextY = j+d[1];
                            inRange = nextX>=0 && nextY>=0 & nextX<N && nextY<M;
                            if(inRange && (map[nextX][nextY]==0 || map[nextX][nextY]==EMPTY)) map[nextX][nextY] = GARBAGE_ADJ;
                        }
                        break;
                    case START:
                        startX = i;
                        startY = j;
                        break;
                    case FLOWER:
                        flowerX = i;
                        flowerY = j;
                }
                map[i][j]=c;
            }
        }
        System.out.printf("start : %d, %d // flower : %d, %d\n",startX, startY, flowerX, flowerY);

        bfs_all();
//        printMap();
//        System.out.println();
        printPathInfo();
        sb.append(pathInfo[flowerX][flowerY][0]).append(" ").append(pathInfo[flowerX][flowerY][1]);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs_all() {
        Deque<Pair20> gAdjQ = new ArrayDeque<>();
        PriorityQueue<Pair20> garbagePQ = new PriorityQueue<>();
        bfs_empty(gAdjQ, startX, startY, 0,0);
        if (findAns) return;
//        System.out.println("처음에 발견못함");

        Pair20 now;
        int nextX, nextY;
        boolean inRange;

        for (int[] d: dir) {
            nextX = startX+d[0];
            nextY = startY+d[1];
            inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
            if (inRange && map[nextX][nextY]==GARBAGE) {
                visited[nextX][nextY] = true;
                pathInfo[nextX][nextY][G] = 1;
                pathInfo[nextX][nextY][G_ADJ] = 0;
                garbagePQ.add(new Pair20 (nextX, nextY, 1, 0));
            }
        }
        if (!garbagePQ.isEmpty() && gAdjQ.isEmpty()) gAdjQ.add(garbagePQ.poll());

        while(!gAdjQ.isEmpty()) {
            now = gAdjQ.poll();

            for (int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
//                if(inRange && now.x==3 && now.y==2) System.out.printf("(3,2) 주변 방문 체크 : (%d, %d) -> %b\n",nextX, nextY,visited[nextX][nextY]);
                if (inRange && !visited[nextX][nextY]) {
//                    if(nextX==1 && nextY==3) System.out.printf("어디서 flower 방문체크 ? : (%d, %d)\n",now.x, now.y);
                    visited[nextX][nextY] = true;
//                    if(now.x==3 && now.y==2) System.out.printf("(3,2)에서 어디로 가는지 : (%d, %d)\n",nextX, nextY);
                    switch(map[nextX][nextY]) {
                        case FLOWER:
                            pathInfo[nextX][nextY][G] = now.g;
                            pathInfo[nextX][nextY][G_ADJ] = now.gAdj;
                            return;
                        case EMPTY:
                            bfs_empty(gAdjQ, nextX, nextY, now.g, now.gAdj);
                            if (findAns) return;
                            break;
                        case GARBAGE_ADJ:
                            pathInfo[nextX][nextY][G] = now.g;
                            pathInfo[nextX][nextY][G_ADJ] = now.gAdj+1;
                            gAdjQ.add(new Pair20(nextX, nextY, now.g, now.gAdj+1));
                            break;
                        case GARBAGE:
                            pathInfo[nextX][nextY][G] = now.g+1;
                            pathInfo[nextX][nextY][G_ADJ] = now.gAdj;
                            garbagePQ.add(new Pair20(nextX, nextY, now.g+1, now.gAdj));
                    }
                }
            }

            Pair20 tmp;
            if (!garbagePQ.isEmpty() && gAdjQ.isEmpty()) {
                tmp = garbagePQ.poll();
                System.out.printf("garbage : (%d, %d)\n",tmp.x, tmp.y);
                gAdjQ.add(tmp);
//                gAdjQ.add(garbagePQ.poll());
            }
        }

    }

    /*public static boolean checkAdjGarbage(int garbageX, int garbageY) {
        int nextX, nextY;
        boolean inRange;

        for (int[] d : dir) {
            nextX = garbageX+d[0];
            nextY = garbageY+d[1];
            inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
            if(inRange && map[nextX][nextY]==GARBAGE) return true;
        }
        return false;
    }*/

    public static void bfs_empty(Deque<Pair20> gAdjQ, int x, int y, int g, int gAdj) {
        Deque<Empty> q = new ArrayDeque<>();
        q.add(new Empty(x, y));
        pathInfo[x][y][G] = g;
        pathInfo[x][y][G_ADJ] = gAdj;
        visited[x][y] = true;

        Empty now;
        int nextX, nextY;
        boolean inRange;

        while(!q.isEmpty()) {
            now = q.poll();
//            System.out.printf("now : (%d,%d)\n",now.x,now.y);

            for (int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY]!=GARBAGE) {
                    visited[nextX][nextY] = true;
                    pathInfo[nextX][nextY][G] = g;
                    if (map[nextX][nextY]==GARBAGE_ADJ) {
                        pathInfo[nextX][nextY][G_ADJ] = gAdj+1;
                        gAdjQ.add(new Pair20(nextX, nextY, g, gAdj+1));
                        continue;
                    }
                    pathInfo[nextX][nextY][G_ADJ] = gAdj;
                    if (map[nextX][nextY]==FLOWER) {
                        findAns = true;
//                        System.out.println("꽃발견");
                        return;
                    }
                    q.add(new Empty(nextX, nextY));
//                    System.out.println("q에 추가");
                }
            }
        }
//        System.out.println("큐가 다 비어서 나감");
    }

    public static void printMap() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) System.out.printf("%d ",map[i][j]);
            System.out.println();
        }
    }

    public static void printPathInfo() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) System.out.printf("[%d, %d] ",pathInfo[i][j][0], pathInfo[i][j][1]);
            System.out.println();
        }
    }
}

class Empty {
    int x, y;

    public Empty(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Pair20 implements Comparable<Pair20>{
    int x, y, g, gAdj;

    public Pair20 (int x, int y, int g, int gAdj) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.gAdj = gAdj;
    }

    @Override
    public int compareTo(Pair20 o) {
        return this.g==o.g ? this.gAdj-o.gAdj : this.g-o.g;
    }
}















