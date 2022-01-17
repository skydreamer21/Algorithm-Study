// 15651 N과 M(3)

/*
<문제 정보>
 1. 1부터 N까지의 자연수 중에서 중복 포함 M개를 고른 수열 (중복순열)

<프로그램 진행>
 1. dfs / 백트래킹
 2. 재귀

<필요 함수>
 1. dfs

 */

import java.io.*;
import java.util.StringTokenizer;

public class Q15651 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
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
            arr[depth] = i+1;
            dfs(M,N,depth+1);
        }
    }
}