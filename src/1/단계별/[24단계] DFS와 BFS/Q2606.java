// 2606번 바이러스
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. 컴퓨터 수 N 100 이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import Necessary_Class.Graph.Graph_adjList1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2606 {
    static Graph_adjList1 g;
    static int cnt=0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        g = new Graph_adjList1(N+1);
        int v1; int v2;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            g.addEdge(v1,v2);
        }
        dfs(1);
        bw.write(String.valueOf(cnt-1));
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
                cnt++;
                for (int v : g.adjList[current]) {
                    if(!g.visited[v]) stack.add(v);
                }
            }
        }
    }

    public static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        int current;
        while(!q.isEmpty()) {
            current = q.poll();
            if (!g.visited[current]) {
                g.visited[current]=true;
                cnt++;
                for (int v : g.adjList[current]) {
                    if(!g.visited[v]) q.add(v);
                }
            }
        }
    }
}
