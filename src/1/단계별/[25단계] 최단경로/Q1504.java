// 1504번 특정한 최단 경로
/*
<문제 정보>
 1. 1번 -> N번 주어진 두 정점을 반드시 거치면서 가는 최단경로
 2. 정점과 간선 모두 중복 이용 가능

<변수 범위>
 1. 1초 / 256MB
 2. 정점 N : 2이상 800 이하
 3. 간선 E : 0이상 200,000 이하
 4. 거리 (가중치) c : 1,000 이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Graph.WeightGraph_adj1;
import Necessary_Class.Pair.VPair;

import java.io.*;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Q1504 {
    static WeightGraph_adj1 g;
    final static int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        g = new WeightGraph_adj1(N);
        int[] dist_start = new int[N+1];
        int[] dist_mid1 = new int[N+1];
        int[] dist_mid2 = new int[N+1];

        int v1,v2,w;
        while(E-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            g.addEdge(new VPair(v1,w),new VPair(v2,w));
        }
        st = new StringTokenizer(br.readLine());
        int mid1 = Integer.parseInt(st.nextToken());
        int mid2 = Integer.parseInt(st.nextToken());

        dijkstra(1,dist_start);
        g.clear();
        dijkstra(mid1, dist_mid1);
        g.clear();
        dijkstra(mid2, dist_mid2);

        // int 의 계산이 long으로 나온다면 long으로 캐스팅을 해주어야 함
        long ans1 = (long) dist_start[mid1]+dist_mid1[mid2]+dist_mid2[N];
        long ans2 = (long) dist_start[mid2]+dist_mid2[mid1]+dist_mid1[N];
        System.out.printf("ans1 : %d, ans2 : %d\n",ans1,ans2);

        if (ans1>=INF && ans2>=INF) bw.write(String.valueOf(-1));
        else bw.write(String.valueOf(Math.min(ans1,ans2)));

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int source, int[] dist) {
        PriorityQueue<VPair> pq = new PriorityQueue<>();
        pq.add(new VPair(source,0));
        Arrays.fill(dist,INF);
        dist[source] = 0;
        VPair now;
        int temp;

        while(!pq.isEmpty()) {
            now = pq.poll();
            g.visited[now.v]=true;
            for (VPair v : g.adjList[now.v]) {
                temp = now.w + v.w;
                if (temp<dist[v.v]) {
                    dist[v.v] = temp;
                    if(!g.visited[v.v]) pq.add(new VPair(v.v,temp));
                }
            }
        }
    }
}

