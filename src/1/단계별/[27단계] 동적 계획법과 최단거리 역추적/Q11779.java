// 11779번 최소비용 구하기2
/*
<문제 정보>
 1. A->B로 이동하는데 드는 최소비용과 경로 출력

<변수 범위>
 1. 1초 / 256MB
 2. 도시 개수 1<=n<=1,000
 3. 도시1->도시2 버스 개수 1<=m<=100,000
 4. 버스 비용 0<=cost<=100,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Pair.VPair;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Q11779 {
    static Graph2 g;
    static int[] dist;
    static int[] path;
    static int INF = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        g = new Graph2(N);
        dist = new int[N+1];
        Arrays.fill(dist,INF);
        path = new int[N+1];
        int from,to,cost;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            g.addEdge(from,new VPair(to,cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist[start]=0;
        dijkstra(start);
        int tmp=end;
        ArrayList<Integer> p = new ArrayList<>();
        while(tmp!=start) {
            p.add(tmp);
            tmp = path[tmp];
        }
        p.add(start);
        sb.append(dist[end]).append("\n");
        sb.append(p.size()).append("\n");
        for (int i=p.size()-1;i>=0;i--) sb.append(p.get(i)).append(" ");
        //sb.reverse(); 들어가는 숫자가 한자리일 때만 됨


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dijkstra(int start) {
        PriorityQueue<VPair> pq = new PriorityQueue<>();
        pq.add(new VPair(start, 0));
        VPair now;
        int temp;

        while(!pq.isEmpty()) {
            now = pq.poll();
            if (now.w>dist[now.v]) continue;
            // 위에 코드가 더 시간이 적게 걸림 visit한 곳 뿐만 아니라 아닌곳 중에서도 필요없는곳 거름
            // if(g.visited[now.v]) continue;
            g.visited[now.v]=true;
            for (VPair v : g.adjList[now.v]) {
                temp = dist[now.v]+v.w;
                if(temp<dist[v.v]) {
                    dist[v.v]=temp;
                    path[v.v] = now.v;
                    if(!g.visited[v.v]) pq.add(new VPair(v.v,temp));
                }
            }
        }
    }

}

// 방향 - 가중치 그래프
class Graph2 {
    int size;
    ArrayList<VPair>[] adjList;
    boolean[] visited;

    public Graph2 (int size) {
        this.size = size;
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=0;i<=size;i++) adjList[i]=new ArrayList<>();
    }

    public void addEdge (int v1, VPair v2) {
        adjList[v1].add(v2);
    }
}
