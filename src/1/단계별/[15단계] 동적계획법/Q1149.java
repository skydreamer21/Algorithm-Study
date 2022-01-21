// 1149번 RGB 거리

/*
<문제 정보>
 1. 일렬로 나열된 N개의 집에 R, G, B 세개의 색을 칠하는 데 이웃하는 집끼리 같은 색이면 안됨
 2. 각각의 집을 R, G, B를 칠하는데 드는 비용이 각각 주어질 때 모든 집을 칠하는 비용의 최솟값 출력
 3. 2<=N<=1000 / 집을 칠하는 비용은 1000 이하의 자연수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q1149 {
    static int[][] price;
    static int[][] memo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        price = new int[N+1][3];
        memo = new int[N+1][3];
        StringTokenizer st;
        for (int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<3;j++) price[i][j] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(find(N)));
        //printArr();
        bw.flush();
        bw.close();
        br.close();

    }

    public static int find (int n) {
        for (int i=1;i<=n;i++) {
            if (memo[i][0]==0) memo[i][0] = price[i][0]+Math.min(memo[i-1][1],memo[i-1][2]);
            if (memo[i][1]==0) memo[i][1] = price[i][1]+Math.min(memo[i-1][0],memo[i-1][2]);
            if (memo[i][2]==0) memo[i][2] = price[i][2]+Math.min(memo[i-1][0],memo[i-1][1]);
        }
        return Math.min(memo[n][0],Math.min(memo[n][1],memo[n][2]));
    }

    public static void printArr () {
        for (int i=1;i<memo.length;i++) {
            System.out.println(Arrays.toString(memo[i]));
        }
    }
}