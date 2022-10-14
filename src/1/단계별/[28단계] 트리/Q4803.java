// 4803번 트리
/*
<문제 정보>
 1. 주어진 그래프에 트리가 몇개 있는지 테스트 케이스별로 출력

<변수 범위>
 1. 1초 / 256MB
 2. 정점개수 n<=500
 3. 간선 m<=n(n-1)/2

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Pair.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;



public class Q4803 {
    static Graph6 g;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, m;
        int v1, v2;
        int testcase=1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n==0 && m==0) break;
            g = new Graph6(n);
            while(m-->0) {
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                g.addEdge(v1,v2);
            }
            // 정점별로 dfs 순회
            int cnt=0;
            for (int i=1;i<=n;i++) {
                if(g.visited[i]) continue;
                if(dfs(i)) cnt++;
            }
            sb.append("Case ").append(testcase++).append(": ");
            if(cnt==0) sb.append("No trees.").append("\n");
            else if (cnt==1) sb.append("There is one tree.\n");
            else sb.append("A forest of ").append(cnt).append(" trees.\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean dfs(int start) {
        Deque<Pair> stack = new ArrayDeque<>();
        stack.add(new Pair(start,0));
        g.visited[start]=true;
        Pair now;
        int root;
        boolean isTree = true;

        while(!stack.isEmpty()) {
            now = stack.pollLast();
            root = now.y;
            for (int child : g.adjList[now.x]) {
                if(g.visited[child]) {
                    if (child != root) isTree = false;
                }
                else {
                    g.visited[child] = true;
                    stack.add(new Pair(child,now.x));
                }
            }
        }
        return isTree;
    }
}

// 무방향 그래프 (가중치X)
class Graph6 {
    ArrayList<Integer>[] adjList;
    boolean[] visited;

    public Graph6 (int size) {
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge (int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }
}
























