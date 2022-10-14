// 14002번 가장 긴 증가하는 부분 수열 4
/*
<문제 정보>
 1. LIS
 2. 둘째줄에 증가하는 부분 수열 출력

<변수 범위>
 1. 수열의 크기 1<=N<=1,000
 2. 각 수열의 수 범위도 위와 동일

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q14002 {
    static int[] arr;
    static int[] dp;
    static int[] path;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];
        path = new int[N];
        for (int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int LIS_len = solve();
        int[] LIS = new int[dp[LIS_len]];
        int idx = LIS.length-1;
        //System.out.println(Arrays.toString(dp));
        //System.out.println(Arrays.toString(path));
        sb.append(dp[LIS_len]).append("\n");
        LIS[idx--] = arr[LIS_len];
        for (int i=LIS_len;i>=0;i--) {
            if(arr[i] == path[LIS_len]) {
                LIS_len = i;
                LIS[idx--] = arr[LIS_len];
            }
        }
        for (int n : LIS) sb.append(n).append(" ");
        //System.out.println(Arrays.toString(LIS));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve() {
        int max = 0;
        int maxIdx=0;
        for (int i=0;i<N;i++) {
            dp[i]=1;
            for (int j=0;j<i;j++) {
                if (arr[i]>arr[j] && dp[j]+1>dp[i]) {
                    dp[i] = dp[j]+1;
                    path[i] = arr[j];
                }
            }
            if(dp[i]>max) {
                max = dp[i];
                maxIdx=i;
            }
        }
        return maxIdx;
    }
}
