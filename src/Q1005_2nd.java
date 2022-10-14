// 1005번 ACM Craft
/*
<문제 정보>
 1. 특정 건물을 가장 빨리 지을 때까지 걸리는 최소시간 출력

<변수 범위>
 1. 1초 / 512MB

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Q1005_2nd {
    static int N, K;
    static int[] timeForBuild;
    static int[] dp;
    static DGraph1 g;

    static final int EMPTY = -1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // ******************** 입력 & 초기화 ********************

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            timeForBuild = new int[N+1];
            dp = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1;i<=N;i++) timeForBuild[i] = Integer.parseInt(st.nextToken());
            g = new DGraph1(N);
            int from, to;
            while (K-- >0) {
                st = new StringTokenizer(br.readLine());
                to = Integer.parseInt(st.nextToken());
                from = Integer.parseInt(st.nextToken());
                g.addEdge(from, to);
            }
            int goal = Integer.parseInt(br.readLine());

            // ******************** 메인 로직 ********************
            Arrays.fill(dp, EMPTY);
            int minTime = getBuildTime(goal);

            // ******************** 정답 출력 ********************
            sb.append(minTime).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getBuildTime (int building) {
        if (dp[building] != EMPTY) return dp[building];

        dp[building] = timeForBuild[building];
        int minTime = 0;
        for (int bld : g.adjList[building]) {
            minTime = Math.max(minTime, getBuildTime(bld));
        }
        if (minTime != Integer.MAX_VALUE) dp[building] += minTime;
        return dp[building];
    }
}

class DGraph1 {
    ArrayList<Integer>[] adjList;
    boolean[] visited;

    public DGraph1 (int size) {
        adjList = new ArrayList[size + 1];
        visited = new boolean[size + 1];
        for (int i=1;i<=size; i++) adjList[i] = new ArrayList<>();
    }

    public void addEdge (int from, int to) {
        this.adjList[from].add(to);
    }
}











