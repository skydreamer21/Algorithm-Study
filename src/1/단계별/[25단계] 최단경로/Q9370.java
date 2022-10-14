// 번
/*
<문제 정보>
 1.

<변수 범위>
 1. 3초 / 256MB
 2. 2<=n<=2,000 / 1<=m<=50,000 / 1<=t<=100
 3. 도로 길이 d 1<=d<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Graph.WeightGraph_adj1;
import Necessary_Class.Pair.VPair;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Q9370 {
    static WeightGraph_adj1 graph;
    static int[] dest;
    static int[] dist_start;
    static int[] dist_mid1;
    static int[] dist_mid2;
    final static int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n,m,t;
        int s,g,h;
        int v1,v2,w;
        int T = Integer.parseInt(br.readLine());
        while (T-- >0) {
            //-------------- input --------------------------------
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 교차로(정점)
            m = Integer.parseInt(st.nextToken()); // 도로 (간선)
            t = Integer.parseInt(st.nextToken()); // 목적지 후보

            graph = new WeightGraph_adj1(n);
            dest = new int[t];
            dist_start=new int[n+1];
            dist_mid1=new int[n+1];
            dist_mid2=new int[n+1];

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); // 예술가들 출발지점
            g = Integer.parseInt(st.nextToken()); // g-h 도로 정보
            h = Integer.parseInt(st.nextToken()); // g-h 도로 정보

            // 도로 입력
            while(m-->0) {
                st = new StringTokenizer(br.readLine());
                v1 = Integer.parseInt(st.nextToken());
                v2 = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                graph.addEdge(new VPair(v1,w),new VPair(v2,w));
            }

            // 후보 입력
            for (int i=0;i<t;i++) dest[i]=Integer.parseInt(br.readLine());
            // --------------------------------------------------------------------

            // ----------------------------- program ------------------------------
            Arrays.sort(dest);

            dijkstra(s,dist_start);
            graph.clear();
            dijkstra(g,dist_mid1);
            graph.clear();
            dijkstra(h,dist_mid2);

            for (int i=0;i<t;i++) Check(dest[i],g,h);
            sb.append("\n");
            // ----------------------------------------------------------------------
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void Check(int t, int g, int h) {
        int ans = dist_start[t];
        long possible1 = (long) dist_start[g] + dist_mid1[h] + dist_mid2[t];
        long possible2 = (long) dist_start[h] + dist_mid2[g] + dist_mid1[t];
        if (ans==possible1 || ans==possible2) sb.append(t).append(" ");
    }

    public static void dijkstra (int start, int[] dist) {
        PriorityQueue<VPair> pq = new PriorityQueue<>();
        pq.add(new VPair(start,0));
        Arrays.fill(dist,INF);
        dist[start]=0;
        VPair now;
        int temp;

        while (!pq.isEmpty()) {
            now = pq.poll();
            graph.visited[now.v]=true;
            for (VPair v : graph.adjList[now.v]) {
                temp = now.w + v.w;
                if(temp<dist[v.v]) {
                    dist[v.v]=temp;
                    if(!graph.visited[v.v]) pq.add(new VPair(v.v,temp));
                }
            }
        }
    }
}
