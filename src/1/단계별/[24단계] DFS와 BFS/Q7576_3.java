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
// 여러가지 해봤을 때 아래 코드가 가장 빨랐음
// 여러가지라는 건 bw.write 한줄로 바꿔보거나 zero==zero_cnt 를 0탐색으로 바꿔보거나

// 사실 map 에다가 1씩 더해줄 필요없음 day가 있기 때문
// 익은 토마토를 1로 바꿔주면 됨.

import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q7576_3 {
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
        else bw.write(String.valueOf(bfs()));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs() {
        Pair now;
        boolean inRange;
        int nextX, nextY;
        int temp;
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
                    inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                    if (inRange && map[nextX][nextY]>=0) {
                        temp = (map[now.x][now.y]==-2) ? 1 : map[now.x][now.y]+1;
                        if (map[nextX][nextY]==0 || temp<map[nextX][nextY]) {
                            if(map[nextX][nextY]==0) zero_cnt++;
                            q.add(new Pair(nextX,nextY));
                            map[nextX][nextY] = temp;
                        }
                    }
                }
            }
            day++;


            //printStack(q);
            //System.out.println("----------");
        }
        /*
        boolean possible = true;
        for (int i=0;i<N;i++) {
            if(!possible) break;
            for (int j=0;j<M;j++) {
                if(map[i][j]==0) {
                    possible=false;
                    break;
                }
            }
        }
        if (!possible) day=-1;
         */
        if (zero!=zero_cnt) day=-1;
        else day--;
        return day;
    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }

    public static void printMap() {
        for (int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
    }
}
