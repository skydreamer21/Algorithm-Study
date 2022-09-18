// 15591번 MooTube(Silver) (G5) [bfs]
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


import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Q15591 {
    static int N, Q;
    static WGraph2 g;

    static int INF = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        g = new WGraph2(N);

        int v1, v2, s;
        for (int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            g.addEdge(v1, v2, s);
        }

        // ******************** 메인 로직 ********************
        int k, v;
        while (Q-- >0) {
            g.clearVisited();
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            ArrayList<Integer> recommend = bfs(v, k);
            sb.append(recommend.size()).append("\n");
        }

        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static ArrayList<Integer> bfs(int start, int threshold) {
        ArrayList<Integer> recommend = new ArrayList<>();
        Deque<Pair23> q = new ArrayDeque<>();
        q.add(new Pair23(start, INF));
        g.visited[start] = true;

        Pair23 now;
        int s;

        while (!q.isEmpty()) {
            now = q.poll();

            for (Pair23 v : g.adjList[now.v]) {
                if (!g.visited[v.v]) {
                    // 정상적인 mst 라면 반드시 아래 return 문에서 이 함수가 종료됨.
                    s = Math.min(now.s, v.s);
                    if (s >= threshold) recommend.add(v.v);
                    q.add(new Pair23(v.v, Math.min(now.s, v.s)));
                    g.visited[v.v] = true;
                }
            }
        }
        return recommend;
    }
}

class WGraph2 {
    ArrayList<Pair23>[] adjList;
    boolean[] visited;

    public WGraph2(int size) {
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge(int v1, int v2, int s) {
        adjList[v1].add(new Pair23(v2, s));
        adjList[v2].add(new Pair23(v1, s));
    }

    public void clearVisited() {
        Arrays.fill(this.visited, false);
    }
}

class Pair23 {
    int v, s;

    public Pair23 (int v, int s) {
        this.v = v;
        this.s = s;
    }
}
