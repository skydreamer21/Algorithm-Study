// 1967번 트리의 지름
/*
<문제 정보>
 1. 트리의 지름

<변수 범위>
 1. 2초 / 128MB
 2.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import Necessary_Class.Pair.VPair;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Q1967 {
    static int N;
    static Graph5 g;
    static int max_dist=-1;
    static int maxNo;
    static int db_cnt=0;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        g = new Graph5(N);
        StringTokenizer st;
        int from, to, cost;
        for (int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            g.addEdge(new VPair(from,cost),new VPair(to, cost));
        }
        dfs(1,0);
//        System.out.printf("maxNo : %d\n",maxNo);
        g.clear();
        dfs(maxNo,0);
        System.out.println(max_dist);


        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int n, int dist) {
//        System.out.printf("n : %d, dist : %d\n",n,dist);
//        if(db_cnt++>100) return;
        if(dist>max_dist) {
            max_dist = dist;
            maxNo = n;
        }
        g.visited[n]=true;
        for (VPair v : g.adjList[n]) {
            if (!g.visited[v.v]) dfs(v.v,dist+v.w);
        }
    }
}

class Graph5{
    int size;
    ArrayList<VPair>[] adjList;
    boolean[] visited;

    public Graph5 (int size) {
        this.size = size;
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=0;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge (VPair v1, VPair v2) {
        adjList[v1.v].add(v2);
        adjList[v2.v].add(v1);
    }

    public void clear() {
        Arrays.fill(visited, false);
    }
}
