// 7576번 토마토
/*
<문제 정보>
 1. 인접한 토마토 익음
 2. 1 익음, 0 안익음, -1 없음
 3. 저장될때부터 모든 토마토 익어있으면 0 출력, 모든 토마토가 익지 못한다면 -1 출력

<변수 범위>
 1.

<프로그램 진행>
 1. 1초 / 256MB
 2. 상자 가로 세로 M,N 2이상 1000 이하

<필요 함수>
 1.

 */

// 토마토가 모두 익지 못하는 상황 -> 막혀있거나 익은 토마토가 없거나

import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q7576_2 {
    static int[][] map;
    static Deque<Pair> q = new ArrayDeque<>();
    static int M;
    static int N;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int zero=0;
    static int zero_cnt=0;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        boolean allZero = true;
        //visited = new boolean[N][M];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) zero++;
                if(map[i][j]==1) {
                    if(allZero) allZero=false;
                    map[i][j]=-2;
                    q.add(new Pair(i,j));
                }
            }
        }


        if(zero==0) bw.write(String.valueOf(0));
        else if (allZero) bw.write(String.valueOf(-1));
        else {
            int ans = bfs();
            if(zero==zero_cnt) {
                int max = 0;
                for (int i=0;i<N;i++) {
                    for (int j=0;j<M;j++) max = Math.max(max,map[i][j]);
                }
                bw.write(String.valueOf(max));
            }
            else {
                //System.out.printf("zero : %d\n",zero);
                //System.out.printf("zero_cnt : %d\n",zero_cnt);
                bw.write(String.valueOf(-1));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {
        Pair now;
        boolean inRange;
        int nextX, nextY;
        int temp;
        int db_cnt=0;
        int db_same=q.size();
        int db_next=0;
        int db_level=1;

        while(!q.isEmpty()) {
            db_cnt++;
            now = q.poll();
            //System.out.printf("x : %d, y : %d\n",now.x,now.y);
            for (int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                if (inRange && map[nextX][nextY]>=0) {
                    temp = (map[now.x][now.y]==-2) ? 1 : map[now.x][now.y]+1;
                    if (map[nextX][nextY]==0 || temp<map[nextX][nextY]) {
                        if(map[nextX][nextY]==0) zero_cnt++;
                        q.add(new Pair(nextX,nextY));
                        map[nextX][nextY] = temp;
                        db_next++;
                    }
                }
            }
            //printStack(q);
            //System.out.println("----------");
            if(db_cnt==db_same) {
                db_level++;
                db_cnt=0;
                db_same=db_next;
                db_next=0;
            }

            /*
            if(db_cnt==db_same) {
                System.out.println("**********************");
                System.out.printf("거리 %d 결과 : \n",db_level++);
                printMap();
                System.out.println("**********************");
                db_cnt=0;
                db_same=db_next;
                db_next=0;
            }
             */
        }
        return db_level-2;
    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }

    public static void printMap() {
        for (int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
    }
}
