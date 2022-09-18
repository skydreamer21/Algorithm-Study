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


package Necessary_Class;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.Collections;

public class Q2667_3 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static final int HOUSE = '1';
    static int[][] DIR = {{1,0}, {0,1}, {-1,0}, {0,-1}}; // 반시계방향

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0;i<N;i++) {
            char[] info = br.readLine().toCharArray();
            for (int j=0;j<N;j++) {
                map[i][j] = info[j];
            }
        }

        // ******************** 메인 로직 ********************
        int numOfComplex = 0;
        ArrayList<Integer> setOfComplex = new ArrayList<>();
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if (!visited[i][j] && map[i][j] == HOUSE) {
                    System.out.printf("[%d 번째 start] i:%d, j:%d\n",numOfComplex, i,j);
                    numOfComplex++;
                    setOfComplex.add(bfs(i, j));
                }
            }
        }
        Collections.sort(setOfComplex);

        // ******************** 정답 출력 ********************
        sb.append(numOfComplex).append("\n");
        for (int complex : setOfComplex) {
            sb.append(complex).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int startX, int startY) {
        Deque<Pos2> q = new ArrayDeque<>();
        q.add(new Pos2(startX, startY));
        visited[startX][startY] = true;
        int numOfHouse = 1;

        Pos2 now;
        int nextX, nextY;
        boolean inRange;
        int qSize;
        int dist=0;

        while(!q.isEmpty()) {
            for (Pos2 num : q) {
                System.out.printf("(%d,%d) ",num.x, num.y);
            }
            System.out.println();
            dist++; // dist == 3
            qSize = q.size(); // 현재 depth에서 방문할 지점(노드)의 수

            for (int i=0;i<qSize;i++) {
                now = q.poll();

                for (int[] d : DIR) { // 위, 아래, 왼쪽, 오른쪽
                    nextX = now.x + d[0];
                    nextY = now.y + d[1];
                    inRange = nextX >= 0 && nextY >= 0 && nextX < N && nextY < N;
                    if (inRange && !visited[nextX][nextY] && map[nextX][nextY] == HOUSE) {
                        numOfHouse++;
                        visited[nextX][nextY] = true;
                        q.add(new Pos2(nextX, nextY));
                    }
                }
            }
        }

        /*
        while(!q.isEmpty()) {
            now = q.poll();

            for (int[] d : DIR) {
                nextX = now.x + d[0];
                nextY = now.y + d[1];
                inRange = nextX >= 0 && nextY >= 0 && nextX < N && nextY < N;
                if (inRange && !visited[nextX][nextY] && map[nextX][nextY] == HOUSE) {
                    numOfHouse++;
                    visited[nextX][nextY] = true;
                    q.add(new Pos2(nextX, nextY));
                }
            }
        }
        /*
         */
        return numOfHouse;
    }
}

class Pos2 {
    int x, y;

    public Pos2(int x, int y) {
        this.x=x;
        this.y=y;
    }
}