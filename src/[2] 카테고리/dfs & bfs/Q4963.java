// 4963번 섬의 개수
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. 너비 w, 높이 h는 50보다 작거나 같은 양의 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;


public class Q4963 {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            if(M==0 && N==0) break;
            map = new int[N+1][M+1];
            visited = new boolean[N+1][M+1];
            for (int i=1;i<=N;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=1;j<=M;j++) map[i][j]=Integer.parseInt(st.nextToken());
            }

            /*for (int i=1;i<=N;i++) {
                for (int j=1;j<=M;j++) System.out.printf("%d ",map[i][j]);
                System.out.println();
            }*/

            int isld=0;
            for (int i=1;i<=N;i++) {
                for (int j=1;j<=M;j++) {
                    if (map[i][j]==1 && !visited[i][j]) {
                        dfs(i,j);
                        isld++;
                    }
                }
            }
            sb.append(isld).append("\n");
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs (int i, int j) {
        Deque<P3> stack = new ArrayDeque<>();
        stack.add(new P3(i,j));
        visited[i][j]=true;
        P3 now;
        int nextX, nextY;
        boolean inRange;

        while(!stack.isEmpty()) {
            now = stack.pollLast();
            for (int[] d : dir) {
                nextX=now.x+d[0];
                nextY=now.y+d[1];
                inRange = nextX>=1 && nextY>=1 && nextX<=N && nextY<=M;
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY]==1) {
                    visited[nextX][nextY]=true;
                    stack.add(new P3(nextX,nextY));
                }
            }
        }
    }


}

class P3 {
    int x,y;

    public P3 (int x, int y) {
        this.x=x;
        this.y=y;
    }
}















