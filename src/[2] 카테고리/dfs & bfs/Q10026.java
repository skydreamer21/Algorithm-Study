// 10026번 적록색약(G5) [dfs bfs]
/*
<문제 정보>
 1. 정상인 사람과 적록색약인 사람이 봤을 때 구역의 수를 각각 출력

<변수 범위>
 1. 1초 / 128MB
 2. 1<=N<=100

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q10026 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt1=0;
    static int cnt2=0;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static final int R = 1;
    static final int G = 2;
    static final int B = 3;
    static final boolean Normal = true;



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String S;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for (int i=1;i<=N;i++) {
            S = br.readLine();
            for (int j=0;j<N;j++) {
                switch (S.charAt(j)) {
                    case 'R' :
                        map[i][j+1]=1;
                        break;
                    case 'G' :
                        map[i][j+1]=2;
                        break;
                    case 'B' :
                        map[i][j+1]=3;
                }
            }
        }
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if(!visited[i][j]) {
                    dfs(Normal,i,j);
                    cnt1++;
                }
            }
        }
        for (int i=1;i<=N;i++) Arrays.fill(visited[i],false);
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if(!visited[i][j]) {
                    dfs(!Normal,i,j);
                    cnt2++;
                }
            }
        }
        sb.append(cnt1).append(" ").append(cnt2);



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs (boolean normal, int x, int y) {
        Deque<P7> stack = new ArrayDeque<>();
        stack.add(new P7(x,y));
        visited[x][y]=true;
        int color = map[x][y];
        P7 now;
        int nextX, nextY;
        boolean inRange;

        while(!stack.isEmpty()) {
            now = stack.pollLast();

            for (int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=1 && nextY>=1 && nextX<=N && nextY<=N;
                if (normal || color==B) {
                    if(inRange && !visited[nextX][nextY] && map[nextX][nextY]==color) {
                        stack.add(new P7(nextX, nextY));
                        visited[nextX][nextY]=true;
                    }
                }
                else {
                    if(inRange && !visited[nextX][nextY] && (map[nextX][nextY]==R || map[nextX][nextY]==G)) {
                        stack.add(new P7(nextX, nextY));
                        visited[nextX][nextY]=true;
                    }
                }
            }
        }

    }

}

class P7 {
    int x, y;
    public P7 (int x, int y) {
        this.x=x;
        this.y=y;
    }
}

















