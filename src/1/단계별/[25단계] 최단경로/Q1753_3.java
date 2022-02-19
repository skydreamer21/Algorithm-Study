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

import Necessary_Class.Graph.Graph_adjList2;
import Necessary_Class.Pair.VPair;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1753_3 {
    static int start;
    static Graph_adjList2 g;
    static boolean[] visited;
    static boolean[] complete;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        g = new Graph_adjList2(V);
        visited = new boolean[V+1];
        complete = new boolean[V+1];

        int v1,v2,w;
        while(E-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            g.addEdge(v2,new VPair(v1,w));
        }
        //g.printGraph();
        g.visited[start]=0;

        System.out.printf("%d -> %d : %d\n",3,2,getMinDis(2));
        System.out.println(Arrays.toString(g.visited));

/*
        for (int i=1;i<=V;i++) {
            if(getMinDis(i)==-1) sb.append("INF\n");
            else sb.append(getMinDis(i)).append("\n");
        }
 */

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMinDis (int end) {
        System.out.printf("<recur> end No : %d\n",end);
        boolean check = false;
        if (g.visited[end]==null) {
            visited[end] = true;
            g.visited[end] = Integer.MAX_VALUE;
            for (VPair v1 : g.adjList[end]) {
                if ((visited[v1.v] && !complete[v1.v]) || getMinDis(v1.v)==-1 || g.visited[v1.v]==Integer.MAX_VALUE) continue;
                check = true;
                System.out.printf("%d에서 %d 대입\n",end,v1.v);
                g.visited[end] = Math.min(g.visited[end], getMinDis(v1.v)+v1.w);
            }
            if(check) complete[end] = true;
        }
        if(!complete[end]) return Integer.MAX_VALUE;
        if(g.visited[end]==Integer.MAX_VALUE) g.visited[end]=-1;
        System.out.printf("%d의 결과 : %d\n",end,g.visited[end]);
        return g.visited[end];
    }
}



