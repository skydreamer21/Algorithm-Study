// 11049번 행렬 곱셈 순서
/*
<문제 정보>
 1.

<변수 범위>
 1. 행렬 수 1<=N<=500
 2. 행렬의 크기 r,c 500 이하의 자연수
 3. 최악의 순서로 연산해도 연산횟수가 int 맥스보다 작음
 (-> dp 원소는 int max 값 이상이 될 수 없음)

<프로그램 진행>
 1.

<필요 함수>
 1.

 */



import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q11049 {
    static int[][] dp;
    static int[][] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        dp = new int[N+1][N+1];
        arr = new int[N+1][2];

        // 행렬 정보 입력
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        // dp 채우기 -> dp[1][N]이 답
        // dp[i][j] : i번째부터 j번째 행렬까지 곱할 때 연산횟수 최솟값
        // gap : i와 j의 차이
        for (int gap=1;gap<N;gap++) {
            for (int i=1;i<=N-gap;i++) {
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                for (int k=0;k<gap;k++) {
                    dp[i][j]=Math.min(dp[i][j],dp[i][i+k]+dp[i+k+1][j]+arr[i][0]*arr[i+k][1]*arr[j][1]);
                }
            }
        }
        //for (int i=0;i<=N;i++) System.out.println(Arrays.toString(dp[i]));
        bw.write(String.valueOf(dp[1][N]));
        bw.flush();
        bw.close();
        br.close();
    }
}