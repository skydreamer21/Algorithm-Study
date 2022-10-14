// 2842번 집배원 한상덕
/*
<문제 정보>
 1. 배달하면서 방문한 칸 중 고도가 가장 높은 곳과 낮은 곳의 차를 피로도
 2. 피로도의 최솟값 출력

<변수 범위>
 1. 3초 / 256MB
 2. 마을 크기 2<=N<=50
 3. 고도 1,000,000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Q2842 {
    static int N;
    static int[][] map;
    static int[][] heightMap;
    static boolean[][] visited;
    static int[][] parent;
    static ArrayList<Pair9> locationList = new ArrayList<>();
    static int[][] dir = {{-1,0},{-1,-1},{0,-1},{-1,1},{1,0},{1,1},{0,1},{1,-1}};
    static final int PO = 'P';
    static final int HOUSE = 'K';
    static final int PATH = '.';


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        heightMap = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        parent = new int[N+1][N+1];
        initSet(); // parent 초기화
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 마을 맵
        for (int i=1;i<=N;i++) {
            int j=1;
            for (char c : br.readLine().toCharArray()) map[i][j++] = c;
        }
        // 고도 맵
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) {
                heightMap[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == PO || map[i][j] == HOUSE) {
                    min = Math.min(min, heightMap[i][j]);
                    max = Math.max(max, heightMap[i][j]);
                    locationList.add(new Pair9(i, j));
                }
            }
        }
        System.out.printf("max : %d, min : %d\n",max,min);
        /*
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) System.out.printf("%d ",map[i][j]);
            System.out.println();
        }
        System.out.println();
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) System.out.printf("%d ",heightMap[i][j]);
            System.out.println();
        }
         */

        // 1. 주어진 우체국과 집들의 최저 최대 고도를 이용해서 집합 만들기
        int nextX, nextY;
        Pair9 now;
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if (rangeCheck(min, max, heightMap[i][j])) {
                    now = new Pair9(i, j);
                    for (int k=0;k<3;k++) {
                        nextX = i + dir[k][0];
                        nextY = j + dir[k][1];
                        if(inMap(nextX, nextY) && rangeCheck(min, max, heightMap[nextX][nextY])) {
                            System.out.printf("now : (%d, %d) next : (%d, %d)\n",i,j,nextX,nextY);
                            union(now, new Pair9(nextX, nextY));
                        }
                    }
                }
            }
        }

        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) System.out.printf("%d ",parent[i][j]);
            System.out.println();
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void initSet() {
        int order = 1;
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) parent[i][j] = order++;
        }
    }

    public static Pair9 RootToPair (int root) {
        int y = root%N==0 ? 5 : root%N;
        int x = root%N==0 ? root/N : root/N+1;
        return (new Pair9(x, y));
    }

    public static int find(Pair9 a) {
        if(parent[a.x][a.y] == N*(a.x-1)+a.y) return parent[a.x][a.y];
        return parent[a.x][a.y] = find(RootToPair(parent[a.x][a.y]));
    }

    public static void union (Pair9 A, Pair9 B) {
//        System.out.printf("<union> A(%d,%d) B(%d,%d)\n",A.x,A.y,B.x,B.y);
        int Ar = find(A);
        int Br = find(B);
//        System.out.printf("Ar : %d, Br : %d\n",Ar,Br);

        if(Ar<Br) parent[RootToPair(Br).x][RootToPair(Br).y] = Ar;
        else parent[RootToPair(Ar).x][RootToPair(Ar).y] = Br;
    }

    public static boolean isSameSet (Pair9 A, Pair9 B) { return find(A)==find(B); }

    public static boolean rangeCheck (int min, int max, int target) {
        return target>=min && target<=max;
    }

    public static boolean inMap (int x, int y) { return x>=1 && y>=1 && x<=N && y<=N; }
}

class Pair9 {
    int x, y;

    public Pair9 (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equal(Pair9 o) {
        return this.x == o.x && this.y == o.y;
    }
}























