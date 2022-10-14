// 13913번 숨바꼭질4
/*
<문제 정보>
 1. X+1, X-1, 2X로 이동가능
 2. 동생을 가장 빠른 시간과 어떻게 이동해야하는지 출력

<변수 범위>
 1. 2초 / 512MB
 2. 수빈이 현재 점 0<=N<=100,000
 3. 동생 현재 점 0<=K<=100,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q13913_2 {
    static int[] dp = new int[100001];
    static int[] path = new int[100001];
    int cnt=100000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Arrays.fill(dp,-1);
        dp[K]=0;
        sb.append(solve(N));



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // dfs 라서 재귀는 너무 깊음
    // for문으로는 애초에 구성을 못함. (K부터 시작하면 할 수는 있는데 그러면 똑같은 구성이 됨)
    public static int solve(int n) {
        if(dp[n]==-1) {
            dp[n] = 100000;
            for (int i=0;i<3;i++) {
                switch(i) {
                    case 0 :
                        if (n-1>=0) dp[n]=Math.min(dp[n],solve(n-1)+1);
                        break;
                    case 1 :
                        if (n+1<=100000) dp[n]=Math.min(dp[n],solve(n+1)+1);
                        break;
                    case 2 :
                        if (2*n<=100000) dp[n]=Math.min(dp[n],solve(2*n)+1);
                }
            }
        }
        return dp[n];
    }

}



















