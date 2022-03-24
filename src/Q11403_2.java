// 11403번 경로 찾기(S1) [dfs bfs] [floyd warshall]
/*
<문제 정보>
 1. 모든 정점에 대해 i에서 j로 가는 경로가 있는지 출력

<변수 범위>
 1. 1초 / 256MB
 2. 정점의 개수 1<=N<=100

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q11403_2 {
    static int N;
    static int[][] g;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        g = new int[N+1][N+1];

        int tmp;
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) {
                tmp=Integer.parseInt(st.nextToken());
                g[i][j]=tmp==0 ? INF : tmp;
            }
        }
        floyd_warshall();
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                sb.append(g[i][j]==INF ? 0 : 1).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void floyd_warshall() {
        for (int via=1;via<=N;via++) {
            // via를 통해서 가는 것이 더 짧다면 갱신
            for (int i=1;i<=N;i++) {
                for (int j=1;j<=N;j++) {
                    if (i!=via && j!=via && g[i][via]!=INF && g[via][j]!=INF) {
                        g[i][j]=Math.min(g[i][j],g[i][via]+g[via][j]);
                    }
                }
            }
        }
    }
}












