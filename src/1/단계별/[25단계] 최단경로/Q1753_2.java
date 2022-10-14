// 1753번 최단경로
/*
<문제 정보>
 1. 방향그래프 주어질때 다른 모든 정점으로의 최단경로
 2. 자기 자신은 0으로 출력, 존재하지 않으면 INF 출력

<변수 범위>
 1. 1초 / 256MB
 2. 정점의 개수 V 20,000 이하 자연수
 3. 간선의 개수 E 300,000 이하 자연수
 4. 간선 가중치는 10 이하
 5. 서로 다른 두 정점 사이에 여러개의 간선이 존재할 수 있음

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Graph.Graph_matrix2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1753_2 {
    static int start;
    static Graph_matrix2 g;
    static ArrayList<Integer>[] reverseAdj;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        g = new Graph_matrix2(V);
        reverseAdj = new ArrayList[V+1];
        for (int i=1;i<=V;i++) reverseAdj[i] = new ArrayList<>();

        int v1,v2,w;
        while(E-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            g.addEdge(v1,v2,w);
            reverseAdj[v2].add(v1);
        }
        //g.printGraph();
        g.visited[start]=0;

        for (int i=1;i<=V;i++) {
            if(getMinDis(i)==-1) sb.append("INF\n");
            else sb.append(getMinDis(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMinDis (int end) {
        if (g.visited[end]==null) {
            g.visited[end] = Integer.MAX_VALUE;
            for (int v1 : reverseAdj[end]) {
                if (getMinDis(v1)==-1) continue;
                g.visited[end] = Math.min(g.visited[end], getMinDis(v1)+g.graph[v1][end]);
            }
        }
        if(g.visited[end]==Integer.MAX_VALUE) g.visited[end]=-1;
        return g.visited[end];
    }
}



