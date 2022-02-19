// 1753번 최단경로
/*
<문제 정보>
 1. 방향그래프 주어질때 다른 모든 정점으로의 최단경로
 2. 자기 자신은 0으로 출력, 존재하지 않으면 INF 출력

<변수 범위>
 1. 1초 / 256MB
 2. 정점의 개수 V 20,000 이하 자연수
 3. 간선의 개수 E 300,000 이하 자연수
 4. 간선 가중치는 10 이하
 5. 서로 다른 두 정점 사이에 여러개의 간선이 존재할 수 있음

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q1753 {
    static int start;
    static Graph_adjList2 g;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        g = new Graph_adjList2(V);
        while(E-- >0) {
            st = new StringTokenizer(br.readLine());
            g.addEdge(Integer.parseInt(st.nextToken()),
                    new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }


       //System.out.printf("%d->%d : %d\n",1,4,dfs(4));

        int ans;
        for (int i=1;i<=V;i++) {
            if (i==start) sb.append(0).append("\n");
            else {
                ans = dfs(i);
                if (ans==Integer.MAX_VALUE) sb.append("INF\n");
                else sb.append(ans).append("\n");
            }
        }







        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int end) {
        Deque<Pair> stack = new ArrayDeque<>();
        stack.add(new Pair(start,0));
        Pair now;
        int min=(g.visited[end]==0) ? Integer.MAX_VALUE : g.visited[end];

        while (!stack.isEmpty()) {
            now = stack.pollLast();
            //System.out.printf("now : %d\n",now.v);

            if (g.visited[now.v]!=0 && g.visited[now.v]<now.w) continue;

            for (Pair adj : g.adjList[now.v]) {
                // 정답 체크
                if (adj.v==end) min = Math.min(min,now.w+adj.w);
                if (g.visited[adj.v]==0 || g.visited[adj.v]>now.w+adj.w) {
                    g.visited[adj.v] = now.w+adj.w;
                    stack.add(new Pair(adj.v,now.w+adj.w));
                }
            }
            //printStack(stack);
            //System.out.println("------------------------------");
        }
        return min;
    }

    public static void printStack (Deque<Pair> stack) {
        for (Pair coor : stack) System.out.printf("(%d, %d) ",coor.v,coor.w);
        System.out.println();
    }
}


// 방향-가중치 그래프
class Graph_adjList2 {
    int size;
    ArrayList<Pair>[] adjList;
    int[] visited;

    public Graph_adjList2 (int size) {
        this.size = size;
        adjList = new ArrayList[size+1];
        visited = new int[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge(int v1, Pair v2) {
        adjList[v1].add(v2);
    }
}

class Pair {
    public int v,w;
    public Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}