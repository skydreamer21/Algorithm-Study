// 10819번 차이를 최대로 (S2) [math] [backtracking]
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 256MB
 2. 3<=N<=8
 3. 배열에 들어있는 정수는 -100 이상 100 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q10819_t {
    static int N;
    static int[] arr;
    static int[] per;
    static boolean[] visited;
    static int ans=Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        per = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        dfs(0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int depth) {
        if (depth==N) {
            int sum=0;
            for (int i=0;i<N-1;i++) sum+=Math.abs(per[i]-per[i+1]);
            ans=Math.max(ans,sum);
        }
        for (int i=0;i<N;i++) {
            if(visited[i]) continue;
            per[depth]=arr[i];
            visited[i]=true;
            dfs(depth+1);
            visited[i]=false;
        }
    }
}
















