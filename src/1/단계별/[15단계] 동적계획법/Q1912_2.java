// 1912번 연속 합(2)

/*
<문제 정보>
 1. N개의 수로 이루어진 수열에서 연속된 몇개의 수의 합이 최대가 될 때 최대값을 출력
 2. 1<=N<=100,000   각 수는 절댓값이 1000이하인 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1912_2 {
    static int[] arr;
    static int[] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        memo = new int[N+1];

        for (int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        memo[1]=arr[1];

        //bw.write(Arrays.toString(memo));
        //bw.newLine();
        int max = memo[1];
        for (int i=1;i<=N;i++) {
            memo[i]=Math.max(arr[i], memo[i-1]+arr[i]);
            max = Math.max(max,memo[i]);
        }
        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }
    /*
    public static int find_to_N (int n) {
        int max = memo[1];
        for (int i=1;i<=n;i++) {
            memo[i]=Math.max(arr[i], memo[i-1]+arr[i]);
            max = Math.max(max,memo[i]);
        }
        return max;
    }

     */
}