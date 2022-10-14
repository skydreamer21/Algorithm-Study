// 11657번 타임머신
/*
<문제 정보>
 1. 1번에서 출발해서 나머지 도시로 가는 가장 빠른 시간 구하기
 2. 1번 도시에서 출발해서 시간을 무한히 오래전으로 되돌릴 수 있다면 -1 출력

<변수 범위>
 1. 1초 / 256MB
 2. 도시 개수 N 1<=N<=500
 3. 버스 노선 개수 M 1<=M<=6,000
 4. 시간 C -10,000<=C<=10,000

<프로그램 진행>
 1. 밸먼포드 알고리즘

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

// INF=MAX_VALUE 로 할경우 overflow가 날 수 있음 (INF + ~ 는 int 형에서 맥스음수값으로 처리되서 Math.min에 걸림)
// long으로 하거나 제한값이 괜찮으면 overflow에 안전한 MAX_VALUE보다 낮은 값으로 INF 설정
// 음수 사이클이 존재할경우 값이 무한정 작아지기 때문에 underflow또한 날 수 있음.

// 사이클이 생기더라도 도달 못하는 경우가 있을 수 있음

public class Q11657 {
    static ArrayList<Bus> bus = new ArrayList<>();
    //static Graph_adjList1 g;
    static int N;
    static int[] dist;
    final static int INF = 100000000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //g = new Graph_adjList1(N);
        dist = new int[N+1];
        int from,to,time;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            //g.addEdge(from,to);
            bus.add(new Bus(from,to,time));
        }
        //bfs();
        if(BellmanFord()) {
            for (int i=2;i<=N;i++) sb.append((dist[i]==INF) ? -1 : dist[i]).append("\n");
        }
        else sb.append(-1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean BellmanFord () {
        boolean inTime = true;
        long temp;

        Arrays.fill(dist,INF);
        dist[1]=0;
        for (int i=1;i<=N;i++) {
            if (i<N) {
                for (Bus b : bus) {
                    if (dist[b.from]==INF) continue;
                    // 위 조건문을 추가해주면 시작점에서 from에 도달 못했으면 갱신자체가 안됨
                    temp = (long) dist[b.from]+b.time;
                    if (temp<Integer.MIN_VALUE) {
                        inTime=false;
                        break;
                    }
                    dist[b.to] = Math.min(dist[b.to],dist[b.from]+b.time);
                }
            }
            if (i==N) {
                for (Bus b : bus) {
                    if (dist[b.from]==INF) continue;
                    temp = (long) dist[b.from]+b.time;
                    if(temp<dist[b.to] || temp<Integer.MIN_VALUE) {
                        inTime = false;
                        break;
                    }
                }
            }
        }
        return inTime;
    }
/*
    public static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        int now;

        while(!q.isEmpty()) {
            now = q.poll();
            g.visited[now]=true;
            for (int next : g.adjList[now]) {
                if(!g.visited[next]) q.add(next);
            }
        }
    }

 */
}

class Bus {
    int from, to, time;

    public Bus (int from, int to, int time) {
        this.from=from;
        this.to=to;
        this.time=time;
    }
}
/*
// 방향 그래프
class Graph_adjList1 {
    int vertex_size; // 정점 개수
    public ArrayList<Integer>[] adjList; // 정점과 연결되어 있는 점들의 List -> 정점당 하나의 List를 갖고 있음
    public boolean[] visited; // 방문 기록 --> 정점의 개수 만큼

    // 생성자 -> 그래프의 크기를 입력받아 정해줌
    public Graph_adjList1(int v) {
        this.vertex_size = v;
        adjList = new ArrayList[vertex_size+1];
        visited = new boolean[vertex_size+1];
        for (int i=0;i<=vertex_size;i++) adjList[i] = new ArrayList<>(); // (중요!) 정점하나당 인접리스트 생성
    }

    // 정점 연결 메소드
    public void addEdge(int v1, int v2) {
        adjList[v1].add(v2);
    }

    // 방문 기록 초기화
    public void clear() {
        Arrays.fill(visited, false);
    }
}

 */
