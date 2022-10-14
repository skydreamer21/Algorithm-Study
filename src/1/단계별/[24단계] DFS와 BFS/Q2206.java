// 2206번 벽 부수고 이동하기
/*
<문제 정보>
 1. NxM 행렬 (1,1) -> (N,M)  이동
 2. 벽 한개까지 부술 수 있을 때 최단경로 출력
 3. 시작, 끝지점은 0
 4. 0 : 이동가능 / 1 : 벽
 5. 불가능하면 -1 출력

<변수 범위>
 1. 2초 / 192MB
 2. N,M 1000 이하 자연수


<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 37276007	dsku - 68644KB / 552ms

import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import Necessary_Class.Pair.FlagPair;

import java.util.Arrays;

public class Q2206 {
    static int[][] map;
    static int[][] map1;
    static int[][] map2;
    static int N;
    static int M;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        map1 = new int[N][M]; map1[0][0]=1;
        map2 = new int[N][M]; map2[0][0]=1;
        String S;
        for (int i=0;i<N;i++) {
            S=br.readLine();
            for (int j=0;j<M;j++) map[i][j] = S.charAt(j)-'0';
        }
        bfs();
        if (map1[N-1][M-1]==0 && map2[N-1][M-1]==0) bw.write(String.valueOf(-1));
        else if (map1[N-1][M-1]==0) bw.write(String.valueOf(map2[N-1][M-1]));
        else if (map2[N-1][M-1]==0) bw.write(String.valueOf(map1[N-1][M-1]));
        else bw.write(String.valueOf(Math.min(map1[N-1][M-1],map2[N-1][M-1])));

        bw.flush();
        bw.close();
        br.close();
    }


    public static void bfs() {
        Deque<FlagPair> q = new ArrayDeque<>();
        q.add(new FlagPair(0,0));
        FlagPair now;
        int nextX, nextY;
        boolean inRange;
        boolean findAns = false;

        // now 의 상태가 스킬을 썼냐 안썼냐에 따라 맵이 달라짐
        // 스킬 안썼을 때 방문했던 곳을 스킬 썼을 때 다시 방문하면 종료
        // 반대의 경우에는 계속 탐색
        while (!q.isEmpty()) {
            if(findAns) break;
            now = q.poll();
            //System.out.printf("Current Location : (%d, %d)\n",now.x,now.y);
            //System.out.printf("Skill : %b\n",now.flag);

            for (int[] d : dir) {
                nextX = now.x+d[0];
                nextY = now.y+d[1];
                inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                if (inRange) {
                    // 스킬을 안썼을 때
                    if(!now.flag && map1[nextX][nextY]==0) {
                        // 벽 없을 때
                        if (map[nextX][nextY]==0) {
                            q.add(new FlagPair(nextX,nextY));
                            map1[nextX][nextY] = map1[now.x][now.y]+1;
                        }

                        // 벽 있을 때 (스킬 쓰기)
                        if (map[nextX][nextY]==1) {
                            q.add(new FlagPair(nextX,nextY,true));
                            map2[nextX][nextY] = map1[now.x][now.y]+1;
                        }
                    }

                    // 스킬을 썼을 때 -> 벽 있는 곳, map1에서 이미 방문한 곳 못감
                    else if(now.flag && map[nextX][nextY]==0 && map1[nextX][nextY]==0 && map2[nextX][nextY]==0) {
                        q.add(new FlagPair(nextX,nextY,true));
                        map2[nextX][nextY] = map2[now.x][now.y]+1;
                    }
                    if (nextX==N-1 && nextY==M-1) {
                        findAns = true;
                        break;
                    }
                }
            }
            /*
            System.out.println("------ queue status --------");
            printStack(q);
            System.out.println("----------------------------");
            if(!now.flag) {
                System.out.println("<map1>");
                printMap(map1);
                System.out.println();
            }
            System.out.println("<map2>");
            printMap(map2);
            System.out.println("*******************************************");
             */
        }
    }

    public static void printStack (Deque<FlagPair> stack) {
        for (FlagPair coor : stack) System.out.printf("(%d, %d) ",coor.x,coor.y);
        System.out.println();
    }

    public static void printMap (int[][] Map) {
        for (int i=0;i<N;i++) System.out.println(Arrays.toString(Map[i]));
    }
}
