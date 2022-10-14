// 빛의 경로
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
import java.util.ArrayList;
import java.util.Collections;

public class Q1 {
    static int N, M;
    static char[][] visited;
    static char[][] map;

    static final boolean ROW = true;
    static final boolean COLUMN = false;

    // 반시계방향 0:UP, 1: LEFT, 2:DOWN, 3:RIGHT
    static int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String[] grid = new String[N];
        for (int i=0;i<N;i++) grid[i] = br.readLine();

        M = grid[0].length();
        map = new char[N][M];
        for (int i=0;i<N;i++) map[i] = grid[i].toCharArray();
        /*for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) System.out.printf("%c ",map[i][j]);
            System.out.println();
        }*/
        System.out.printf("%d, %d\n",N,M);
        visited = new char[N][M];
        ArrayList<Integer> cycles = new ArrayList<>();
        int cycle=0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                for (int direction=0; direction<4; direction++) {
                    if((visited[i][j] & (1<<direction))==0) {
                        visited[i][j] |= 1<<direction;
//                        System.out.print("시작 -> ");
                        printStatus(i,j);
                        cycle = getCycle(i,j,direction);
                        if (cycle==-1) continue;
                        cycles.add(cycle);
                    }
                }
            }
        }
        Collections.sort(cycles);
        for (int c : cycles) sb.append(c).append(" ");
        sb.append("\n");

        int[] answer = {};
        answer = new int[cycles.size()];
        int idx = 0;
        for (int c : cycles) answer[idx++] = c;
        for (int c : answer) sb.append(c).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getCycle(int startX, int startY, int direction) {
        System.out.printf("%d, %d 에서 %d 방향으로 사이클 탐색 시작\n",startX, startY, direction);
        int nowX = startX + dir[direction][0];
        nowX = OOB_Check(ROW, nowX);
        int nowY = startY + dir[direction][1];
        nowY = OOB_Check(COLUMN, nowY);
        int cycle=1;

        int tmp_dir = direction;
        while(true) {
            switch(map[nowX][nowY]) {
                case 'S' :
                    break;
                case 'L' : // 왼쪽은 방향 인덱스+1
                    tmp_dir = tmp_dir==3 ? 0 : tmp_dir+1;
                    break;
                case 'R' : // 오른쪽은 방향 인덱스-1
                    tmp_dir = tmp_dir==0 ? 3 : tmp_dir-1;
            }

            if (nowX == startX && nowY == startY && tmp_dir==direction) {
                System.out.printf("cycle : %d 반환\n", cycle);
                return cycle;
            }
            System.out.printf("(%d,%d), dir : %d\n",nowX, nowY, tmp_dir);
            if ((visited[nowX][nowY] & (1<<tmp_dir))!=0) {
                printStatus(nowX, nowY);
                return -1;
            }
            visited[nowX][nowY] |= 1<<tmp_dir;
            cycle++;
            nowX += dir[tmp_dir][0];
            nowX = OOB_Check(ROW, nowX);
            nowY += dir[tmp_dir][1];
            nowY = OOB_Check(COLUMN, nowY);
        }
    }

    public static int OOB_Check(boolean isRow, int index) {
        if (isRow) {
            if (index==-1) return N-1;
            else if (index==N) return 0;
        }
        else {
            if (index==-1) return M-1;
            else if (index==M) return 0;
        }
        return index;
    }

    public static void printStatus(int n, int m) {
        System.out.printf("%d,%d의 방문상태 : ",n,m);
        for (int i=3;i>=0;i--) {
            if ((visited[n][m] & (1<<i))==0) System.out.print(0);
            else System.out.print(1);
        }
        System.out.println();
    }
}






















