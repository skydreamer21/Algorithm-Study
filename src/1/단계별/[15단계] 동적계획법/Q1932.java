// 1932번 정수 삼각형

/*
<문제 정보>
 1. 크기가 N인 삼각형에서 맨 위 N층부터 숫자를 하나씩 선택해서 내려올 때,
 경로에 있는 숫자의 합 중 최댓값을 출력
 2. 1<=N<=500 / 삼각형을 이루고 있는 각 수 0이상 9999이하 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// <주의> 입력값에 0이 포함될 때는 memo[] = 0 이라는 조건문이 오작동함


import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1932 {
    static int[][] tri;
    static int[][] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tri = new int[N+1][N+1];
        memo = new int[N+1][N+1];
        for (int i=0;i<=N;i++) Arrays.fill(memo[i],-1);
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1;j<=i;j++) tri[i][j]=Integer.parseInt(st.nextToken());
        }
        memo[1][1]=tri[1][1];
        fillMemo(N);
        bw.write(String.valueOf(findMax_in_N_row(N)));
        bw.flush();
        bw.close();
        br.close();

    }

    public static int find (int n, int m) {
        if (memo[n][m]==-1) {
            if (m==1) memo[n][m]=find(n-1,1)+tri[n][m];
            else if (m==n) memo[n][m]=find(n-1,n-1)+tri[n][m];
            else memo[n][m]=Math.max(find(n-1,m-1),find(n-1,m))+tri[n][m];
        }
        return memo[n][m];
    }

    public static void fillMemo (int n) {
        for (int i=1;i<=n;i++) memo[n][i]=find(n,i);
    }

    public static int findMax_in_N_row (int n) {
        int max=memo[n][1];
        for (int num : memo[n]) max = Math.max(max,num);
        return max;
    }
}