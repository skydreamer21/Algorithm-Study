// 2982번 국왕의 방문 (G2) [다익스트라, 인접행렬 그래프]
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

/*
- 구현 목록
- [x] 입력 받기
    - [x] 입력 받기
    - [x] 그래프 클래스 만들기
- [x] 국왕 이동 경로 자료구조 만들기
    - [x] bfs로 경로 대로 방문
    - [x] 방문할 때마다 Edge 정보를 Queue 저장
- [x] 그래프 만들기
- [ ] t분에 a에서 b지점으로 가는 시간을 구하는 함수 작성

 */

import java.io.*;
import java.util.*;

public class Q2982 {
    static int N, M, A, B, K, G;
    static WeightedGraph g;
    static int[] dist;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        Deque<Integer> kingPath = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            kingPath.add(Integer.parseInt(st.nextToken()));
        }

        g = new WeightedGraph(N);
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g.addEdge(v1, v2, w);
        }

        // ******************** 메인 로직 ********************
        Deque<Edge5> kingPathSchedule = makeKingPathSchedule(kingPath);
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;
        dijkstra(kingPathSchedule, A);

        // ******************** 정답 출력 ********************
        sb.append(dist[B] - K);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(Deque<Edge5> kingPathSchedule, int start) {
        PriorityQueue<VPair1> pq = new PriorityQueue<>();
        pq.add(new VPair1(start, K));


        VPair1 now;

        while (!pq.isEmpty()) {
            now = pq.poll();
            g.visited[now.v] = true;

            for (VPair1 next : g.adjList[now.v]) {
                if (!g.visited[next.v]) {
                    int moveTime = calculateEdgeTimeInReal(kingPathSchedule, now.w, now.v, next.v, next.w);
                    if (now.w + moveTime < dist[next.v]) {
                        dist[next.v] = now.w + moveTime;
                        pq.add(new VPair1(next.v, now.w + moveTime));
                    }
                }
            }
        }
    }

    public static Deque<Edge5> makeKingPathSchedule(Deque<Integer> kingPath) {
        Deque<Edge5> kingPathSchedule = new ArrayDeque<>();
        if (kingPath.size() < 2) return kingPathSchedule;

        Deque<Integer> q = new ArrayDeque<>();
        int start = kingPath.poll();
        q.add(start);


        int now, nextVisit;
        while (!kingPath.isEmpty()) {
            now = q.poll();
            nextVisit = kingPath.poll();

            for (VPair1 next : g.adjList[now]) {
                if (next.v == nextVisit) {
                    kingPathSchedule.add(new Edge5(now, nextVisit, next.w));
                    q.add(next.v);
                }
            }
        }
        return kingPathSchedule;
    }

    public static int calculateEdgeTimeInReal(Deque<Edge5> kingPathSchedule, int startTime, int from, int to, int moveTime) {
        final int START_TIME_INFO = 0;
        final int MOVE_TIME_INFO = 1;
        final int NOTHING = -1;

        if (kingPathSchedule.isEmpty()) return moveTime;

        List<Integer> edgeInfo = calculateEdgeInfo(kingPathSchedule, from, to);
        if (edgeInfo.contains(NOTHING)) return moveTime;

        int realStartTime = edgeInfo.get(START_TIME_INFO);
        int eta = realStartTime + edgeInfo.get(MOVE_TIME_INFO);
        if (startTime >= realStartTime && startTime < eta) {
            return moveTime + (eta - startTime);
        }

        return moveTime;
    }

    public static List<Integer> calculateEdgeInfo(Deque<Edge5> kingPathSchedule, int from, int to) {
        // 0: 출발지점 출발 시간, 1: 목적지까지 걸리는 시간
        int startTime = 0;
        int moveTime = 0;
        boolean hasSameEdge = false;
        Iterator<Edge5> iterator = kingPathSchedule.iterator();
        while (iterator.hasNext()) {
            Edge5 edge = iterator.next();
            if (isSameEdge(edge, from, to)) {
                hasSameEdge = true;
                moveTime = edge.w;
                break;
            } else {
                startTime += edge.w;
            }
        }
        return hasSameEdge ? List.of(startTime, moveTime) : List.of(-1, -1);
    }

    public static boolean isSameEdge(Edge5 edge, int from, int to) {
        Set<Integer> positions = Set.of(from, to);
        return positions.contains(edge.from) && positions.contains(edge.to);
    }
}

class WeightedGraph {
    ArrayList<VPair1>[] adjList;
    boolean[] visited;

    public WeightedGraph(int size) {
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1; i<=size; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v1, int v2, int w) {
        adjList[v1].add(new VPair1(v2, w));
        adjList[v2].add(new VPair1(v1, w));
    }

    public void clearVisited() {
        Arrays.fill(visited, false);
    }
}

class VPair1 implements Comparable<VPair1> {
    int v, w;

    public VPair1(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(VPair1 o) {
        return this.w - o.w;
    }
}

class Edge5 {
    int from, to, w;

    public Edge5(int from, int to, int w) {
        this.from = from;
        this.to = to;
        this.w = w;
    }
}











