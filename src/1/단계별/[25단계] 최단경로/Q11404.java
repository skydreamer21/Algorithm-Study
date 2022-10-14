// 11404번 플로이드
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB
 2. 도시의 개수 2<=n<=100
 3. 버스 개수 m 1<=m<=100,000
 4. 비용은 100,000 보다 작거나 같은 자연수
 (최대 비용 100,000 X 100,000)

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 기본 최단거리에서는 방문한 점은 다시 방문하지 않음
// 비용 최댓값은 100 x 100,000

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q11404 {
    static int[][] graph;
    static int N;
    final static int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        for (int i=1;i<=N;i++) Arrays.fill(graph[i],INF);
        for (int i=1;i<=N;i++) graph[i][i]=0;

        //printGraph();

        int from,to,cost;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            graph[from][to] = Math.min(graph[from][to],cost);
        }

        //printGraph();

        Floyd_Warshall();
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) sb.append( (graph[i][j]==INF) ? 0 : graph[i][j] ).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Floyd_Warshall() {
        // i번째 점을 거쳐 간다고 했을 때 최소비용을 갱신
        for (int via=1;via<=N;via++) {
            for (int i=1;i<=N;i++) {
                for (int j=1;j<=N;j++) {
                    if (i!=via && j!=via && i!=j) {
                        if (graph[i][via]==INF || graph[via][j]==INF) continue;
                        graph[i][j] = Math.min(graph[i][j],graph[i][via]+graph[via][j]);
                    }
                }
            }
            //printGraph(via);
        }
    }
/*
    public static void printGraph() {
        System.out.println("-------------------------------------");
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                System.out.print( (graph[i][j]==INF) ? "F" : graph[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }

    public static void printGraph(int via) {
        System.out.printf("-------------- via = %d ---------------\n",via);
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                System.out.print( (graph[i][j]==INF) ? "F" : graph[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }
 */
}






















