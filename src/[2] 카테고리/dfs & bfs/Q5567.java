// 5567번 결혼식 (S2) [그래프 탐색, bfs]
/*
<문제 정보>
 1. 친구와 친구의 친구를 초대할 때 초대하는 사람의 수

<변수 범위>
 1. 1초 / 128MB
 2. 동기의 수 2 <= n <= 500
 3. 리스트의 길이 1<= m <= 10,000

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

public class Q5567 {
    static int N;
    static Graph11 g;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        g = new Graph11(N);

        int v1, v2;
        while (M-- >0) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            g.addEdge(v1, v2);
        }

        // ******************** 메인 로직 ********************

        int numOfInvitation = getNumOfInvitation();

        // ******************** 정답 출력 ********************

        sb.append(numOfInvitation);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getNumOfInvitation() {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        g.visited[1] = true;

        int now, size;
        int dist = 0;
        int numOfInvitation = 0;

        while (!q.isEmpty() && dist < 2) {
            dist++;
            size = q.size();

            for (int i=0; i<size; i++) {
                now = q.poll();

                for (int friend : g.adjList[now]) {
                    if (!g.visited[friend]) {
                        numOfInvitation++;
                        g.visited[friend] = true;
                        q.add(friend);
                    }
                }
            }
        }

        return numOfInvitation;
    }
}

class Graph11 {
    ArrayList<Integer>[] adjList;
    boolean[] visited;

    public Graph11 (int size) {
        adjList = new ArrayList[size+1];
        visited = new boolean[size+1];
        for (int i=1; i<=size; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v1, int v2) {
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }
}


















