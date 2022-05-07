// 16236번 아기 상어 (G3)
/*
<문제 정보>
 1. 몇 초 동안 엄마 상어에게 도움 요청하지 않고 물고기를 잡아먹을 수 있는지
    - 0 : 빈칸
    - 1 ~ 6 칸에 있는 물고기 크기
    - 9 : 아기상어 위치
    - 초기 아기상어 크기 : 2

    - 아기 상어 움직임 : 자신의 크기 이하 물고기칸은 다 지날 수 있음
        -> 가장 가까운 물고기를 우선으로 먹음
        -> 같은 거리에 여러마리 있다면 위쪽, 왼쪽 에 있는 물고기를 우선순위로 먹는다.

    - 아기 상어 먹이 : 자신의 크기보다 작은 물고기만 먹을 수 있다.

<변수 범위>
 1. 2초 / 512MB
 2. 공간의 크기 2<=N<=20


<프로그램 진행>
 1. bfs 구현하면 끝

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q16236 {
    static int N;
    static int[][] map;
    static Pair13 sharkPos;
    static int sharkSize = 2;
    static int time = 0;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static final int EMPTY = 0;
    static final int BABY_SHARK = 9;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==BABY_SHARK) sharkPos = new Pair13(i, j);
            }
        }




        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean findPrey() {
        Deque<Pair13> q = new ArrayDeque<>();
        q.add(sharkPos);
        int nextX, nextY;
        int inRange;
        boolean findPrey = false;
        int qSize;
        int time=0;

        while(!q.isEmpty()) {
            time++;
            qSize = q.size();

            for (int i=0;i<qSize;i++) {

            }
        }
    }
}

class Pair13 {
    int x, y;

    public Pair13 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}


















