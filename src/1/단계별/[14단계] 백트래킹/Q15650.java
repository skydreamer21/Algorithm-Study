// 15650 N과 M(2)

/*
<문제 정보>
 1. 1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열 (조합)
 2. 해당 수열은 오름차순이어야 한다.

<프로그램 진행>
 1. dfs / 백트래킹
 2. 재귀

<필요 함수>
 1. dfs

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q15650 {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[M];
        dfs(M,N,0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs (int M, int N, int depth) {
        if (depth == M) {
            for (int num : arr) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for (int i=0;i<N;i++) {
            if (!visited[i] && (depth==0 || i>arr[depth-1]-1)) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(M,N,depth+1);
                visited[i]=false;
            }
        }
    }
}