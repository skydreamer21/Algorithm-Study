// 2740번 행렬 곱셈
/*
<문제 정보>
 1. N*M 크기의 행렬과 M*K 크기 행렬 을 곱하는 프로그램 작성
 2. 두 행렬의 row와 col은 100 이하 자연수, 행렬의 원소는 100이하의 정수

<프로그램 진행>
 1.

<필요 함수>
 1.

 */

// 분할 정복으로는 슈트라센의 방법을 이용함
// 그러나 해당방법이 정말 큰 N에 대하여 효과를 봄
// 그래서 만약 쓴다면 일정 크기 이하로 행렬이 쪼개졌을 때 반복문으로 푸는 것을 채택함.
// https://st-lab.tistory.com/245 코드에서 행렬을 다루는 몇가지 함수가 있으니 참고

import java.io.*;
import java.util.StringTokenizer;

public class Q2740 {
    static int[][] A;
    static int[][] B;
    //static int[][] result;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++) A[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<K;j++) B[i][j] = Integer.parseInt(st.nextToken());
        }
        //result = new int[N][K];
        for (int i=0;i<N;i++) {
            for (int j=0;j<K;j++) sb.append(getXY(i,j,M)).append(" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getXY(int x, int y, int M) {
        int ans=0;
        for (int i=0;i<M;i++) {
            ans+=A[x][i]*B[i][y];
        }
        return ans;
    }

}