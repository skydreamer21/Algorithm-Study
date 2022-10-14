// 10971번(S2) 외판원 순회2 [backtracking]
/*
<문제 정보>
 1. 비용이 가장적은 순회 경로 비용 출력

<변수 범위>
 1. 2초 / 256MB
 2. 도시의 수 2<=N<=10
 3. 비용 1,000,000 이하의 양의 정수
 4. 갈 수 없는 경우 0

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;


public class Q10971 {
    static int N;
    static int[][] cost;
    static int ans=Integer.MAX_VALUE;
    static boolean[] visited;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N+1][N+1];
        visited = new boolean[N+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=N;j++) cost[i][j]=Integer.parseInt(st.nextToken());
        }
        /*for (int start=1;start<=N;start++) {
            visited[start]=true;
            dfs(0,start,start,0);
            visited[start]=false;
        }*/
        visited[1]=true;
        dfs(0,1,0);
        bw.write(String.valueOf(ans)); /* 여기서 원순열이....*/
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int depth, int now, int totalCost) {
        if(totalCost>=ans) return; /* 시간을 절반 줄임 -> 불필요한 것 계산 안하기 */
//        System.out.printf("depth:%d, now:%d, totalCost:%d\n",depth,now,totalCost);
        if(depth==N-1) {
            if(cost[now][1]!=0) ans=Math.min(ans,totalCost+cost[now][1]);
//            System.out.printf("now:%d, total:%d *%d OUT*\n",now,totalCost,N);
            /*for (int i=1;i<=N;i++) System.out.printf("%b ",visited[i]);
            System.out.println();*/
            return;
        }
        for (int i=1;i<=N;i++) {
            if(visited[i] || cost[now][i]==0) continue;
            visited[i]=true;
            dfs(depth+1,i,totalCost+cost[now][i]);
            visited[i]=false;
        }
//        System.out.printf("now:%d OUT\n",now);
    }
}













