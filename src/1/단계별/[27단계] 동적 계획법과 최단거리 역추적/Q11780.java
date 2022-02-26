// 11780번 플로이드2
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB
 2. 도시 n 1<=n<=100
 3. 버스노선 1<=m<=100,000
 4. 비용 100,000 이하의 자연수

<프로그램 진행>
 1. 플로이드 워셜

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Q11780 {
    static int N;
    static int[][] map;
    static int[][] path;
    final static int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        path = new int[N+1][N+1];
        for (int i=0;i<=N;i++) Arrays.fill(map[i],INF);
        for (int i=0;i<=N;i++) map[i][i]=0;
        int from,to,cost;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            map[from][to]=Math.min(map[from][to],cost);
            path[from][to]=to;
        }
        Floyd_Warshall();
/*
        print(map);
        System.out.println();
        print(path);
 */

        // 출력
        // 1. map
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) sb.append((map[i][j]==INF) ? 0 : map[i][j]).append(" ");
            sb.append("\n");
        }
        // 2. i -> j 거치는 도시 개수와 최단 경로
        ArrayList<Integer> navi = new ArrayList<>();
        int now;
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                if (i==j || map[i][j]==INF) sb.append(0).append("\n");
                else {
                    navi.clear();
                    now = i;
                    while (now!=j) {
                        navi.add(now);
                        now = path[now][j];
                    }
                    navi.add(j);
                    sb.append(navi.size()).append(" ");
                    for (int city : navi) sb.append(city).append(" ");
                    sb.append("\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Floyd_Warshall() {
        int temp;
        for (int via=1;via<=N;via++) {
            for (int i=1;i<=N;i++) {
                for (int j=1;j<=N;j++) {
                    if(i!=via && j!=via && i!=j && map[i][via]!=INF && map[via][j]!=INF) {
                        temp = map[i][via]+map[via][j];
                        if(temp<map[i][j]) {
                            map[i][j]=temp;
                            path[i][j]=path[i][via];
                        }
                    }
                }
            }
        }
    }

    public static void print(int[][] arr) {
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) System.out.printf("%d ",arr[i][j]);
            System.out.println();
        }
    }
}


















