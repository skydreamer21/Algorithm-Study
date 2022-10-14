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


import Necessary_Class.Pair.VPair;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Q1753_4 {
    static int start;
    static Graph1 g;
    static boolean[] visited;
    static Integer[] dist;
    final static int INF = Integer.MAX_VALUE;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        g = new Graph1(V);
        visited = new boolean[V+1];
        dist = new Integer[V+1];

        int v1,v2,w;
        while(E-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            g.addEdge(v1,new VPair(v2,w));
        }
        //g.printGraph();
        Arrays.fill(dist,INF);
        dist[start]=0;
        dijkstra();
        for (int i=1;i<=V;i++) sb.append( (dist[i]==INF) ? "INF" : dist[i] ).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra() {
        PriorityQueue<VPair> pq = new PriorityQueue<>();
        pq.add(new VPair(start,0));
        VPair now;
        int temp;


        while(!pq.isEmpty()) {
            now = pq.poll();
            visited[now.v]=true;
            for (VPair v : g.adjList[now.v]) {
                temp = dist[now.v]+v.w;
                if(temp<dist[v.v]) {
                    dist[v.v] = temp;
                    if(!visited[v.v]) pq.add(new VPair(v.v,temp));
                }
            }
        }
    }
}

// 방향 가중치 그래프
class Graph1 {
    int size;
    public ArrayList<VPair>[] adjList;
    public boolean[] visited;

    public Graph1 (int size) {
        this.size = size;
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge(int v1, VPair v2) {
        adjList[v1].add(v2);
    }

    public void printGraph() {
        for (int i=1;i<=size;i++) {
            System.out.printf("[%d] == ",i);
            for (VPair j : adjList[i]) System.out.printf("%d-",j.v);
            System.out.println();
        }
    }
}



