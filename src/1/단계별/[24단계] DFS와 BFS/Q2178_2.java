// 2178번 미로 탐색
/*
<문제 정보>
 1. N X M 크기 미로 최단거리 탐색

<변수 범위>
 1. 1초 / 192MB
 2. N,M 2 이상 100 이하 자연수

<프로그램 진행>
 1. BFS
 2. 맵에다가 depth 표시

<필요 함수>
 1.

 */


import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2178_2 {
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] visited2;
    static int N;
    static int M;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        visited2 = new boolean[N][M];
        String S;
        for (int i=0;i<N;i++) {
            S=br.readLine();
            for (int j=0;j<M;j++) map[i][j]=S.charAt(j)-'0';
        }
        //for (int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
        bfs();
        bw.write(String.valueOf(map[N-1][M-1]));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs() {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0));
        visited[0][0]=true;
        Pair now;
        boolean inRange;
        int nextX;
        int nextY;
        int size=0;

        while(!q.isEmpty()) {
            now = q.poll();
            //System.out.printf("x : %d, y : %d\n",now.x,now.y);
            for(int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                /*
                System.out.printf("<nextX,nextY> = <%d,%d>\n",nextX,nextY);
                System.out.print("Range : ");
                System.out.println(inRange);
                if(inRange) {
                    System.out.print("map : ");
                    System.out.println(map[nextX][nextY]);
                    System.out.print("visited : ");
                    System.out.println(visited[nextX][nextY]);
                }
                 */
                if (inRange && map[nextX][nextY]!=0 && !visited[nextX][nextY]) {
                    q.add(new Pair(nextX,nextY));
                    //System.out.println("added");
                    map[nextX][nextY] = map[now.x][now.y]+1;
                    visited[nextX][nextY] = true; // 똑같은 좌표를 또 큐에 넣는 것을 방지
                }
            }
            //size = Math.max(size,q.size());
            //printStack(q);
            //System.out.println("---------------------");
            if (visited[N-1][M-1]) {
                //System.out.printf("Max q : %d\n",size);
                break;
            }
        }
    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }
}
