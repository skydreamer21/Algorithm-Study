// 1135번 뉴스전하기 (G2)
/*
<문제 정보>
 1.

<변수 범위>
 1. 2초 / 128MB


<프로그램 진행>
 1. 직원의 수 N 50 이하


<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Q1135 {
    static int N;
    static int[] tree;
    static Graph13 g;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) tree[i] = Integer.parseInt(st.nextToken());

        // ******************** 메인 로직 ********************
        // 1. 주어진 tree로 그래프 만들기
        g = treeToGraph(tree);

        // 2. 최소 시간 구하기
        int minTime = dfs(0);

        // ******************** 정답 출력 ********************

        sb.append(minTime);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int node) {
//        System.out.printf("[IN] node : %d\n", node);
        // 1. 자식 노드가 없으면 0 반환
        if (g.adjList[node].isEmpty()) {
//            System.out.printf("[OUT - 자식노드가 없음] node : %d\n", node);
            return 0;
        }

        // 2. 자식노드에서부터 받아온 dfs 값을 ArrayList에 넣는다.
        ArrayList<Integer> childNodeTimes = new ArrayList<>();
        for (int child : g.adjList[node]) {
            childNodeTimes.add(dfs(child));
        }
        Collections.sort(childNodeTimes, (a,b) -> (b-a));

        int thisNodeTime = -1;
        int phoneTime = 1;
        for (int childTime : childNodeTimes) {
            thisNodeTime = Math.max(thisNodeTime, phoneTime++ + childTime);
        }

//        System.out.printf("[OUT - 계산완료] node : %d, thisNodeTime : %d\n", node, thisNodeTime);
        return thisNodeTime;
    }

    public static Graph13 treeToGraph (int[] tree) {
        Graph13 g = new Graph13(N);
        for (int i=N-1; i>0; i--) {
            int parent = tree[i];
            g.addEdge(parent, i);
        }
        return g;
    }
}

// 단방향, 무가중치 그래프
class Graph13 {
    ArrayList<Integer>[] adjList;
    boolean[] visited;

    public Graph13 (int size) {
        adjList = new ArrayList[size];
        visited = new boolean[size];
        for (int i=0; i<size; i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge (int from, int to) {
        adjList[from].add(to);
    }
}
