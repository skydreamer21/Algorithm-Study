// 1005번 ACM Craft (G3) [DP]
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
import java.util.Arrays;

public class Q1005 {
    static int N, K;
    static int[] costs;
    static int[] minTime;
    static ArrayList<Integer>[] adjList;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int first;
        int second;
        int goal;
        while (T-- >0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            costs = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1;i<=N;i++) costs[i] = Integer.parseInt(st.nextToken());
            minTime = new int[N+1];
            Arrays.fill(minTime, -1);
            adjList = new ArrayList[N+1];
            for (int i=1;i<=N;i++) adjList[i] = new ArrayList<>();
            for (int i=1;i<=K;i++) {
                st = new StringTokenizer(br.readLine());
                first = Integer.parseInt(st.nextToken());
                second = Integer.parseInt(st.nextToken());
                adjList[second].add(first);
            }
            goal = Integer.parseInt(br.readLine());
            sb.append(solveDP(goal)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP(int building) {
        if (minTime[building] != -1) return minTime[building];

        if (adjList[building].isEmpty()) minTime[building] = 0;
        else {
            for (int b : adjList[building]) {
                minTime[building] = Math.max(minTime[building], solveDP(b));
            }
        }
        minTime[building] += costs[building];
        return minTime[building];
    }
}

/*class Order {
    ArrayList<Integer> adjList;

}*/












