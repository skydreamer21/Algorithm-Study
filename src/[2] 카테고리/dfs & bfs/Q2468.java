// 2468번 안전 영역 (S1) [dfs & bfs]
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. 2<=N<=100
 3. 높이 1이상 100이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// stack을 안써서 그런지 재귀가 더 빠름

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;


public class Q2468 {
    static int N;
    static int[][] map;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int max=1;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        int maxHeight = -1;
        int minHeight = 101;
        for (int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }
        for (int height=minHeight;height<maxHeight;height++) {
            Search(height);
            for (int i=1;i<=N;i++) Arrays.fill(visited[i],false);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
    //height 이하가 잠긴다면 안전영역은 몇개? -> 최댓값 갱신
    public static void Search (int height) {
        int cnt=0;
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if(map[i][j]>height && !visited[i][j]) {
                    dfs(i, j,height);
                    cnt++;
                }
            }
        }
        max=Math.max(max,cnt);
    }

    /*public static void dfs(int x, int y, int height) {
        Deque<P6> stack = new ArrayDeque<>();
        stack.add(new P6(x,y));
        visited[x][y]=true;
        P6 now;
        int nextX, nextY;
        boolean inRange;

        while(!stack.isEmpty()) {
            now=stack.pollLast();
            for (int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=1 && nextY>=1 && nextX<=N && nextY<=N;
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY]>height) {
                    visited[nextX][nextY]=true;
                    stack.add(new P6(nextX,nextY));
                }
            }
        }
    }*/

    public static void dfs(int x, int y, int height) {
        visited[x][y]=true;
        int nextX, nextY;
        boolean inRange;
        for (int[] d : dir) {
            nextX = x + d[0];
            nextY = y + d[1];
            inRange = nextX >= 1 && nextY >= 1 && nextX <= N && nextY <= N;
            if (inRange && !visited[nextX][nextY] && map[nextX][nextY] > height) dfs(nextX, nextY, height);
        }
    }
}

class P6 {
    int x, y;
    public P6 (int x, int y) {
        this.x=x;
        this.y=y;
    }
}
















