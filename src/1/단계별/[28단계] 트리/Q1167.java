// 1167번 트리의 지름
/*
<문제 정보>
 1. 트리의 지름 : 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것

<변수 범위>
 1. 2초 / 256MB
 2. 정점 개수 2<=V<=100,000
 3. 거리는 10,000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import Necessary_Class.Pair.VPair;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

// 시간복잡도 O(NlogN)

public class Q1167 {
    static int N;
    static Graph4 g;
    static int max_dist=-1;
    static int start;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        g = new Graph4(N);
        int from,to,cost;
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            //System.out.printf("from : %d\n",from);
            while(true) {
                to = Integer.parseInt(st.nextToken());
                //System.out.println(to);
                if (to==-1) break;
                cost = Integer.parseInt(st.nextToken());
                g.addEdge(from,new VPair(to,cost));
            }
        }
        start=1;
        dfs(start);
        bw.write(String.valueOf(max_dist));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int n) {
        int temp;
        g.visited[n]=true;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        //System.out.printf("%d IN\n",n);
        for (VPair v : g.adjList[n]) {
            if (!g.visited[v.v]) {
                temp = dfs(v.v)+ v.w;
                pq.add(temp);
            }
        }
        //System.out.printf("%d OUT\n",n);
        if(pq.size()==0) return 0;
        else if (pq.size()==1) {
            if(n==start) max_dist = Math.max(max_dist,pq.peek());
            return pq.poll();
        }
        int m1 = pq.poll();
        int m2 = pq.poll();
        max_dist = Math.max(max_dist,m1+m2);
        return m1;
    }
}

// 무방향 가중치 그래프
class Graph4 {
    int size;
    ArrayList<VPair>[] adjList;
    boolean[] visited;

    public Graph4 (int size) {
        this.size = size;
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=0;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    // 입력이 양방향 2번 주어지기 때문에 무방향이라도 이렇게 설정
    public void addEdge (int v1, VPair v2) {
        adjList[v1].add(v2);
    }
}
