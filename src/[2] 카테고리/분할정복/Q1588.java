// 1588번 수열 (G1) [분할정복 & DP]
/*
<문제 정보>
 1.

<변수 범위>
 1.

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q1588 {
    static int N;
    static long one = 0;
    static long two = 0;
    static long three = 0;
    static long[][][] dp;
    static boolean[][] visited;

    static final int[][] RULE = {{1,3,2}, {2,1,1}, {2,3,2}};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // ******************** 입력 & 초기화 ********************
        int start = Integer.parseInt(br.readLine());
        int left = Integer.parseInt(br.readLine());
        int right = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1][4][3];
        visited = new boolean[N+1][4];

        // ******************** 메인 로직 ********************

        divideConquer(0, start, 0, left, right);
        /*long[] test = dp(2, 3);

        for (int i=0; i<3; i++) {
            System.out.printf("%d ", test[i]);
        }*/

        // ******************** 정답 출력 ********************
//        for (int i=1; i<=3; i++) {
//            divideConquer(0, i, 0, 0, (int) Math.pow(3, N)-1);
//        }


/*        for (int i=0; i<=N; i++) {
            for (int j=1; j<=3; j++) {
                for (int k=0; k<3; k++) {
                    System.out.printf("%d ",dp[i][j][k]);
                }
                System.out.printf("    ");
            }
            System.out.println();
        }
        System.out.println();*/

        sb.append(one).append(" ").append(two).append(" ").append(three);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void divideConquer (int depth, int number, long startIdx, int left, int right) {
        long size = (long) Math.pow(3, N-depth);
        long step = size / 3;
        long endIdx = startIdx + size - 1;
//        System.out.printf("[IN] depth : %d, number : %d, startIdx : %d, endIdx : %d, step : %d\n", depth, number, startIdx, endIdx, step);

        // 범위를 벗어났으면
        if (startIdx > right || endIdx < left) {
//            System.out.printf("[OUT - 범위를 벗어남] depth : %d, number : %d, startIdx : %d, endIdx : %d, step : %d\n", depth, number, startIdx, endIdx, step);
            return;
        }

        // 범위 안에 완전히 포함되어 있으면
        if (startIdx >= left && endIdx <= right) {
            long[] subAns = dp(N - depth, number);
            one += subAns[0];
            two += subAns[1];
            three += subAns[2];

//            System.out.printf("[OUT - 범위에 완전히 포함되어서 결과를 더해줌] depth : %d, number : %d, startIdx : %d, endIdx : %d, step : %d\n", depth, number, startIdx, endIdx, step);
//            System.out.printf("one : %d, two : %d, three : %d\n", one, two, three);
            return;
        }

        // 범위가 걸쳐 있으면
        for (int i=0; i<3; i++) {
            long newStartIdx = startIdx + (i*step);
            divideConquer(depth+1, RULE[number-1][i], newStartIdx, left, right);
        }
//        System.out.printf("[OUT - all Searched] depth : %d, number : %d, startIdx : %d, endIdx : %d, step : %d\n", depth, number, startIdx, endIdx, step);
    }


    public static long[] dp (int n, int number) {
        if (visited[n][number]) {
            return dp[n][number];
        }

        if (n == 0) {
            for (int i=0; i<3; i++) {
                if (i+1 == number) {
                    dp[n][number][i] = 1;
                }
                else dp[n][number][i] = 0;
            }
            visited[n][number] = true;
            return dp[n][number];
        }

        long[][] nextCount = new long[3][3];

        for (int i=0; i<3; i++) {
            nextCount[i] = dp(n-1, RULE[number-1][i]);
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                dp[n][number][i] += nextCount[j][i];
            }
        }

        visited[n][number] = true;
        return dp[n][number];
    }
}









