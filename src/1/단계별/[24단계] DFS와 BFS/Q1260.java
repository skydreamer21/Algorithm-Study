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


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Collections;
import Necessary_Class.Graph.*;

public class Q1260 {
    static Graph_adjList1 g;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        g = new Graph_adjList1(N+1);
        int v1; int v2;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            g.addEdge(v1,v2);
        }
        for (int i=0;i<=N;i++) Collections.sort(g.adjList[i],Collections.reverseOrder());
        dfs(V);
        g.clear();
        for (int i=0;i<=N;i++) Collections.sort(g.adjList[i]);
        sb.append("\n");
        bfs(V);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(start);
        int current;
        while(!stack.isEmpty()) {
            current = stack.pollLast();
            if (!g.visited[current]) {
                g.visited[current]=true;
                sb.append(current).append(" ");
                for (int v : g.adjList[current]) {
                    if(!g.visited[v]) stack.add(v);
                }
            }
        }
    }

    public static void dfs2(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(start);
        dfs_recur(stack, start);
    }

    public static void dfs_recur(Deque<Integer> stack, int v) {
        if (g.visited[v]) return;
        int current=stack.pollLast();
        g.visited[current] = true;
        sb.append(current).append(" ");
        boolean flag = false;
        for (int i : g.adjList[current]) {
            if(!g.visited[i]) {
                flag = true;
                stack.add(i);
            }
        }
        if (!flag) return;
        dfs_recur(stack, stack.peekLast());
    }

    public static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        int current;
        while(!q.isEmpty()) {
            current = q.poll();
            if (!g.visited[current]) {
                g.visited[current]=true;
                sb.append(current).append(" ");
                for (int v : g.adjList[current]) {
                    if(!g.visited[v]) q.add(v);
                }
            }
        }
    }
}
