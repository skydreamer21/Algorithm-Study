// 18809번 Gaaaaaaaarden (G1) [구현][bfs/dfs]
/*
<문제 정보>
 1. 정원과 두 배양액의 개수가 주어졌을 때 피울 수 있는 꽃의 최대 개수
    - 초록색, 빨간색이 동시에 만나야 꽃이 핌
    - 꽃이 핀자리는 더이상 배양액이 퍼져나가지 않음
    - 0 : 호수, 1 : 그냥 땅, 2 : 배양액 가능 땅

<변수 범위>
 1. 2초 / 512MB
 2. 정원의 행과 열 2<=N,M<=50
 3. 각 배양액의 개수는 1이상 5이하  (G,R)
 4. 배양액을 뿌릴 수 있는 땅의 수는 R+G 이상 10이하

<프로그램 진행>
 1. 배양액이 가능한 좌표 리스트 + 어떤 배양액이 담겼는지 (혹은 배양액이 없는지) 판별하는 배열(sourceStatus)
 2. 초록 -> 빨강 순서대로 배치 (sourceStatus) -> 백트래킹
 3. 배치된 정보를 토대로 bfs 실행
    - CopyMap
    - 처음에 큐에 배양액 넣고 해당위치의 map 정보를 알맞게 바꿈
    - 배양액이 퍼져나가면 map의 정보를 바꿈 (GREEN, RED)
    - time[][] 배열에 배양액이 퍼진 시간을 저장
    - 두 배양액이 겹칠때, 시간이 같다면 꽃++, 해당 자리의 정보를 FLOWER로 바꿈
    - 큐에서 poll 된 자리가 FLOWER 라면 continue

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q18809 {
    static int N, M, G, R;
    static int[][] originalMap;
    static int[][] map;
    static int[][] time;
    static int sourceNum;
    static Pair12[] sourceList;
    static int[] sourceStatus;
    static int maxFlower = -1;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static final int LAKE = 0;
    static final int LAND = 1;
    static final int SOURCE = 2;
    static final int GREEN = 3;
    static final int RED = 4;
    static final int FLOWER = 5;

    static final int EMPTY = 0;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        originalMap = new int[N][M];
        map = new int[N][M];
        time = new int[N][M];
        sourceList = new Pair12[10];
        sourceStatus = new int[10]; // 처음에는 모두 EMPTY 인 상황
        sourceNum=0;
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
                if (originalMap[i][j]==SOURCE) sourceList[sourceNum++] = new Pair12(i,j);
            }
        }

//        for (int i=0;i<G+R;i++) System.out.printf("%d, %d\n",sourceList[i].x, sourceList[i].y);
        dfs(0,0);
        sb.append(maxFlower);



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs (int depth, int order) {
        if (depth==G+R) {
            /*CopyMap();
            if (answerCase()) {
                for (int i=0;i<sourceNum;i++) System.out.printf("%d ",sourceStatus[i]);
                System.out.println();
                System.out.printf("maxFlower : %d\n",GetFlower());
            }*/

            CopyMap();
            maxFlower = Math.max(maxFlower, GetFlower()); // bfs로 꽃의 개수 구하기
            return;
        }

        // depth는 이제까지 쓴 배양액 개수, 즉 depth가 초록색 배양액 개수보다 같거나 크다면 빨간색 배양액을 뿌릴 차례
        for (int i=order;i<sourceNum;i++) {
            if (sourceStatus[i]!=EMPTY) continue;
            sourceStatus[i] = depth>=G ? RED : GREEN;
            dfs(depth+1, depth==G-1 ? 0 : i+1);
            sourceStatus[i] = EMPTY;
        }
    }
    /*public static boolean answerCase() {
        int[] ans = {3,4,3,0,4,0,3,0};
        for (int i=0;i<sourceNum;i++) {
            if (ans[i]!=sourceStatus[i]) return false;
        }
        return true;
    }*/

    public static int GetFlower() {
        for (int i=0;i<N;i++) Arrays.fill(time[i], INF); // time 초기화
        Deque<Pair12> q = new ArrayDeque<>();
        for (int i=0;i<sourceNum;i++) {
            if (sourceStatus[i]!=EMPTY) {
                q.add(new Pair12(sourceList[i]));
                map[sourceList[i].x][sourceList[i].y] = sourceStatus[i];
                time[sourceList[i].x][sourceList[i].y] = 0;
            }
        }

        Pair12 now;
        int nowStatus;
        int nextX, nextY;
        boolean inRange;
        int t=0; // time
        int qSize;
        int flowers=0;

        while (!q.isEmpty()) {
            /*if(answerCase()) {
                System.out.printf("t=%d 일때\n",t);
                PrintMap();
            }*/
            t++;
            qSize = q.size();

            for (int i=0;i<qSize;i++) {
                now = q.poll();
                nowStatus = map[now.x][now.y];
                if (nowStatus==FLOWER) continue;
                // 여기서부터 nowStatus는 GREEN이나 RED 둘중 하나만 가짐

                for (int[] d : dir) {
                    nextX = now.x + d[0];
                    nextY = now.y + d[1];
                    inRange = nextX>=0 && nextY>=0 && nextX<N && nextY<M;
                    if (inRange) {
                        // 배양액이 들어갈 수 있는 빈 땅이면
                        if (map[nextX][nextY]==LAND || map[nextX][nextY]==SOURCE) {
                            q.add(new Pair12(nextX, nextY));
                            map[nextX][nextY] = nowStatus;
                            time[nextX][nextY] = t;
                        }
                        // 이미 배양액이 들어가 있다면
                        else if (map[nextX][nextY]==GREEN || map[nextX][nextY]==RED) {
                            if (map[nextX][nextY]!=nowStatus && time[nextX][nextY] == t) {
                                flowers++;
                                map[nextX][nextY] = FLOWER;
                            }
                        }
                    }
                }
            }
        }
        return flowers;
    }

    public static void CopyMap() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) map[i][j] = originalMap[i][j];
        }
    }

    public static void PrintMap() {
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) System.out.printf("%d ",map[i][j]);
            System.out.println();
        }
    }
}

class Pair12 {
    int x, y;

    public Pair12(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair12 (Pair12 coor) {
        this.x = coor.x;
        this.y = coor.y;
    }
}





















