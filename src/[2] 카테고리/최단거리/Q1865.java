// 1865번 웜홀 (G3) [최단거리]
/*
<문제 정보>
 1. 도로는 시간+, 웜홀은 시간-
 2. 시간이 줄어들면서 출발위치로 돌아오는 것이 가능하다면 YES 아니면 NO 출력

<변수 범위>
 1. 2초 / 128MB
 2. 테케 1<=TC<=5
 3. 지점 수 1<=N<=500
 4. 도로의 수 1<=M<=2,500
 5. 웜홀의 수 1<=W<=200
 6. 시간 10,000 봐 작거나 같은 자연수 또는 0

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 벨만포드 한번 돌려서 풀수도 있음
// 시작지점에서 갈 수 없는 곳을 안가는 것이 아니라 거기도 감
// 모든 점을 가서 N번째 돌렸을 때 갱신이 일어나면 음수사이클이 있는 것으로 판단할 수 있음
// 단 벨만포드로 진행시 해당 사이클이 지정한 시작지점에서 갈 수 있는지 없는지는 모름

import java.io.*;
import java.util.StringTokenizer;

public class Q1865 {
    static int N, M, W;
    static int[][] graph;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int v1, v2, cost;
        while(T-- >0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            graph = new int[N+1][N+1];
            graphInitSet();
            for (int i=0;i<M+W;i++) {
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                cost = Integer.parseInt(st.nextToken());
                if (i<M) {
                    graph[v1][v2] = Math.min(graph[v1][v2],cost);
                    graph[v2][v1] = graph[v1][v2];
                }
                else graph[v1][v2] = Math.min(graph[v1][v2],-cost);
            }
            sb.append(FloydWarshall() ? "YES" : "NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean FloydWarshall() {
        for (int via=1;via<=N;via++) {
            for (int i=1;i<=N;i++) {
                for (int j=1;j<=N;j++) {
                    if (i!=via && j!=via && graph[i][via]!=INF && graph[via][j]!=INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][via]+graph[via][j]);
                    }
                    if (i==j && graph[i][j]<0) return true;
                }
            }
        }
        return false;
    }

    public static void graphInitSet() {
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) graph[i][j] = INF;
        }
        for (int i=1;i<=N;i++) graph[i][i]=0;
    }
}














