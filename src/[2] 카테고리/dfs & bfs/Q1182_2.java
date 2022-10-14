// 1182번 부분수열의 합 (S2) [dfs][backtracking] [edge case s=0]
/*
<문제 정보>
 1. 부분 수열중 원소의 합이 S가 되는 경우의 수를 출력

<변수 범위>
 1. 2초 / 256MB
 2. 1<=N<=20
 3. S는 절댓값이 1,000,000 이하인 정수
 4. 주어지는 정수의 절댓값 100,000 이하

<프로그램 진행>
 1.

<필요 함수>
 1.

 */


import java.io.*;
import java.util.StringTokenizer;


public class Q1182_2 {
    static int N,S;
    static int[] arr;
    static int cnt=0;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
        dfs(0,0);
        // 아무것도 선택을 안하면 0이 나옴. S=0 이면 예외가 생김
        bw.write(String.valueOf(S==0 ? cnt-1 : cnt));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int depth, int sum) {
        if(depth==N) {
            if(sum==S) cnt++;
            return;
        }
        dfs(depth+1,sum);
        dfs(depth+1,sum+arr[depth]);
    }
}






























