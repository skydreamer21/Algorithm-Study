// 2644번 촌수계산(S2) [bfs dfs] [그래프 탐색]
/*
<문제 정보>
 1. 두 사람의 촌수 출력
    - 앞이 부모 뒤가 자식
    - 촌수 계산 불가 -1

<변수 범위>
 1. 1초 / 128MB
 2. 사람들 1<=N<=100

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q2644 {
    static int N;
    static Graph7 g;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int v1,v2;
        g = new Graph7(N);
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            g.addEdge(v1,v2);
        }
        bw.write(String.valueOf(bfs(a,b)));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int bfs (int from, int to) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(from);
        g.visited[from]=true;
        int now;
        int s;
        int dis=0;
        boolean findAns=false;

        while(!q.isEmpty()) {
            if (findAns) break;
            s=q.size();
            for (int i=0;i<s;i++){
                if (findAns) break;
                now = q.poll();
                for (int v : g.adjList[now]) {
                    if (!g.visited[v]) {
                        if(v==to) {
                            findAns=true;
                            break;
                        }
                        g.visited[v]=true;
                        q.add(v);
                    }
                }
            }
            dis++;
        }
        return findAns ? dis : -1;
    }
}

// 무방향 그래프 (가중치x)
class Graph7 {
    ArrayList<Integer>[] adjList;
    boolean[] visited;

    public Graph7 (int size) {
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge (int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }
}


















