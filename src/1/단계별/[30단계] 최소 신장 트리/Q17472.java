// 17472번 다리 만들기2
/*
<문제 정보>
 1. 섬을 모두 잇는 다리 길이의 최솟값 출력
    - 다리 길이는 2 이상
    - 다리 중간에 다른 섬있으면 그 섬은 지나는 게 아님
    - 연결이 불가능하면 -1 출력

<변수 범위>
 1. 1초 / 512MB
 2. 지도 크기 1<=N,M<=10
 3. 3<=NxM<=100
 4. 2<=섬의 개수<=6

<프로그램 진행>
 1. map을 한번 탐색하면서 섬 고유 번호와 각 섬을 이루고 있는 좌표들에 대한 정보를 얻음 (완료)
 2. 섬을 이루는 각 좌표들에 대해 탐색 시작 (완료)
    - 가로, 세로 탐색을 통해 다른 섬들까지의 거리를 알아냄
    - 이부분이 완료되면 인접리스트 그래프를 얻을 수 있음
 3. Kruskal 알고리즘을 통해 mst로 최고 다리 길이 구하기

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q17472 {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<ArrayList<Point1>> isld = new ArrayList<>();
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    final static int INF = Integer.MAX_VALUE;
    static int[] parent;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        // step1. map을 한번 탐색하면서 섬 고유 번호와 각 섬을 이루고 있는 좌표들에 대한 정보를 얻음
        // + 좌표는 바다와 맞닿은 경계좌표만 넣음
        int island=0;
        isld.add(new ArrayList<>()); // index 1부터 맞추기위함
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                if(visited[i][j] || map[i][j]==0) continue;
                else {
                    isld.add(new ArrayList<>());
                    island++;
                    Search(island,i,j);
                }
            }
        }

        // step1 출력
        for (int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
/*        for (int i=1;i<=island;i++) {
            System.out.printf("%d번 섬 좌표 목록 \n",i);
            for (Point1 v : isld.get(i)) {
                System.out.printf("(%d,%d) ",v.x,v.y);
            }
            System.out.println("\n");
        }*/

        // step2. ArrayList로 만들어야함..
        PriorityQueue<Bridge> pq = new PriorityQueue<>();
        int dis;
        for (int i=1;i<=island;i++) {
            for (int j=1;j<i;j++) {
                dis = getDist(i,j);
                if (dis!=INF) pq.add(new Bridge(i,j,dis));
            }
        }


        // step2 출력
        for (Bridge b : pq) {
            System.out.printf("isld1 : %d, isld2 : %d, dist : %d\n",b.isld1,b.isld2,b.dist);
        }
        System.out.println();

        // step3.
        parent = new int[island+1];
        initSet(island);
        int ans=0;
        int cnt=0;
        Bridge now;
        while (!pq.isEmpty()) {
            now = pq.poll();
            if (!union(now.isld1,now.isld2)) continue;
            System.out.printf("isld1 : %d, isld2 : %d, dist : %d\n",now.isld1,now.isld2,now.dist);
            ans+=now.dist;
            cnt++;
            if (cnt==island-1) break;
        }
        bw.write(String.valueOf(cnt==island-1 ? ans : -1));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Search(int island, int x, int y) {
        Deque<Point1> stack = new ArrayDeque<>();
        stack.add(new Point1(x,y));
        visited[x][y]=true;
        Point1 now;
        int nextX, nextY;
        boolean inRange;
        boolean added;

        while (!stack.isEmpty()) {
            added = false;
            now = stack.pollLast();
            set(now,island);

            for (int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                if(!added && inRange && map[nextX][nextY]==0) {
                    isld.get(island).add(now);
                    added=true;
                } // 경계만 좌표 목록에 추가
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY]!=0) {
                    visited[nextX][nextY]=true;
                    stack.add(new Point1(nextX,nextY));
                }
            }
        }
    }

    public static int get (Point1 p) {
        return map[p.x][p.y];
    }

    public static void set (Point1 p, int island) {
        map[p.x][p.y] = island;
    }

    public static int getDist (int isld1, int isld2) {
        int min = INF;
        Point1 p1,p2;
        int dis=0;
        for (int i=0;i<isld.get(isld1).size();i++) {
            p1 = isld.get(isld1).get(i);
            for (int j=0;j<isld.get(isld2).size();j++) {
                p2 = isld.get(isld2).get(j);
                if (p1.x!=p2.x && p1.y!=p2.y) continue;

                if (p1.x==p2.x) {
                    if (p1.y>p2.y) {
                        if (map[p1.x][p1.y-1]!=isld1 && map[p2.x][p2.y+1]!=isld2) dis = Math.abs(p1.y-p2.y)-1;
                    }
                    else if (map[p2.x][p2.y-1]!=isld1 && map[p1.x][p1.y+1]!=isld2) dis = Math.abs(p1.y-p2.y)-1;
                }
                else {
                    if (p1.x>p2.x) {
                        if (map[p1.x-1][p1.y]!=isld1 && map[p2.x+1][p2.y]!=isld2) dis = Math.abs(p1.x-p2.x)-1;
                    }
                    else if (map[p2.x-1][p2.y]!=isld1 && map[p1.x+1][p1.y]!=isld2) dis = Math.abs(p1.x-p2.x)-1;
                }
                if (dis>1) min = Math.min(min,dis);
            }
        }
        return min;
    }

    public static void initSet(int n) {
        for (int i=1;i<=n;i++) parent[i]=i;
    }

    public static int find (int a) {
        if (parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }

    public static boolean union (int a, int b) {
        a=find(a);
        b=find(b);
        if (a==b) return false;
        if(a>b) parent[a]=b;
        else parent[b]=a;
        return true;
    }


}

class Point1 {
    int x;
    int y;

    public Point1 (int x, int y) {
        this.x=x;
        this.y=y;
    }
}

class Bridge implements Comparable<Bridge> {
    int isld1;
    int isld2;
    int dist;

    public Bridge (int i1, int i2, int dis) {
        this.isld1 = i1;
        this.isld2 = i2;
        this.dist = dis;
    }

    @Override
    public int compareTo (Bridge o) {
        return this.dist-o.dist;
    }
}































