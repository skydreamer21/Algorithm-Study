package Programmers;

import java.util.ArrayList;
import java.util.Collections;

class 빛경로 {
    static int N, M;
    static char[][] visited;
    static char[][] map;

    static final boolean ROW = true;
    static final boolean COLUMN = false;

    // 반시계방향 0:UP, 1: LEFT, 2:DOWN, 3:RIGHT
    static int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    public int[] solution(String[] grid) {
        N = grid.length;
        M = grid[0].length();
        map = new char[N][M];
        visited = new char[N][M];
        ArrayList<Integer> cycles = new ArrayList<>();
        for (int i=0;i<N;i++) map[i] = grid[i].toCharArray();
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                for (int direction=0; direction<4; direction++) {
                    // 방향 인덱스 순서에 해당하는 비트가 켜져 꺼져있다면 cycle 탐색
                    if((visited[i][j] & (1<<direction))==0) {
                        visited[i][j] |= 1<<direction;
                        cycles.add(getCycle(i,j,direction));
                    }
                }
            }
        }
        Collections.sort(cycles);
        int[] answer = new int[cycles.size()];
        int idx=0;
        for (int cycle : cycles) answer[idx++] = cycle;
        return answer;
    }

    public static int getCycle(int startX, int startY, int direction) {
        int nowX = startX + dir[direction][0];
        nowX = OOB_Check(ROW, nowX);
        int nowY = startY + dir[direction][1];
        nowY = OOB_Check(COLUMN, nowY);
        int cycle=1;
        /*
        char[][] visited = new char[N][M];
        여기서 쓰지도 않는 배열을 만들었는데 이게 탐색할때마다 만드니까 여기서 시간초과
         */

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
            if (nowX == startX && nowY == startY && tmp_dir==direction) return cycle;
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
}
