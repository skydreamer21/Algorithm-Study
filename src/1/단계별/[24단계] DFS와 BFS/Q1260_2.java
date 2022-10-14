// 1260번 DFS와 BFS
/*
<문제 정보>
 1. 그래프를 DFS, BFS로 탐색한 결과를 출력
 2. 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것부터 방문

<변수 범위>
 1. 2초 / 128MB
 2. 정점 개수 N 1000 이하 자연수 / 간선의 개수 10,000 이하의 자연수
 3. 간선은 양방향

<프로그램 진행>
 1.

<필요 함수>
 1.

 */




import Necessary_Class.Graph.*;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1260_2 {
    static Graph_matrix g;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        g = new Graph_matrix(N);
        int v1; int v2;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            g.addEdge(v1,v2);
        }
        dfs(V);
        g.clear();
        sb.append("\n");
        bfs(V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs (int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(start);
        int current;
        while (!stack.isEmpty()) {
            current = stack.pollLast();
            if (!g.visited[current]) {
                g.visited[current]=true;
                sb.append(current).append(" ");
                for (int i=g.vertex_size;i>0;i--) {
                    if (g.graph[current][i]==1 && !g.visited[i]) stack.add(i);
                }
            }
        }
    }

    public static void bfs (int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        int current;
        while(!q.isEmpty()) {
            current = q.poll();
            if (!g.visited[current]) {
                g.visited[current] = true;
                sb.append(current).append(" ");
                for (int i=1;i<=g.vertex_size;i++) {
                    if (g.graph[current][i]==1 && !g.visited[i]) q.add(i);
                }
            }
        }
    }
}
