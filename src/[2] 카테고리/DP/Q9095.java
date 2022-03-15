// 9095번 1,2,3 더하기 (S3)
/*
<문제 정보>
 1. 정수 n을 1,2,3의 합으로 나타내는 방법의 수

<변수 범위>
 1. 1초 / 512MB
 2. n은 11보다 작거나 같은 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
public class Q9095 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1]=1; dp[2]=2; dp[3]=4;
        for (int i=4;i<=10;i++) dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        while(T-->0) sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}












