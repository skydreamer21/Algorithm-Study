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
 2. 상자 가로 세로 높이 M,N,H 2이상 100 이하

<필요 함수>
 1.

 */

import Necessary_Class.Pair3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q7569 {
    static int[][][] map;
    static Deque<Pair3> q = new ArrayDeque<>();
    static int M;
    static int N;
    static int H;
    static int[][] dir = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
    //static int zero=0;
    //static int zero_cnt=0;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][M][H];

        for (int h=0;h<H;h++) {
            for (int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<M;j++) {
                    map[i][j][h] = Integer.parseInt(st.nextToken());
                    //if (map[i][j][h]==0) zero++;
                    if (map[i][j][h]==1) q.add(new Pair3(i,j,h));
                }
            }
        }


        bw.write(String.valueOf(bfs()));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {
        Pair3 now;
        boolean inRange;
        int nextX, nextY, nextZ;
        int size;
        int day=0;

        while(!q.isEmpty()) {
            size = q.size();
            // 반복문이 끝나면 day가 올라가게끔, 그러면 매번 비교할 필요가 없어짐
            for (int i=0;i<size;i++) {
                now = q.poll();
                //System.out.printf("x : %d, y : %d\n",now.x,now.y);
                for (int[] d : dir) {
                    nextX = now.x+d[0];
                    nextY = now.y+d[1];
                    nextZ = now.z+d[2];
                    inRange = nextX>=0 && nextY>=0 && nextZ>=0 && nextX<N && nextY<M && nextZ<H;
                    if (inRange && map[nextX][nextY][nextZ]==0) {
                        map[nextX][nextY][nextZ]=1;
                        //zero_cnt++;
                        q.add(new Pair3(nextX,nextY,nextZ));
                    }
                }
            }
            day++;
        }

        boolean possible = true;
        for (int h=0;h<H;h++) {
            if(!possible) break;
            for (int i=0;i<N;i++) {
                if(!possible) break;
                for (int j=0;j<M;j++) {
                    if(map[i][j][h]==0) {
                        possible=false;
                        break;
                    }
                }
            }
        }

        if (!possible) day=-1;

        //if (zero!=zero_cnt) day=-1;
        else day--;
        return day;
    }
}
