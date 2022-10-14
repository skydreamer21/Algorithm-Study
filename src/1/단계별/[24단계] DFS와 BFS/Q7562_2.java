// 7562번 나이트의 이동
/*
<문제 정보>
 1. 나이트가 해당칸까지 이동하는데 드는 최소 이동 횟수

<변수 범위>
 1. 1초 / 256MB
 2. 체스판 한변 길이 4이상 300이하

<프로그램 진행>
 1. start와 end에서 각각 bfs 진행 -> 만나기

<필요 함수>
 1.

 */

// 시작과 끝에서 동시 탐색하는게 더 효율적일 줄 알았는데 그렇지는 않음

import Necessary_Class.Pair.FlagPair;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;


public class Q7562_2 {
    static int[][] map;
    static int N;
    static int[][] dir = {{1,2},{2,1},{-1,2},{-2,1},{-1,-2},{-2,-1},{1,-2},{2,-1}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        FlagPair start, end;
        while(T-- >0) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            st=new StringTokenizer(br.readLine());
            start = new FlagPair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),true);
            st=new StringTokenizer(br.readLine());
            end = new FlagPair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            if (start.x==end.x && end.x==end.y) sb.append(0).append("\n");
            else sb.append(bfs(start,end)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(FlagPair start, FlagPair end) {
        Deque<FlagPair> q = new ArrayDeque<>();
        q.add(start); q.add(end);
        FlagPair now;
        int nextX, nextY;
        boolean inRange;
        boolean startPair;
        boolean endPair;
        boolean findAns = false;
        int ans=0;
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
                endPair = nextX==end.x && nextY == end.y;
                if(inRange) {

                    // 정답 찾기
                    if (map[now.x][now.y]*map[nextX][nextY]<0 || (endPair && now.flag)) {
                        ans = Math.abs(map[now.x][now.y])+Math.abs(map[nextX][nextY])+1;
                        findAns = true;
                        break;
                    }

                    //탐색 진행
                    if (map[nextX][nextY]==0) {
                        if(now.flag && !startPair) {
                            q.add(new FlagPair(nextX,nextY,true));
                            map[nextX][nextY]=map[now.x][now.y]+1;
                        }
                        else if (!endPair) {
                            q.add(new FlagPair(nextX,nextY));
                            map[nextX][nextY]=map[now.x][now.y]-1;
                        }
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
        return ans;
    }

    public static void printStack (Deque<FlagPair> stack) {
        for (FlagPair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }

    public static void printMap() {
        for (int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
    }
}
