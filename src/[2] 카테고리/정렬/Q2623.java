// 2623번 음악프로그램 (G3) [위상정렬]
/*
<문제 정보>
 1. 각 보조 PD 들이 짜온 순서에 맞게 공연 순서를 정해보자

<변수 범위>
 1. 1초 / 128MB
 2. 가수의 수 1 <= N <= 1,000
 3. PD의 수 1 <= M <= 100

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

public class Q2623 {
    static int N;
    static int[] inDegree;
    static DGraph g;

    static final int IMPOSSIBLE = -1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        g = new DGraph(N);
        inDegree = new int[N+1];

        int singersInOrder;
        int from, to;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            singersInOrder = Integer.parseInt(st.nextToken());

            to = Integer.parseInt(st.nextToken());
            for (int i=1; i<singersInOrder; i++) {
                from = to;
                to = Integer.parseInt(st.nextToken());
                g.addEdge(from, to);
                inDegree[to]++;
            }
        }

        /*System.out.println("< 그래프 확인 >");
        g.printGraph();
        System.out.println("\n< inDegree 확인 >");
        for (int i=1; i<=N; i++) {
            System.out.printf("%d ", inDegree[i]);
        }
        System.out.println();*/

        // ******************** 메인 로직 ********************

        int[] orderOfSingers = topologySort();

        // ******************** 정답 출력 ********************

        if (orderOfSingers[0] == IMPOSSIBLE) {
            sb.append(0);
        }
        else {
            for (int i=0; i<N ;i++) {
                sb.append(orderOfSingers[i]).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] topologySort() {
        Deque<Integer> q = new ArrayDeque<>();
        int visited = 0;
        for (int i=1; i<=N; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        int now;
        int[] orderOfSingers = new int[N];

        while (!q.isEmpty()) {
            now = q.poll();
            orderOfSingers[visited++] = now;

            for (int next : g.adjList[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        return visited == N ? orderOfSingers : new int[] {-1};
    }
}

class DGraph {
    ArrayList<Integer>[] adjList;
    boolean[] visited;

    public DGraph (int size) {
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge(int from, int to) {
        adjList[from].add(to);
    }

    public void printGraph() {
        for (int i=1; i<adjList.length; i++) {
            System.out.printf("%d -> ", i);
            for (int to : adjList[i]) {
                System.out.printf("%d,",to);
            }
            System.out.println();
        }
    }
}
