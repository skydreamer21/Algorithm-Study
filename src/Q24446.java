// 번
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Q24446 {
    static int N;
    static Graph14 g;
    static int[] depths;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        g = new Graph14(N);
        int v1, v2;
        while(M-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            g.addEdge(v1, v2);
        }
        depths = new int[N+1];
        Arrays.fill(depths, -1);

        bfs(R);
        for (int i=1;i<=N;i++) sb.append(depths[i]).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs (int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
//        g.visited[start]=true;
        depths[start] = 0;
        int now;
        int size;
        int depth=0;

        while(!q.isEmpty()) {
            depth++;
            size = q.size();
            for (int i=0; i<size; i++) {
                now = q.poll();

                for (int node : g.adjList[now]) {
                    if (depths[node] == -1) {
//                        g.visited[node]=true;
                        depths[node] = depth;
                        q.add(node);
                    }
                }
            }
        }
    }
}

// 무방향, 무가중치 그래프
class Graph14 {
    ArrayList<Integer>[] adjList;
//    boolean[] visited;

    public Graph14 (int size) {
        adjList = new ArrayList[size+1];
//        visited = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge (int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }
}