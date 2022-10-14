// 1956번 운동
/*
<문제 정보>
 1. 사이클 최단 경로
 2. 없으면 -1

<변수 범위>
 1. 2초 / 192MB
 2. 마을 개수 2<=V<=400
 3. 도로 개수 0<=E<=V(V-1)
 4. 거리는 10,000 이하의 자연수
 5. 두 마을 사이 도로는 최대 한개

<프로그램 진행>
 1. 플로이드 워셜

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1956 {
    static int[][] graph;
    static int V;
    final static int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new int[V+1][V+1];
        for (int i=1;i<=V;i++) Arrays.fill(graph[i],INF);
        for (int i=1;i<=V;i++) graph[i][i]=0;

        int from,to,dis;
        while (E-- >0) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            dis = Integer.parseInt(st.nextToken());
            graph[from][to]=dis;
        }
        floyd_Warshall();
        int ans=INF;
        for (int i=1;i<V;i++) {
            for (int j=i+1;j<=V;j++) {
                if(graph[i][j]!=INF && graph[j][i]!=INF) {
                    ans = Math.min(ans,graph[i][j]+graph[j][i]);
                }
            }
        }
        bw.write(String.valueOf((ans==INF) ? -1 : ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void floyd_Warshall() {
        for (int via=1;via<=V;via++) {
            for (int i=1;i<=V;i++) {
                for (int j=1;j<=V;j++) {
                    if(i!=via && j!=via && i!=j && graph[i][via]!=INF && graph[via][j]!=INF) {
                        graph[i][j] = Math.min(graph[i][j],graph[i][via]+graph[via][j]);
                    }
                }
            }
        }
    }
}
