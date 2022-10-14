// 17835번 면접보는 승범이네 (G2) [최단거리 - 다익스트라]
/*
<문제 정보>
 1. 각 도시에서 면접장까지의 거리 중 그 거리가 가장 먼 도시의 정보 출력

<변수 범위>
 1. 1초 / 256MB
 2. 2 <= N <= 100,000
 3. 1 <= M <= 500,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Q17835 {
    static int N, M, K;
    static DWGraph1 g;
    static long[] dist;
    static int maxDistCity = -1;
    static long maxDist = -1;

    static final long INF = Long.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new long[N+1];
        Arrays.fill(dist, INF);
        g = new DWGraph1(N);

        int from, to, w;
        while ( M-- >0 ) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            g.addEdge(to, from, w);
        }

        Deque<Node> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        int arrival;
        while ( K-- >0 ) {
            arrival = Integer.parseInt(st.nextToken());
            q.add(new Node(arrival, 0));
            dist[arrival] = 0;
        }

        // ******************** 메인 로직 ********************
        Node now;
        int next;
        long nextDist;

        while (!q.isEmpty()) {
            now = q.poll();
//            System.out.printf("now city : %d, now dist : %d\n",now.node, now.dist);

            for (Pair24 p : g.adjList[now.node]) {
                nextDist = now.dist + p.w;
                if (nextDist < dist[p.v]) {
                    dist[p.v] = nextDist;
                    q.add(new Node(p.v, nextDist));
                }
            }
        }

        for (int i=1; i<=N; i++) {
            if (dist[i] > maxDist) {
                maxDistCity = i;
                maxDist = dist[i];
            }
        }

        // ******************** 정답 출력 ********************
        sb.append(maxDistCity).append("\n").append(maxDist);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class DWGraph1 {
    ArrayList<Pair24>[] adjList;

    public DWGraph1 (int size) {
        adjList = new ArrayList[size+1];
        for (int i=1;i<=size;i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to, int w) {
        adjList[from].add(new Pair24(to, w));
    }
}

class Pair24 {
    int v, w;

    public Pair24 (int v, int w) {
        this.v = v;
        this.w = w;
    }
}

class Node {
    int node;
    long dist;

    public Node (int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}














