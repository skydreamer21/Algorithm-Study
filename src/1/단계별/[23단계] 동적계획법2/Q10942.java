// 10942번 팰린드롬?
/*
<문제 정보>
 1.

<변수 범위>
 1. 0.5초 / 256MB
 2. 수열의 크기 N 2,000이하의 자연수
 3. 적은 수는 100,000 이하의 자연수
 4. 질문의 개수 M 1,000,000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;

public class Q10942 {
    static Boolean[][] dp;
    static int[] arr;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new Boolean[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int start; int end;
        boolean palindrome;
        while(M-- >0) {
            st = new StringTokenizer(br.readLine());
            palindrome = true;
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            for (int i=0;i<=(end-start)/2;i++) {
                if(arr[start+i]!=arr[end-i]) {
                    palindrome = false;
                    break;
                }
            }
            sb.append(palindrome ? 1 : 0).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
/*
    public static void makeDP() {
        for (int i=0;i<N;i++) {
            for (int j=i+1;j<=N;j++) dp[i+1][j] = arr[i+1]==arr[j];
        }
    }
 */
}