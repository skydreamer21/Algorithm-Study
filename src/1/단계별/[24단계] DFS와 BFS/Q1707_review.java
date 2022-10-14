// 1707번 이분 그래프
/*
<문제 정보>
 1. 그래프가 완전히 두개로 나누어질 수 있으면 이분 그래프
 2. 이분그래프 인지 아닌지 판별
 3. 각 정점에는 1부터 V까지 차례로 번호가 붙어 있음


<변수 범위>
 1. 2초 / 256MB
 2. 테스트 케이스 2이상 5이하
 3. 정점 개수 V 20,000 이하 자연수
 4. 간선 개수 E 200,000 이하 자연수


<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// LinkedList로 구현하면 기능은 똑같은데 다음 노드를 저장하는 추가공간이 들어
// ArrayList에 비해 비효율적

// review : 재귀로 dfs 구현했을때 시간차이 알아보자

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Q1707_review {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        int V, E;
        while(K-- >0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            Graph g = new Graph(V);
            while(E-- >0) {
                st = new StringTokenizer(br.readLine());
                g.addEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            if(g.dfs()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Graph {
    int vertex_size;
    ArrayList<Integer>[] adjList;
    boolean[] visited;
    boolean[] status;

    public Graph (int size) {
        this.vertex_size = size;
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        status = new boolean[size+1];
        for (int i=1;i<=size;i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge (int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }

    public boolean dfs() {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=vertex_size;i>=1;i--) stack.add(i);
        visited[1]=true;
        status[1]=true;
        int now;
        boolean BG = true;
        while(!stack.isEmpty()) {
            if (!BG) break;
            now = stack.pollLast();
            for (int i : adjList[now]) {
                if(!visited[i]) {
                    visited[i]=true;
                    status[i]=!status[now];
                    stack.add(i);
                }
                else if(status[i]==status[now]) {
                    BG = false;
                    break;
                }

            }
        }
        return BG;
    }
}
