// 7562번 나이트의 이동
/*
<문제 정보>
 1. 나이트가 해당칸까지 이동하는데 드는 최소 이동 횟수

<변수 범위>
 1. 1초 / 256MB
 2. 체스판 한변 길이 4이상 300이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Pair.FlagPair;
import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;


public class Q7562 {
    static int[][] map;
    static int N;
    static int[][] dir = {{1,2},{2,1},{-1,2},{-2,1},{-1,-2},{-2,-1},{1,-2},{2,-1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Pair start, end;
        while(T-- >0) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            st=new StringTokenizer(br.readLine());
            start = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            st=new StringTokenizer(br.readLine());
            end = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            bfs(start,end);
            sb.append(map[end.x][end.y]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Pair start, Pair end) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(start);
        Pair now;
        int nextX, nextY;
        boolean inRange;
        boolean startPair;
        boolean findAns = false;
        int db_max=0;

        while (!q.isEmpty()) {
            if(findAns) break;
            now = q.poll();
            //System.out.printf("Current Location : (%d, %d)\n",now.x,now.y);

            for (int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<N;
                startPair = nextX==start.x && nextY == start.y;
                if(inRange && map[nextX][nextY]==0 && !startPair) {
                    q.add(new Pair(nextX,nextY));
                    map[nextX][nextY]=map[now.x][now.y]+1;
                    if (nextX == end.x && nextY==end.y) {
                        findAns = true;
                        break;
                    }
                }
            }
            db_max = Math.max(db_max,q.size());
            /*
            System.out.println("------ queue status --------");
            printStack(q);
            System.out.println("----------------------------");
            printMap();
            System.out.println("*******************************************");
             */
        }
        //System.out.printf("q max : %d\n",db_max);
        if (!findAns) map[end.x][end.y]=0;
    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }

    public static void printMap() {
        for (int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
    }
}
