// 19535번 ㄷㄷㄷㅈ (G3)
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
import java.util.ArrayList;

public class Q19535 {
    static int N;
    static Graph12 g;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        g = new Graph12(N);
        int v1,v2;
        for (int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            g.addEdge(v1, v2);
        }


        // ******************** 메인 로직 ********************
        int numOfD = find_D(0,1);
        long numOfG = find_G();
        if (numOfD > 3*numOfG) sb.append("D");
        else if (numOfD < 3*numOfG) sb.append("G");
        else sb.append("DUDUDUNGA");

        // ******************** 정답 출력 ********************

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find_D(int depth, int node) {
        int numOfD = depth >= 3 ? 1 : 0;

        for (int adjNode : g.adjList[node]) {
            if (g.visited[adjNode]) continue;
            g.visited[adjNode] = true;
            numOfD += find_D(depth + 1, adjNode);
        }

        return numOfD;
    }

    public static long find_G() {
        long numOfG = 0;
        for (int i=1;i<=N;i++) {
            if (g.adjList[i].size() >= 3) numOfG += nC3(g.adjList[i].size());
        }

        return numOfG;
    }

    public static long nC3(int n) {
        return (long) n*(n-1)*(n-2)/6;
    }
}

class Graph12 {
    ArrayList<Integer>[] adjList;
    boolean[] visited;

    public Graph12(int size) {
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1; i<=size; i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge(int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }
}
