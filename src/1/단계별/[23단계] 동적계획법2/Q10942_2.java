// 10942번 팰린드롬?
/*
<문제 정보>
 1.

<변수 범위>
 1. 0.5초 / 256MB
 2. 수열의 크기 N 2,000이하의 자연수
 3. 적은 수는 100,000 이하의 자연수
 4. 질문의 개수 M 1,000,000 이하의 자연수

 --> 수열의 크기에 의해 서로 다른 질문 개수는 1,000,000개
 --> 질문 개수가 1,000,000 개라면 중복되는게 있거나 무조건 (1,7)(2,6)(3,5) 등이 포함됨
 --> 1,7 이 팰린드롬이면 2,6 / 3,5 는 검사할 필요가 없음 => 여기서 dp

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 재귀로도 짤 수 있음! 내가만든거랑 같은 발상 (첨엔 다른건줄..)

import java.io.*;
import java.util.StringTokenizer;

public class Q10942_2 {
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
            if (dp[start][end]==null) {
                //System.out.printf("start : %d, end : %d\n",start, end);
                for (int i=0;i<=(end-start)/2;i++) {
                    if(arr[start+i]!=arr[end-i]) {
                        palindrome = false;
                        dp[start][end] = false;
                        break;
                    }
                }
                if (palindrome) {
                    for (int i=0;i<=(end-start)/2;i++) dp[start+i][end-i]=true;
                }
            }
            sb.append(dp[start][end] ? 1 : 0).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}