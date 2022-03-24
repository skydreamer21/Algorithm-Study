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
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q11403 {
    static int N;
    static int[][] g;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        g = new int[N+1][N+1];
        visited = new boolean[N+1];
//        int[][] ans = new int[N+1][N+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) g[i][j]=Integer.parseInt(st.nextToken());
        }
        for (int i=1;i<=N;i++) {
            for (int j=1;j<=N;j++) {
                sb.append(dfs(i,j)).append(" ");
//                ans[i][j]=dfs(i,j);
                Arrays.fill(visited,false);
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(int from, int to) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(from);
        visited[from]=true;
        int now;
        boolean findAns=false;

        while(!stack.isEmpty()) {
            if(findAns) break;
            now = stack.pollLast();
            for (int i=1;i<=N;i++) {
                if(i==now) continue;
                if (from==to && i==from && g[now][from]==1) {
                    findAns=true;
                    break;
                }
                if(!visited[i] && g[now][i]==1) {
                    if(i==to) {
                        findAns=true;
                        break;
                    }
                    stack.add(i);
                    visited[i]=true;
                }
            }
        }
        return findAns ? 1 : 0;
    }
}










