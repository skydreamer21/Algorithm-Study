// 14226번 이모티콘 (G5) <실패>
/*
<문제 정보>
 1. 이모티콘 만들기 연산
    - 화면의 모든 이코티콘을 복사 -> 클립보드 저장
    - 붙여넣기
    - 화면의 이모티콘중 한개 삭제
 2. 연산 당 1초
 3. 클립보드는 덮어쓰기
    - 비어있는 상태에서는 붙여넣기 불가
 4. 이모티콘 S개를 만드는데 걸리는 시간의 최솟값

<변수 범위>
 1. 2초 / 512MB
 2. 2<=S<=1,000

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;

public class Q14226 {
    static int S;
    static int[][] dp;
    static boolean[][] visited;
    static int time = 1;
    static int timeLimit;
    static final int INF = Integer.MAX_VALUE;

    static int debugN = 3;
    static int debugClip = 3;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        S = Integer.parseInt(br.readLine());
        dp = new int[S+1][S+1];
        visited = new boolean[S+1][S+1];
        timeLimit = S;

        if (S==1) sb.append(0);
        else sb.append(1 + solveDP(1,1)).append("\n").append(timeLimit);



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solveDP(int n, int clip) {


        // n이 S값을 넘을 땐 n 될때까지 삭제하는데 걸리는 시간을 return
        if (n==debugN && clip==debugClip) System.out.printf("[IN] n : %d, clip : %d, time : %d\n",n,clip,time);
        if (n>=S) {
//            System.out.printf("[OUT] n : %d, clip : %d\n",n,clip);
            timeLimit = Math.min(timeLimit, time + n-S);
            return n-S;
        }
        if (dp[n][clip]>0) {
//            System.out.printf("[OUT] n : %d, clip : %d\n",n,clip);
            return dp[n][clip];
        }
        if (dp[n][clip]<0 && dp[n][clip] + time>=0) {
            return dp[n][clip];
        }

        visited[n][clip] = true;
        time++;
        boolean isIgnored = true;
        dp[n][clip] = INF;

        if (time>=timeLimit) {
//            visited[n][clip] = true;
            time--;
//            System.out.printf("[OUT] n : %d, clip : %d\n",n,clip);
            dp[n][clip] = 0;
            if (n==debugN && clip==debugClip) System.out.println("out");
            return INF;
        }
        // dp[n][clip]이 계산되는 도중에 재방문이 일어나서는 안됨
        if (n!=1 && !visited[n-1][clip] && solveDP(n-1, clip)!=INF && solveDP(n-1, clip)>=0) {
            dp[n][clip] = 1 + solveDP(n-1, clip);
            isIgnored = false;
        }
        if (n==debugN && clip==debugClip) System.out.printf("ans : %d\n" ,dp[n][clip]);

        if (clip!=0 && solveDP(n+clip,clip)!=INF && solveDP(n+clip,clip)>=0) {
            dp[n][clip] = Math.min(dp[n][clip], 1 + solveDP(n+clip,clip));
            isIgnored = false;
        }
        if (n==debugN && clip==debugClip) System.out.printf("ans : %d\n" ,dp[n][clip]);

        if (n!=clip && !visited[n][n] && solveDP(n,n)!=INF && solveDP(n,n)>=0) {
            dp[n][clip] = Math.min(dp[n][clip], 1 + solveDP(n,n));
        }
        if (n==debugN && clip==debugClip) System.out.printf("ans : %d\n" ,dp[n][clip]);


//        System.out.printf("[OUT] n : %d, clip : %d\n",n,clip);
        visited[n][clip] = false;
        time--;
        if (isIgnored) dp[n][clip] = -time;
        return dp[n][clip];
    }

}












