// 2667번 단지번호붙이기
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 512MB
 2. 가로,세로 50이하 자연수 (M,N)
 3. 배추가 심어져 있는 위치 개수 K 2500이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q1012 {
    static int[][] map;
    static boolean[][] visited;
    static int M;
    static int N;
    static int count;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int x; int y;
        while (T-- >0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            count=0;
            while (K-- >0) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y]=1;
            }
            for (int i=0;i<M;i++) System.out.println(Arrays.toString(map[i]));
            for (int i=0;i<M;i++) {
                for (int j=0;j<N;j++) {
                    if(!visited[i][j] && map[i][j]==1) {
                        System.out.printf("%d,%d\n",i,j);
                        count++;
                        dfs(i,j);
                        System.out.println("---------------------");
                    }
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs (int x, int y) {
        Deque<Pair> stack = new ArrayDeque<>();
        Pair start = new Pair(x,y);
        Pair cur;
        stack.add(start);
        boolean inRange;
        while (!stack.isEmpty()) {
            cur = stack.pollLast();
            inRange = cur.x>=0 && cur.y>=0 && cur.x<M && cur.y<N;
            if (inRange && !visited[cur.x][cur.y]) {
                System.out.printf("(%d,%d)\n",cur.x,cur.y);
                visited[cur.x][cur.y]=true;
                if(map[cur.x][cur.y]==1) {
                    for (int[] d : dir) stack.add(new Pair(cur.x+d[0],cur.y+d[1]));
                }
            }
            printStack(stack);
        }
    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }
}
