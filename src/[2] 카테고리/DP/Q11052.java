// 11052번 카드구매하기 (S1)
/*
<문제 정보>
 1. N개의 카드를 딱 맞게 구입할 때 지불할 수 있는 최대 금액

<변수 범위>
 1. 1초 / 256MB
 2. 구매하려고 하는 카드 개수 N 1<=N<=1,000
 3. 카드 팩 가격 10,000이하 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q11052 {
    static int[] cost;
    static int[] dp;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cost = new int[N+1];
        for (int i=1;i<=N;i++) cost[i]=Integer.parseInt(st.nextToken());
        dp = new int[N+1];
        dp[1]=cost[1];
        bw.write(String.valueOf(solveDP(N)));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP (int card) {
        if (dp[card]==0 && card!=0) {
            dp[card]=-1;
            for (int i=card/2;i<card;i++) {
                dp[card] = Math.max(dp[card],solveDP(i)+solveDP(card-i));
            }
            dp[card] = Math.max(dp[card],cost[card]);
        }
        return dp[card];
    }
}


