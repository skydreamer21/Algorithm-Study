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


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import Necessary_Class.Pair.Pair;
import java.util.Arrays;

public class Q7576 {
    static int[][] map;
    //static boolean[][] visited;
    static int M;
    static int N;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        //visited = new boolean[N][M];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) map[i][j]=-2;
            }
        }
        //printMap();

        boolean all=true;
        for (int i=0;i<N;i++) {
            if (!all) break;
            for (int j=0;j<M;j++) {
                if(map[i][j]==0) {
                    all = false;
                    break;
                }
            }
        }

        boolean hasZero = false;
        int max=0;
        if(all) bw.write(String.valueOf(0));
        else {

            for (int i=0;i<N;i++) {
                for (int j=0;j<M;j++) {
                    if (map[i][j] == -2) {
                        //System.out.printf("<%d,%d>일 때\n",i,j);
                        bfs(i, j);
                        //System.out.println("이번 bfs 결과");
                        //printMap();
                    }
                }
            }

            for (int i=0;i<N;i++) {
                if(hasZero) break;
                for (int j=0;j<M;j++) {
                    if(map[i][j]==0) {
                        hasZero=true;
                        break;
                    }
                    max = Math.max(max,map[i][j]);
                }
            }

            if(hasZero) bw.write(String.valueOf(-1));
            else bw.write(String.valueOf(max));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int x, int y) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x,y));
        Pair now;
        int nextX,nextY;
        boolean inRange;
        boolean adjOne;
        int temp;
        //int debug=0;
        while (!q.isEmpty()) {
            /*
            if (debug++>20) {
                System.out.println("무한루프 오류 가능성 - 확인바람");
                break;
            }
             */
            now = q.poll();
            //System.out.printf("x : %d, y : %d\n",now.x,now.y);
            adjOne = false;
            for (int[] d : dir) {
                nextX=now.x+d[0];
                nextY=now.y+d[1];
                if (map[nextX][nextY]==-2) {
                    adjOne=true;
                    break;
                }
            }
            if(adjOne) continue;

            for (int[] d : dir) {
                nextX=now.x+d[0];
                nextY=now.y+d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                if (inRange && map[nextX][nextY]>=0) {
                    temp = (map[now.x][now.y]==-2) ? 1 : map[now.x][now.y]+1;
                    if (map[nextX][nextY]==0 || temp<map[nextX][nextY]) {
                        q.add(new Pair(nextX,nextY));
                        map[nextX][nextY]=temp;
                    }
                }
            }
            //printStack(q);
            //System.out.println("----------");
        }
    }
/*
    public static void clear_visited() {
        for (int i=0;i<N;i++) Arrays.fill(visited[i],false);
    }

 */

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }

    public static void printMap() {
        for (int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
    }
}
