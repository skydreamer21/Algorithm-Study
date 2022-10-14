// 11726번 2 x n 타일링 (S3)
/*
<문제 정보>
 1. 2 x n 크기의 직사각형을 2x1, 1x2 크기의 직사각형으로 채우는 방법의 수 출력

<변수 범위>
 1. 1초 / 256MB
 2. 1<=n<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q11726 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        dp[1]=1;
        if(N>1) dp[2]=2;
        for (int i=3;i<=N;i++) dp[i]=(dp[i-1]+dp[i-2])%10007;
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}
















