// 2178번 미로 탐색
/*
<문제 정보>
 1. N X M 크기 미로 최단거리 탐색

<변수 범위>
 1. 1초 / 192MB
 2. N,M 2 이상 100 이하 자연수

<프로그램 진행>
 1. BFS

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import Necessary_Class.Pair.Pair;

public class Q2178 {
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
        bw.write(String.valueOf(bfs()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0));
        Pair cur;
        boolean inRange;
        int x,y;
        int depth=0;
        int same_depth=1;
        int next_depth=0; //1->2
        int depth_cnt=0;
        boolean flag = true;
        //int size=0;
        while(true) {
            cur = q.poll();
            //System.out.printf("x : %d, y : %d\n",cur.x,cur.y);

            depth_cnt++;
            if(flag) {
                depth++;
                flag=false;
            }




            visited[cur.x][cur.y]=true;
            if(cur.x==N-1 && cur.y==M-1) {
                //System.out.printf("Maximum Queue size : %d\n",size);
                break;
            }
            for (int[] d : dir) {
                x=cur.x+d[0];
                y=cur.y+d[1];
                inRange = x>=0 && y>=0 && x<N && y<M;
                if(inRange && map[x][y]!=0 && !visited[x][y] && !visited2[x][y]) {
                    q.add(new Pair(x,y));
                    visited2[x][y]=true;
                    next_depth++;
                }
            }
            //size = Math.max(size,q.size());
            //printStack(q);
            //System.out.println("---------------------------------");

            if (depth_cnt==same_depth) {
                same_depth=next_depth;
                next_depth=0;
                depth_cnt=0;
                flag = true;
            }
        }
        return depth;
    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }
}
