// 12865 평범한 배낭
/*
<문제 정보>
 1. 최대 K만큼의 무게를 넣을 수 있는 가방에 각각의 가치(V)와 무게(W)가 주어진
 N개의 물건이 있다. 가방에 가치의 합이 최대가 되도록 물건 넣을 때 가치의 최댓값 출력
 2. 1<=N<=100  /  1<=K<=100,000  /  1<=W<=100,000  /  0<=V<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q12865 {
    final static int W = 0;
    final static int V = 1;
    static int N;
    static int K;
    static int[][] arr;
    static Integer[][] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][2];
        memo = new Integer[N+1][K+1];
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][W]=Integer.parseInt(st.nextToken());
            arr[i][V]=Integer.parseInt(st.nextToken());
        }
        initValue();
        int max = 0;
        for (int i=1;i<=K;i++) max = Math.max(max, find(N,i));
        bw.write(String.valueOf(max));
        /*
        bw.newLine();
        for (int i=0;i<=N;i++) {
            bw.write(Arrays.toString(memo[i]));
            bw.newLine();
        }
         */
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find (int n, int k) {
        if(memo[n][k]==null) {
            if (k<arr[n][W]) memo[n][k] = find(n-1,k);
            else if (k==arr[n][W]) memo[n][k] = Math.max(find(n-1,k),arr[n][V]);
            else if (find(n-1,k-arr[n][W])!=0) {
                memo[n][k] = Math.max(find(n-1,k),find(n-1,k-arr[n][W])+arr[n][V]);
            }
            else memo[n][k] = find(n-1,k);
        }
        return memo[n][k];
    }

    public static void initValue() {
        for (int i=1;i<=K;i++) {
            if (i!=arr[1][W]) memo[1][i]=0;
            else memo[1][i]=arr[1][V];
        }
    }
}