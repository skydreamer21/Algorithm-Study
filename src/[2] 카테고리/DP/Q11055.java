// 11055번 가장 큰 증가 부분 수열(S5) [dp]
/*
<문제 정보>
 1. 합이 가장 큰 증가 부분 수열의 합을 출력

<변수 범위>
 1. 1초 / 256MB
 2. 수열의 크기 1<=N<=1,000
 3. 수열의 각 숫자 1<=N<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q11055 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        int max=0;
        String[] tmp = br.readLine().split(" ");
        for (int i=1;i<=N;i++) {
            arr[i]=Integer.parseInt(tmp[i-1]);
            dp[i]=arr[i];
            for (int j=1;j<i;j++) {
                if(arr[i]>arr[j]) dp[i]=Math.max(dp[i],dp[j]+arr[i]);
            }
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
        br.close();
    }
}
