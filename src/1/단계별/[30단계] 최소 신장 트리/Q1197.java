// 1197번 최소 스패닝 트리
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. 정점의 개수 1<=V<=10,000
 3. 간선의 개수 1<=E<=100,000
 4. 가중치 C 절댓값이 1,000,000 이하인 정수
 5. MST의 가중치는 int 범위 이내

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


// 정렬 말고 priority Queue로 구현 해보기
// 39495546	chasonghui 나랑 같은 방법인데 100ms 이상 차이남
// 39473797	alsdyd320 같은 Kruskal 인데 pq로 구현

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1197 {
    static int[] parent;
    static int V;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        initSet();
        int E = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[E];
        int v1,v2,c;
        /*
        <Kruskal Algorithm>
        1. 간선을 입력 받아 Cost를 기준으로 정렬
        2. 정렬된 배열에서 순차적으로 사이클이 생기지 않게 n-1개의 간선을 선택
        3. 가중치 출력
         */
        for (int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(v1,v2,c);
        }
        Arrays.sort(edges);
        int Enum=0;
        int mst_cost=0;
        for (Edge edge : edges) {
            if(union(edge.node1,edge.node2)) {
                mst_cost+=edge.cost;
                Enum++;
            }
            if (Enum==V-1) break; // 어차피 v-1 개를 넘어가면 사이클이 생겨서 안세줘도 괜찮!
        }
        bw.write(String.valueOf(mst_cost));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void initSet() {
        for (int i=1;i<=V;i++) parent[i]=i;
    }

    public static int find (int a) {
        if (parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }

    public static boolean union (int a, int b) {
        a = find(a);
        b = find(b);
        if (a==b) return false;
        else {
            if(a>b) parent[a]=b;
            else parent[b]=a;
            return true;
        }
    }
}

class Edge implements Comparable<Edge> {
    int node1;
    int node2;
    int cost;

    public Edge (int v1, int v2, int c) {
        this.node1 = v1;
        this.node2 = v2;
        this.cost = c;
    }

    @Override
    public int compareTo (Edge E) {
        return this.cost-E.cost;
    }
}



















