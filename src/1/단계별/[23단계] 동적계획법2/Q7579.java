// 7579번 앱
/*
<문제 정보>
 1.

<변수 범위>
 1. 1초 / 128MB
 2. 활성화 되어 있는 앱 N개 100 이하 자연수
 3. 새로운 앱 필요한 메모리 M바이트 10,000,000 이하 자연수
 4. 각각의 앱이 사용중인 메모리 바이트도 10,000,000 이하 음아닌 정수
 5. 비활성화 했을 경우 다시 활성화 하는데 비용 c 100이하 음아닌 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q7579 {
    static Integer[][] dp;
    static int[][] arr;
    static int N;
    static int M;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][2];
        dp = new Integer[10001][N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) arr[i][0] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) arr[i][1] = Integer.parseInt(st.nextToken());
        for (int i=0;i<=10000;i++) dp[i][0] = 0;
        dp[0][1] = arr[1][1]>0 ? 0 : arr[1][0];
        int ans = solve();
        /*
        for (int j=1;j<=N;j++) {
            for (int i=0;i<=ans;i++) System.out.print(dp[i][j]+" ");
            System.out.println();
        }
         */
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve() {
        boolean possible = false;
        int ans = 0;

        // i : c (재활성시 비용)
        // j : 물건
        for (int i=0;i<=10000;i++) {
            if (possible) break;
            for (int j=1;j<=N;j++) {
                if (arr[j][1]>i) dp[i][j] = dp[i][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], arr[j][0]+dp[i-arr[j][1]][j-1]);

                if (dp[i][j]>=M) {
                    possible = true;
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
}