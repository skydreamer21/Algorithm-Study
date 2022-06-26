// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


package Programmers;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class 개미 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int arrivalX, arrivalY;

    static final int X = 0;
    static final int Y = 1;
    static final int VISITED = 9;
    static int[][] dir = {{1,0}, {0,1}};
//    static int[] dx = {1,0};
//    static int[] dy = {0,1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();




        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y) {
        Deque<Pair> q = new ArrayDeque<>();
        // 시작지점 push
        q.add(new Pair(x, y));

        Pair now;
        int nextX, nextY;
        // OOB : Out Of Bound
        boolean inRange;
        boolean findAns = false;

        while(!q.isEmpty()) {
            if (findAns) break;
            now = q.poll();
            map[now.x][now.y]=9;
            // dir[0] = {1,0}
            // dir[1] = {0,1}

            // now -> next
            for (int[] d : dir) {
                nextX = now.x + d[X];
                nextY = now.y + d[Y];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<N;
                if (inRange && map[nextX][nextY]!=VISITED) {
                    if (nextX == arrivalX && nextY == arrivalY) {
                        findAns = true;
                        break;
                    }
                    q.add(new Pair(nextX, nextY));
                }
            }
        }
    }
}

class Pair {
    int x, y;

    public Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
